package com.assignment.exception;

import com.assignment.constants.BookmarkEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.Objects;

@RestControllerAdvice(basePackages = {"com.assignment"})
public class BookmarkExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookmarkException.class)
    public ResponseEntity<String> handleBookmarkException(BookmarkException exception, WebRequest request) {
        return handleGenericException(exception, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private ResponseEntity<String> handleGenericException(BookmarkException exception, HttpStatus status, WebRequest request) {
        BookmarkError bookmarkError = BookmarkError.builder().code(status.getReasonPhrase())
                .source(String.format("%s/%s", BookmarkEnum.BOOKMARK.getValue(), "bookmark-service"))
                .statusCode(status.value())
                .message(exception.getMessage()).messageCode(exception.getMessageCode())
                .target(request.getDescription(true)).build();

        if (Objects.nonNull(exception.getBookmarkError())) {
            bookmarkError.setDetails(Collections.singletonList(exception.getBookmarkError()));
        }

        logger.error(bookmarkError.toJson());

        return ResponseEntity.status(status).contentType(MediaType.APPLICATION_JSON).body(bookmarkError.toJson());
    }
}

