package com.auditlogsentinel.auditlogsentinel.controller;

import com.auditlogsentinel.auditlogsentinel.model.AuditLog;
import com.auditlogsentinel.auditlogsentinel.service.AnomalyDetectionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
public class AuditLogController {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    private final AnomalyDetectionService anomalyDetectionService;

    public AuditLogController(AnomalyDetectionService anomalyDetectionService) {
        this.anomalyDetectionService = anomalyDetectionService;
    }

    @PostMapping
    public ResponseEntity<Void> ingestLog(@Valid @RequestBody AuditLog auditLog) {
        System.out.println("Received audit log: " + auditLog);

        if (anomalyDetectionService.isAnomalous(auditLog)) {
            System.out.println(RED + "ALERTA DE SEGURANÇA: acesso anômalo detectado -> " + auditLog + RESET);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}


