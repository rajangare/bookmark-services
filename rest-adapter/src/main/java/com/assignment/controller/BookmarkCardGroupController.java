package com.assignment.controller;


import com.assignment.model.BookmarkCardGroupDto;
import com.assignment.port.BookmarkCardGroupPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmark-management")
public class BookmarkCardGroupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkCardGroupController.class);

    private final BookmarkCardGroupPort bookmarkCardGroupPort;

    public BookmarkCardGroupController(BookmarkCardGroupPort bookmarkCardGroupPort) {
        this.bookmarkCardGroupPort = bookmarkCardGroupPort;
    }

    @GetMapping("/groups")
    @Operation(summary = "Get all bookmark card groups")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "201", description = "Card Group created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<List<BookmarkCardGroupDto>> findAllBookmarkCardGroups() {
        LOGGER.info("Get all bookmark card groups.");

        return new ResponseEntity<>(bookmarkCardGroupPort.findAllCardGroups(), HttpStatus.OK);
    }

    @GetMapping("/groups/{cardGroupId}")
    @Operation(summary = "Get a bookmark card group by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark group created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardGroupDto> findBookmarkCardGroupById(@PathVariable(value = "cardGroupId", required = true) Long cardGroupId) {
        LOGGER.info("Get bookmark card group by Id.");

        if (cardGroupId == null || cardGroupId ==0) {
            LOGGER.info("Invalid bookmark card group Id.");

            return new ResponseEntity<>(new BookmarkCardGroupDto(), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookmarkCardGroupPort.findCardGroupById(cardGroupId), HttpStatus.OK);
    }

    @PostMapping(value = "/groups", headers = "Accept=application/json")
    @Operation(summary = "Add new bookmark card group")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark group created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardGroupDto> createBookmarkCardGroup(@Valid @RequestBody(required = true) BookmarkCardGroupDto bookmarkCardGroupDto) {
        LOGGER.info("Create bookmark card  group.");

        if(bookmarkCardGroupDto == null) {
            LOGGER.info("Invalid input cannot be saved.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(bookmarkCardGroupPort.saveOrUpdateCardGroup(bookmarkCardGroupDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/groups/{cardGroupId}", headers = "Accept=application/json")
    @Operation(summary = "Modify bookmark card group.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark group updated ", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = BookmarkCardGroupDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<BookmarkCardGroupDto> updateBookmarkCardGroup(@Valid @RequestBody(required = true) BookmarkCardGroupDto bookmarkCardGroupDto, @PathVariable(value = "cardGroupId", required = true) Long cardGroupId) {
        LOGGER.info("Modify bookmark card.");

        if(bookmarkCardGroupDto == null || 0 == cardGroupId) {
            LOGGER.info("Invalid input cannot be updated.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        bookmarkCardGroupDto.setId(cardGroupId);
        return new ResponseEntity<>(bookmarkCardGroupPort.saveOrUpdateCardGroup(bookmarkCardGroupDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/groups/{cardGroupId}")
    @Operation(summary = "Delete bookmark card group by group Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark deleted !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<Integer> deleteBookmarkGroupById(@PathVariable(value = "cardGroupId", required = true) Long cardGroupId) {
        LOGGER.info("Delete bookmark card group by Id.");

        if (cardGroupId == null || cardGroupId ==0) {
            LOGGER.info("Invalid bookmark card group Id.");

            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }

        bookmarkCardGroupPort.deleteCardGroup(cardGroupId);

        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
