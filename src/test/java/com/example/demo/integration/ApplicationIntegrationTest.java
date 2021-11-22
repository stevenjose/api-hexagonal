package com.example.demo.integration;


import com.example.demo.api.vo.ProductVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ApplicationIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldSaveProduct() throws Exception {
        ProductVO productVo = ProductVO.builder().id(1).build();
        mvc.perform(post("/product")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productVo)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteProduct() throws Exception {
        ProductVO productVo = ProductVO.builder().id(1).build();
        mvc.perform(post("/product")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(productVo)));

        mvc.perform(delete("/product/{idToDelete}", 1)
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productVo)))
                .andExpect(status().isOk());
    }
}

