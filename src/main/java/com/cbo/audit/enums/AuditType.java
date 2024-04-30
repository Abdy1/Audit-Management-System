package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditType {


    HO("HO"), BranchAudit("Branch Audit"), ITAudit("IT Audit");

    private String type;

    public static AuditType decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditType obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}