package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditTaskStatus {

    Planned("Planned"), InProgress("InProgress"), Completed("Completed");

    private String type;

    public static AuditTaskStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditTaskStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}