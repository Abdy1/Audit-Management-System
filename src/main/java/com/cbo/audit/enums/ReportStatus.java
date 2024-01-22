package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportStatus {

    Generated("Generated"),
    Reported("Reported"),
    FollowUp("FollowUp"),
    Archived("Archived");

    private String type;

    public static ReportStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (ReportStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}
