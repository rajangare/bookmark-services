package com.assignment.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookmarkError implements Serializable {

    @JsonProperty
    private String source;

    @JsonProperty
    private String code;

    @JsonProperty
    private Integer statusCode;

    @JsonProperty
    private String message;

    @JsonProperty
    private String messageCode;

    @JsonProperty
    private String target;

    private List<BookmarkError> details;

    public void add(BookmarkError bookmarkError) {
        if (this.details == null) {
            this.details = new ArrayList<>();
        }

        this.details.add(bookmarkError);
    }

    public String toJson() {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json;

        try {
            json = objectWriter.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            json = e.getMessage();
        }

        return json;
    }
}
