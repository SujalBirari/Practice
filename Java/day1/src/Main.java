import java.util.List;
import java.util.Scanner;

public class Main {
    static LibraryManager libraryManager = new LibraryManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Book Management System");

        menu();

        scanner.close();
    }

    static void menu() {
        while (true) {
            System.out.println();
            System.out.println("======MENU======");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Books");
            System.out.println("6. View Available Books");
            System.out.println("7. Search Book By Title");
            System.out.println("8. Search Book By Author");
            System.out.println("0. Exit");

            System.out.println();
            System.out.print("Select an option: ");
            int input =  scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    libraryManager.addBook(title, author);
                    break;

                case 2:
                    System.out.print("Enter Book Id: ");
                    int  bookId = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.removeBookById(bookId);
                    break;

                case 3:
                    System.out.print("Enter Book Id: ");
                    int idToIssue  = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.issueBook(idToIssue);
                    break;

                case 4:
                    System.out.print("Enter Book Id: ");
                    int idToReturn = scanner.nextInt();
                    scanner.nextLine();
                    libraryManager.returnBook(idToReturn);
                    break;

                case 5:
                    libraryManager.viewAllBooks();
                    break;

                case 6:
                    libraryManager.viewAvailableBooks();
                    break;

                case 7:
                    System.out.print("Enter Book Title: ");
                    String bookTitle = scanner.nextLine();
                    List<Book> booksByTitle = libraryManager.findBookByTitle(bookTitle);
                    System.out.println(booksByTitle);
                    break;

                case 8:
                    System.out.print("Enter Book Author: ");
                    String bookAuthor = scanner.nextLine();
                    List<Book> booksByAuthor = libraryManager.findBookByAuthor(bookAuthor);
                    System.out.println(booksByAuthor);
                    break;

                case 0:
                    System.out.println("Thanks for using LMS!");
                    return;
            }
        }
    }
}
