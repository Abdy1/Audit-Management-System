package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResourceType {
    Human("Human"),
    Logistic("Logistic");

    private String type;

    public static ResourceType decode(String type) {
        if (type != null && type.length() > 0) {
            for (ResourceType obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }

}