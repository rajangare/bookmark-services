package com.assignment.controller;

import com.assignment.port.BookmarkGroupPort;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(value = BookmarkGroupController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class BookmarkGroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookmarkGroupPort bookmarkGroupPort;

    @Before
    public void setup() {
    }

    @Test
    @DisplayName("Should find all the groups - success")
    public void findAllCards_test() throws Exception {

    }

}