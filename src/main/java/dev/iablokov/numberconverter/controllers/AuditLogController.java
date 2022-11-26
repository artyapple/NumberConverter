package dev.iablokov.numberconverter.controllers;

import dev.iablokov.numberconverter.models.AuditLog;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@Slf4j
public class AuditLogController {
    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping("/audit")
    public List<AuditLog> getAuditLogs(){
        return auditLogService.getAuditLogsSort();
    }

}
