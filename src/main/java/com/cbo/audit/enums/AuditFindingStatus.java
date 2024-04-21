package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AuditFindingStatus {
    Open("Open"), Closed("Closed");

    private String type;

    public static AuditFindingStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (AuditFindingStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}