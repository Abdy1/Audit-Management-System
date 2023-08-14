package com.cbo.audit.constants;

public final class URIs {
    private static final String APPLICATION_CONTEXT = "ams";
    private static final String REGISTER = "register";
    private static final String LIST_ALL = "listAll";
    private static final String FIND_BY_ID = "findById/{id}";
    private static final String UPDATE = "update";

    public static final String AUDIT_UNIVERSE = APPLICATION_CONTEXT + "/auditUniverse/";
    public static final String AUDIT_UNIVERSE_REGISTER = AUDIT_UNIVERSE + REGISTER;
    public static final String AUDIT_UNIVERSE_LIST_ALL = AUDIT_UNIVERSE + LIST_ALL;
    public static final String AUDIT_UNIVERSE_BY_ID = AUDIT_UNIVERSE + "findById";
    public static final String AUDIT_UNIVERSE_UPDATE = AUDIT_UNIVERSE + UPDATE;


    public static final String ANNUAL_PLAN = APPLICATION_CONTEXT + "/annualPlan/";

    public static final String AUDIT_PROGRAM = APPLICATION_CONTEXT + "/auditProgram/";
    public static final String ANNUAL_PLAN_REGISTER = ANNUAL_PLAN + REGISTER;

    public static final String AUDIT_PROGRAM_REGISTER = AUDIT_PROGRAM + REGISTER;
    public static final String ANNUAL_PLAN_LIST_ALL = ANNUAL_PLAN + LIST_ALL;
    public static final String ANNUAL_PLAN_BY_ID = ANNUAL_PLAN + FIND_BY_ID;
    public static final String ANNUAL_PLAN_UPDATE = ANNUAL_PLAN + UPDATE;


    public static final String AUDIT_TASK = APPLICATION_CONTEXT + "/auditTask/";
    public static final String AUDIT_TASK_REGISTER = AUDIT_TASK + REGISTER;
    public static final String AUDIT_TASK_LIST_ALL = AUDIT_TASK + LIST_ALL;
    public static final String AUDIT_TASK_BY_ID = AUDIT_TASK + FIND_BY_ID;
    public static final String AUDIT_TASK_UPDATE = AUDIT_TASK + UPDATE;


    public static final String RESOURCE = APPLICATION_CONTEXT + "/resource/";
    public static final String RESOURCE_REGISTER = RESOURCE + REGISTER;
    public static final String RESOURCE_LIST_ALL = RESOURCE + LIST_ALL;
    public static final String RESOURCE_BY_ID = RESOURCE + FIND_BY_ID;
    public static final String RESOURCE_UPDATE = RESOURCE + UPDATE;


    public static final String AUDIT_ENGAGEMENT = APPLICATION_CONTEXT + "/auditEngagement/";
    public static final String AUDIT_ENGAGEMENT_REGISTER = AUDIT_ENGAGEMENT + REGISTER;
    public static final String AUDIT_ENGAGEMENT_LIST_ALL = AUDIT_ENGAGEMENT + LIST_ALL;
    public static final String AUDIT_ENGAGEMENT_BY_ID = AUDIT_ENGAGEMENT + FIND_BY_ID;
    public static final String AUDIT_ENGAGEMENT_UPDATE = AUDIT_ENGAGEMENT + UPDATE;


    public static final String AUDIT_RISK= APPLICATION_CONTEXT + "/risk/";
    public static final String RISK_ITEM_LIST_ALL = AUDIT_RISK + "listRiskItem";
    public static final String RISK_SCORE_BY_ANNUAL_ID = AUDIT_RISK + "riskScoreByAnn";
    public static final String GET_RISK_LEVEL = AUDIT_RISK + "riskLevel";


    public static final String AUDIT_OBJECT = APPLICATION_CONTEXT + "/auditObject/";
    public static final String AUDIT_OBJECT_REGISTER = AUDIT_OBJECT + REGISTER;
    public static final String AUDIT_OBJECT_LIST_ALL = AUDIT_OBJECT + LIST_ALL;
    public static final String AUDIT_OBJECT_BY_ID = AUDIT_OBJECT + FIND_BY_ID;
    public static final String AUDIT_OBJECT_UPDATE = AUDIT_OBJECT + UPDATE;
    public static final String AUDIT_OBJECT_BY_AU = AUDIT_OBJECT + "byAU";

    public static final String AUDITABLE_AREA = APPLICATION_CONTEXT + "/auditableArea/";
    public static final String AUDITABLE_AREA_REGISTER = AUDITABLE_AREA + REGISTER;
    public static final String AUDITABLE_AREA_LIST_ALL = AUDITABLE_AREA + LIST_ALL;
    public static final String AUDITABLE_AREA_BY_ID = AUDITABLE_AREA + FIND_BY_ID;
    public static final String AUDITABLE_AREA_UPDATE = AUDITABLE_AREA + UPDATE;

    public static final String CHECKLIST_ITEM = APPLICATION_CONTEXT + "/checkListItem/";
    public static final String CHECKLIST_ITEM_REGISTER = CHECKLIST_ITEM + REGISTER;
    public static final String CHECKLIST_ITEM_LIST_ALL = CHECKLIST_ITEM + LIST_ALL;
    public static final String CHECKLIST_ITEM_BY_ID = CHECKLIST_ITEM + FIND_BY_ID;
    public static final String CHECKLIST_ITEM_UPDATE = CHECKLIST_ITEM + UPDATE;
    public static final String CHECKLIST_ITEM_BY_AOBJ = CHECKLIST_ITEM + "byAObj";
    public static final String CHECKLIST_ITEM_BY_AAR = CHECKLIST_ITEM + "byAArea";
}
