package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamType {
    Leader("Leader"),
    Member("Member");

    private String type;

    public static TeamType decode(String type) {
        if (type != null && type.length() > 0) {
            for (TeamType obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
