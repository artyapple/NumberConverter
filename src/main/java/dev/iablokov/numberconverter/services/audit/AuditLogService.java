package dev.iablokov.numberconverter.services.audit;

import dev.iablokov.numberconverter.models.AuditLog;
import dev.iablokov.numberconverter.models.DataFormat;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Set;

public interface AuditLogService {

    public void addLogEntry(DataFormat inpFormat, String input, DataFormat outFormat, String output);

    public Set<AuditLog> getAuditLogs();

    public List<AuditLog> getAuditLogsSort();
}
