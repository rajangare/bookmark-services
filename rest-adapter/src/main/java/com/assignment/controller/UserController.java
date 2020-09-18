package com.assignment.controller;


import com.assignment.model.UserDto;
import com.assignment.port.UserPort;
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
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserPort userPort;

    public UserController(UserPort userPort) {
        this.userPort = userPort;
    }

    @GetMapping("/users")
    @Operation(summary = "Get all bookmark card users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "201", description = "Card user created", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<List<UserDto>> findAllBookmarkUsers() {
        LOGGER.info("Get all bookmark card users.");

        return new ResponseEntity<>(userPort.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    @Operation(summary = "Get a bookmark card user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark group created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<UserDto> findBookmarkCardUserById(@PathVariable(value = "userId", required = true) Long userId) {
        LOGGER.info("Get bookmark card group by Id.");

        if (userId == null || userId ==0) {
            LOGGER.info("Invalid bookmark card user Id.");

            return new ResponseEntity<>(new UserDto(), HttpStatus.OK);
        }

        return new ResponseEntity<>(userPort.findUserById(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/users", headers = "Accept=application/json")
    @Operation(summary = "Add new bookmark card user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark user created !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<UserDto> createBookmarkUser(@Valid @RequestBody(required = true) UserDto UserDto) {
        LOGGER.info("Create bookmark card  group.");

        if(UserDto == null) {
            LOGGER.info("Invalid input cannot be saved.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userPort.saveOrUpdateUser(UserDto), HttpStatus.CREATED);
    }

    @PutMapping(value = "/users/{userId}", headers = "Accept=application/json")
    @Operation(summary = "Modify bookmark card group.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark group updated ", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<UserDto> updateBookmarkCardUser(@Valid @RequestBody(required = true) UserDto UserDto, @PathVariable(value = "userId", required = true) Long userId) {
        LOGGER.info("Modify bookmark card user.");

        if(UserDto == null || 0 == userId) {
            LOGGER.info("Invalid input cannot be updated.");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        UserDto.setId(userId);
        return new ResponseEntity<>(userPort.saveOrUpdateUser(UserDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{userId}")
    @Operation(summary = "Delete bookmark card group user Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "201", description = "Bookmark User deleted !", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class))}),
            @ApiResponse(responseCode = "401", description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found")})
    public ResponseEntity<Integer> deleteBookmarkGroupById(@PathVariable(value = "userId", required = true) Long userId) {
        LOGGER.info("Delete bookmark card group by Id.");

        if (userId == null || userId ==0) {
            LOGGER.info("Invalid bookmark card group Id.");

            return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
        }

        userPort.deleteUser(userId);

        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
