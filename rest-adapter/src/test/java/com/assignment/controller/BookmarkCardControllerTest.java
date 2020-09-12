package com.assignment.controller;

import com.assignment.model.BookmarkCardDto;
import com.assignment.port.BookmarkCardPort;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = BookmarkCardController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookmarkCardControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookmarkCardPort bookmarkCardPort;

    @Before
    public void setup() {
    }

    @Test
    @DisplayName("Should find all the cards - success")
    public void findAllCards_test() throws Exception {
        Mockito.when(bookmarkCardPort.findAllBookmarkCards()).thenReturn(getBookmarkCardList());
        mockMvc.perform(get("/api/v1/bookmark-management/cards").contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Should find one card by Id- success")
    public void findCardById_test() throws Exception {
        Mockito.when(bookmarkCardPort.findAllBookmarkCards()).thenReturn(getBookmarkCardList());
        mockMvc.perform(get("/api/v1/bookmark-management/cards/1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    private List<BookmarkCardDto> getBookmarkCardList() {
        List<BookmarkCardDto> bookmarkCardDtoList = new ArrayList<>();
        BookmarkCardDto bookmarkCardDto1 = new BookmarkCardDto();
        bookmarkCardDto1.setId(new Long(1));
        bookmarkCardDto1.setTitle("Title1");
        bookmarkCardDtoList.add(bookmarkCardDto1);

        BookmarkCardDto bookmarkCardDto2 = new BookmarkCardDto();
        bookmarkCardDto2.setId(new Long(2));
        bookmarkCardDto2.setTitle("Title2");
        bookmarkCardDtoList.add(bookmarkCardDto2);

        return bookmarkCardDtoList;
    }

}