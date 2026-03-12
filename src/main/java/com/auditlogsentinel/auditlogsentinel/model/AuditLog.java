package com.auditlogsentinel.auditlogsentinel.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record AuditLog(
        @NotNull
        UUID id,

        @NotBlank
        String username,

        @NotBlank
        String action,

        @NotNull
        LocalDateTime timestamp,

        @NotBlank
        String ipAddress,

        @NotBlank
        String riskLevel
) {
}

