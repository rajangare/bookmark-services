package com.assignment.controller;

import com.assignment.model.BookmarkCardDto;
import com.assignment.port.BookmarkCardPort;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkCardController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkCardController.class);

    private final BookmarkCardPort bookmarkCardPort;

    public BookmarkCardController(BookmarkCardPort bookmarkCardPort) {
        this.bookmarkCardPort = bookmarkCardPort;
    }

    @GetMapping("/cards")
    @Operation(summary = "Get all bookmark cards")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<List<BookmarkCardDto>> findAllBookmarkCards() {
        LOGGER.info("Get all bookmark cards.");

        return new ResponseEntity<>(bookmarkCardPort.findAllBookmarkCards(), HttpStatus.OK);
    }

    @GetMapping("/cards/{bookmarkId}")
    @Operation(summary = "Get a bookmark card by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardDto> findBookmarkCardById(@PathVariable(value = "bookmarkId", required = true) Long bookmarkId) {
        LOGGER.info("Get bookmark card by Id.");

        if (bookmarkId == null || bookmarkId ==0) {
            LOGGER.info("Invalid bookmark card Id.");

            return new ResponseEntity<>(new BookmarkCardDto(), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookmarkCardPort.findBookmarkCardById(bookmarkId), HttpStatus.OK);
    }

    @PostMapping(value = "/card/add", headers = "Accept=application/json")
    @Operation(summary = "Add new bookmark card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark updated !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardDto> createBookmarkCard(@Valid @RequestBody BookmarkCardDto bookmarkCardDto) {
        LOGGER.info("Create bookmark card.");

        if(bookmarkCardDto == null) {
            LOGGER.info("Invalid input cannot be saved.");
            return new ResponseEntity<>(bookmarkCardDto, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bookmarkCardPort.saveOrUpdateBookmarkCard(bookmarkCardDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/card/edit", headers = "Accept=application/json")
    @Operation(summary = "Modify bookmark card")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark updated !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardDto> updateBookmarkCard(@Valid @RequestBody BookmarkCardDto bookmarkCardDto) {
        LOGGER.info("Modify bookmark card.");

        if(bookmarkCardDto == null) {
            LOGGER.info("Invalid input cannot be edited.");
            return new ResponseEntity<>(bookmarkCardDto, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bookmarkCardPort.saveOrUpdateBookmarkCard(bookmarkCardDto),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/card/{bookmarkId}")
    @Operation(summary = "Delete bookmark card by bookmark Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark updated !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<Integer> deleteBookmarkById(@PathVariable(value = "bookmarkId", required = true) Long bookmarkId) {
        LOGGER.info("Delete bookmark card by Id.");

        if (bookmarkId == null || bookmarkId ==0) {
            LOGGER.info("Invalid bookmark card Id.");

            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }

        bookmarkCardPort.deleteBookmarkCard(bookmarkId);

        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
