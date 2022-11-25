package dev.iablokov.numberconverter.services.audit.impl;

import dev.iablokov.numberconverter.models.AuditLog;
import dev.iablokov.numberconverter.models.DataFormat;
import dev.iablokov.numberconverter.repositories.AuditLogRepository;
import dev.iablokov.numberconverter.services.audit.AuditLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Async
    @Override
    public void addAuditLogEntry(DataFormat inpFormat, String input, DataFormat outFormat, String output){
        AuditLog auditLog = new AuditLog();
        auditLog.setInputType(inpFormat);
        auditLog.setOutputType(outFormat);
        auditLog.setInputValue(input);
        auditLog.setOutputValue(output);
        auditLogRepository.save(auditLog);
    }

    @Override
    public Set<AuditLog> getAuditLogs(){
        Set<AuditLog> auditSet = new HashSet<>();
        auditLogRepository.findAll().iterator().forEachRemaining(auditSet::add);
        return auditSet;
    }

    @Override
    public List<AuditLog> getAuditLogsSort() {
        List<AuditLog> auditList = new ArrayList<>();
        auditLogRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp")).iterator().forEachRemaining(auditList::add);
        return auditList;
    }
}
