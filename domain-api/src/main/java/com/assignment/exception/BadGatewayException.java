package com.assignment.exception;

public class BadGatewayException extends BookmarkException {

    public BadGatewayException() {
        super();
    }

    public BadGatewayException(String messageCode, String message, BookmarkError bookmarkError) {
        super(messageCode, message, bookmarkError);
    }

    public BadGatewayException(String messageCode, String message) {
        super(messageCode, message);
    }

    public BadGatewayException(String messageCode, String message, Throwable cause) {
        super(messageCode, message, cause);
    }

    public BadGatewayException(String messageCode, String message, Object... parameters) {
        super(messageCode, message, parameters);
    }

    public BadGatewayException(String messageCode, String message, Throwable cause, Object... parameters) {
        super(messageCode, message, cause, parameters);
    }
}
