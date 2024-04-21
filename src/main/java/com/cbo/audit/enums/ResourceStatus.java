package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResourceStatus {
    Active("Active"), InActive("InActive");

    private String type;

    public static ResourceStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (ResourceStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}