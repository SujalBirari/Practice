package Exceptions;

public class BookAlreadyReturned extends BookException {
    public BookAlreadyReturned(String message) {
        super(message);
    }
}
