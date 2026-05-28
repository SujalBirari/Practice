package Exceptions;

public class BookAlreadyIssued extends BookException {
    public BookAlreadyIssued(String message) {
        super(message);
    }
}
