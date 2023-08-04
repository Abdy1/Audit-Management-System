package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AnnualPlanStatus {

    Planned("Planned"), Approved("Approved"), Cancelled("Cancelled");

    private String type;

    public static AnnualPlanStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AnnualPlanStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}