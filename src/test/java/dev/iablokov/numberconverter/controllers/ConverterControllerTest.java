package dev.iablokov.numberconverter.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.iablokov.numberconverter.models.ConvertRequest;
import dev.iablokov.numberconverter.models.ConvertResponse;
import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.regex.Matcher;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ConverterControllerTest {

    @MockBean
    private AuditLogService auditLogService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void convert() throws Exception {
        ConvertRequest req = new ConvertRequest(DataFormat.DECIMAL,"5", DataFormat.ROMAN);
        ObjectMapper mapper = new ObjectMapper();
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/api/convert").content(mapper.writeValueAsString(req))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        ConvertResponse convertResponse = mapper.readValue(contentAsString, ConvertResponse.class);
        assertEquals("V", convertResponse.getResult());
    }

    @Test
    void convertWithExecetion() throws Exception {
        String errmsg = "Please provide a valid inputType";
        ConvertRequest req = new ConvertRequest(null,"5", DataFormat.ROMAN);
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/convert").content(mapper.writeValueAsString(req))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError()).andExpect(content().string(containsString(errmsg)));
    }

    @Test
    void auditLogWithExecetion() throws Exception {
        String errmsg = "Auditlog is down";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(errmsg);
        when(auditLogService.getAuditLogsSort()).thenThrow(illegalArgumentException);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/audit")
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError()).andExpect(content().string(containsString(errmsg)));
    }
}