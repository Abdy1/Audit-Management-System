package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditStaffStatus {
    Active("Active"), InActive("InActive");

    private String type;

    public static AuditStaffStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditStaffStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
