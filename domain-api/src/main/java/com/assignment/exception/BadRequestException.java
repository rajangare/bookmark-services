package com.assignment.exception;

public class BadRequestException extends BookmarkException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String messageCode, String message, BookmarkError bookmarkError) {
        super(messageCode, message, bookmarkError);
    }

    public BadRequestException(String messageCode, String message) {
        super(messageCode, message);
    }

    public BadRequestException(String messageCode, String message, Throwable cause) {
        super(messageCode, message, cause);
    }

    public BadRequestException(String messageCode, String message, Object... parameters) {
        super(messageCode, message, parameters);
    }

    public BadRequestException(String messageCode, String message, Throwable cause, Object... parameters) {
        super(messageCode, message, cause, parameters);
    }
}
