package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum AuditProgramStatus {
    Draft("Draft"), Submitted("Submitted"), Approved("Approved");

    private String type;

    public static AuditProgramStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditProgramStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}