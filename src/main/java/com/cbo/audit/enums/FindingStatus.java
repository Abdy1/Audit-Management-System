package com.cbo.audit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum FindingStatus {

    Approved("Approved"),
    Pending("Pending"),
    Scheduled("Scheduled"),
    Engagement("Engagement"),
    Reported("Reported"),
    FollowUp("FollowUp"),
    Closed("Closed"),
    Archived("Archived"),
    Cancelled("Cancelled");
    private String type;

    public static FindingStatus decode(String type) {
        if (type != null && type.length() > 0) {
            for (FindingStatus obj : values()) {
                if (obj.getType().equalsIgnoreCase(type)) {
                    return obj;
                }
            }
        }

        return null;
    }
}