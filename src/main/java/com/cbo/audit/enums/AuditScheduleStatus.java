package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditScheduleStatus {
    Scheduled("Scheduled"),
    Engagement("Engagement"),
    Closed("Closed"),
    Cancelled("Cancelled");
    private String type;

    public static AuditScheduleStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditScheduleStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
