package com.auditlogsentinel.auditlogsentinel.service;

import com.auditlogsentinel.auditlogsentinel.model.AuditLog;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class AnomalyDetectionService {

    public boolean isAnomalous(AuditLog auditLog) {
        if (auditLog == null || auditLog.timestamp() == null) {
            return false;
        }

        var time = auditLog.timestamp().toLocalTime();

        // Acesso noturno: entre 22h (inclusive) e 06h (exclusive)
        boolean nightAccess = time.isAfter(LocalTime.of(22, 0).minusNanos(1))
                || time.isBefore(LocalTime.of(6, 0));

        // Nível de risco: HIGH ou CRITICAL
        String risk = auditLog.riskLevel() != null ? auditLog.riskLevel().toUpperCase() : "";
        boolean highRisk = "HIGH".equals(risk) || "CRITICAL".equals(risk);

        // Acesso externo: IP que não começa com 192.168.
        String ip = auditLog.ipAddress();
        boolean externalAccess = ip != null && !ip.startsWith("192.168.");

        return nightAccess || highRisk || externalAccess;
    }
}

