import Exceptions.BookAlreadyIssued;
import Exceptions.BookAlreadyReturned;
import Exceptions.BookNotFound;

import java.io.*;
import java.util.*;

public class LibraryManager {
    private Map<Integer, Book> books = new HashMap<>();
    File file = new File("Books.dat");
    private int nextId = 1;

    public LibraryManager() {
        loadFromFile();
    }

    private void loadFromFile() {
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                boolean isIssued = Boolean.parseBoolean(parts[3]);

                Book book = new Book(id, title, author);
                book.setIssued(isIssued);

                books.put(id, book);

                nextId = Math.max(nextId, id + 1);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Book book : books.values()) {
                writer.write(
                        book.getId() + "|" +
                                book.getTitle() + "|" +
                                book.getAuthor() + "|" +
                                book.isIssued()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addBook(String title, String author) {
        Book book = new Book(nextId++, title, author);
        books.put(book.getId(), book);

        System.out.println("Book added!");
        saveToFile();
    }

    public void removeBookById(int id) {
        Book removed = books.remove(id);

        if (removed == null) {
            throw new BookNotFound("Book with id " + id + " not found!");
        }

        System.out.println("Book removed!");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(removed.getTitle() + " removed.");
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void issueBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            throw new BookNotFound("Book with id " + bookId + " not found!");
        }

        if (book.isIssued()) {
            throw new BookAlreadyIssued("Book already issued!");
        }

        book.setIssued(true);
        System.out.println("Book issued!");
    }

    public void returnBook(int bookId) {
        Book book = books.get(bookId);

        if (book == null) {
            throw new BookNotFound("Book with id " + bookId + " not found!");
        }

        if (!book.isIssued()) {
            throw new BookAlreadyReturned("Book already returned!");
        }

        book.setIssued(false);
        System.out.println("Book returned!");
    }

    public void viewAllBooks() {
//        for (Book book: books.values()) {
//            System.out.println(book.toString());
//        }

        books.values().forEach(System.out::println);
    }

    public void viewAvailableBooks() {
//        for (Book book: books.values()) {
//            if (book.isIssued()) {
//                System.out.println(book.toString());
//            }
//        }

        // using Java 8 features
        books.values()
                .stream()
                .filter(book -> !book.isIssued())
                .forEach(System.out::println);
    }

    public List<Book> findBookByAuthor(String author) {
        List<Book> result = books.values()
                .stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .toList();

        if (result.isEmpty()) {
            throw new BookNotFound("No books found for author: " + author);
        }

        return result;
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> result = books.values()
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .toList();

        if (result.isEmpty()) {
            throw new BookNotFound("No books found for title: " + title);
        }

        return result;
    }

    public List<Book> sortByTitle() {
        return books.values()
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();
    }
}
