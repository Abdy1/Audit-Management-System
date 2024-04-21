package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditStatus {

    Universe("Universe"), AnnualPlan("AnnualPlan"), Scheduled("Scheduled"), Engagement("Engagement");

    private String type;

    public static AuditStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
