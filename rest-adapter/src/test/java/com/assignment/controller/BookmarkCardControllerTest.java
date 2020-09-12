package com.assignment.controller;

import com.assignment.port.BookmarkCardPort;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(value = BookmarkCardController.class)
//@SpringBootTest(classes = ApplicationTest.class)
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
    public void findAllCards_test() {
        //Mockito.when(bookmarkCardPort.findAllBookmarkCards()).thenReturn(new ArrayList<>());

        //mockMvc.perform()
    }

}