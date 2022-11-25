package dev.iablokov.numberconverter.services.audit;

import dev.iablokov.numberconverter.models.AuditLog;
import dev.iablokov.numberconverter.models.DataFormat;

import java.util.List;
import java.util.Set;

public interface AuditLogService {
    /**
     * adds audit log entry
     * @param inpFormat input format
     * @param input input value
     * @param outFormat output format
     * @param output output value
     */
    void addAuditLogEntry(DataFormat inpFormat, String input, DataFormat outFormat, String output);

    /**
     * gets all audit logs
     * @return set of audit logs
     */
    Set<AuditLog> getAuditLogs();

    /**
     * gets all audit logs sorted by timestamp (desc)
     * @return sorted list of audit logs
     */
    List<AuditLog> getAuditLogsSort();
}
