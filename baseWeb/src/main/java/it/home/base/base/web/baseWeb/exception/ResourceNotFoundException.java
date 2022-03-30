package it.home.base.base.web.baseWeb.exception;

public class ResourceNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String mess) {
        super(mess);
    }
}
