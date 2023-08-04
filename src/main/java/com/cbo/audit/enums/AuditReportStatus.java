package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditReportStatus {
    Draft("Draft"), Submitted("Submitted"), Approved("Approved");

    private String type;

    public static AuditReportStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditReportStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}