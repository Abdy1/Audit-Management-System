package com.cbo.audit.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditEngagementStatus {
    Scheduled("Scheduled"), InProgress("InProgress"), Completed("Completed");

    private String type;

    public static AuditEngagementStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditEngagementStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
