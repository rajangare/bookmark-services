package com.assignment.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkRestController {


    @GetMapping("/demo")
    @Operation(summary = "Get bookmarks demo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the bookmark",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Bookmark not found", content = @Content)})
    public ResponseEntity<String> demo() {
        return new ResponseEntity<>("<h2>Welcome to Bookmark Demo !</h2>", HttpStatus.OK);
    }
}
