package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditObjectStatus {
    PendingApproval("Pending Approval"), Approved("Approved"), InActive("InActive");

    private String type;

    public static AuditObjectStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditObjectStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}