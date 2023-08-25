package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamMemberStatus {
    Waiting("Waiting"),
    InProgress("InProgress"),
    Completed("Completed");

    private String type;

    public static TeamMemberStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (TeamMemberStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
