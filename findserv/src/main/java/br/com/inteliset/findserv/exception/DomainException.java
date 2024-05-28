package br.com.inteliset.findserv.exception;

public class DomainException extends RuntimeException{

    public DomainException() {
        super("Exception Domain");
    }
    public DomainException(String message) {
        super(message);
    }

}
