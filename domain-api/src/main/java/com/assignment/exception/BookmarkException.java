package com.assignment.exception;

import lombok.Getter;

import java.util.*;

@Getter
public class BookmarkException extends RuntimeException {
    private final BookmarkError bookmarkError;

    private final String messageCode;

    private final transient List<Object> parameters = new ArrayList<>();

    public BookmarkException() {
        super();
        this.bookmarkError = null;
        this.messageCode = null;
    }

    public BookmarkException(String messageCode, String message, BookmarkError bookmarkError) {
        super(message);
        this.bookmarkError = bookmarkError;
        this.messageCode = messageCode;
    }

    public BookmarkException(String messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
        this.bookmarkError = null;
    }

    public BookmarkException(String messageCode, String message, Throwable cause) {
        super(message, cause);
        this.messageCode = messageCode;
        this.bookmarkError = null;
    }

    public BookmarkException(String messageCode, String message, Object... parameters) {
        super(message);
        this.messageCode = messageCode;
        this.bookmarkError = null;
        addParameters(parameters);
    }

    public BookmarkException(String messageCode, String message, Throwable cause, Object... parameters) {
        super(message, cause);
        this.messageCode = messageCode;
        this.bookmarkError = null;
        addParameters(parameters);
    }

    private void addParameters(Object[] parameters) {
        if (null != parameters) {
            if(1 == parameters.length && parameters[0] instanceof Collection) {
                this.parameters.addAll((Collection<?>) parameters[0]);
            } else {
                this.parameters.addAll(Arrays.asList(parameters));
            }
        }
    }
}
