package dev.iablokov.numberconverter.controllers;

import dev.iablokov.numberconverter.models.AuditLog;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuditLogControllerTest {

    @Mock
    AuditLogService service;

    AuditLogController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new AuditLogController(service);
    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/audit"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAuditLogs() {

        //given
        List<AuditLog> logs = new ArrayList<>();

        AuditLog log1 = new AuditLog();
        log1.setId(1L);
        log1.setTimestamp(new Date());
        logs.add(log1);

        AuditLog log2 = new AuditLog();
        log2.setId(2L);
        log2.setTimestamp(new Date());
        logs.add(log2);

        when(service.getAuditLogsSort()).thenReturn(logs);
        //when
        List<AuditLog> result = controller.getAuditLogs();
        //then
        verify(service, times(1)).getAuditLogsSort();
        assertEquals(2, result.size());
        assertFalse(result.get(0).getTimestamp().before(result.get(1).getTimestamp()));
    }
}