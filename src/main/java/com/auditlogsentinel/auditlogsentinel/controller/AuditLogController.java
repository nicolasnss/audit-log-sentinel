package com.auditlogsentinel.auditlogsentinel.controller;

import com.auditlogsentinel.auditlogsentinel.model.AuditLog;
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

    @PostMapping
    public ResponseEntity<Void> ingestLog(@Valid @RequestBody AuditLog auditLog) {
        System.out.println("Received audit log: " + auditLog);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

