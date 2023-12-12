package com.cbo.audit.constants;

public final class URIs {
    private static final String APPLICATION_CONTEXT = "ams";
    private static final String REGISTER = "register";
    private static final String LIST_ALL = "listAll";
    private static final String FIND_BY_ID = "findById/{id}";
    private static final String UPDATE = "update";

    public static final String BUDGET_YEAR = APPLICATION_CONTEXT + "/year/change";

    public static final String AUDIT_UNIVERSE = APPLICATION_CONTEXT + "/auditUniverse/";
    public static final String AUDIT_UNIVERSE_REGISTER = AUDIT_UNIVERSE + REGISTER;
    public static final String AUDIT_UNIVERSE_LIST_ALL = AUDIT_UNIVERSE + LIST_ALL;
    public static final String AUDIT_UNIVERSE_BY_ID = AUDIT_UNIVERSE + "findById";
    public static final String AUDIT_UNIVERSE_UPDATE = AUDIT_UNIVERSE + UPDATE;
    public static final String AUDIT_UNIVERSE_APPROVE = AUDIT_UNIVERSE + "approve";




    public static final String ANNUAL_PLAN = APPLICATION_CONTEXT + "/annualPlan/";
    public static final String ANNUAL_PLAN_REGISTER = ANNUAL_PLAN + REGISTER;
    public static final String ANNUAL_PLAN_LIST_ALL = ANNUAL_PLAN + LIST_ALL;
    public static final String ANNUAL_PLAN_BY_ID = ANNUAL_PLAN + "findById";
    public static final String ANNUAL_PLAN_BY_YEAR = ANNUAL_PLAN + "findByYear";
    public static final String ANNUAL_PLAN_UPDATE = ANNUAL_PLAN + UPDATE;
    public static final String ANNUAL_PLAN_SCHEDULE = ANNUAL_PLAN + "addToSchedule";
    public static final String ANNUAL_PLAN_PLANED_LIST = ANNUAL_PLAN + "planedList";
    public static final String ANNUAL_PLAN_AUTO_GENERATE = ANNUAL_PLAN + "autoGenerate";



    public static final String AUDIT_TASK = APPLICATION_CONTEXT + "/auditTask/";
    public static final String AUDIT_TASK_REGISTER = AUDIT_TASK + REGISTER;
    public static final String AUDIT_TASK_LIST_ALL = AUDIT_TASK + LIST_ALL;
    public static final String AUDIT_TASK_BY_ID = AUDIT_TASK + FIND_BY_ID;
    public static final String AUDIT_TASK_UPDATE = AUDIT_TASK + UPDATE;


    public static final String AUDIT_PROGRAM = APPLICATION_CONTEXT + "/auditProgram/";
    public static final String AUDIT_PROGRAM_REGISTER = AUDIT_PROGRAM + REGISTER;

    public static final String AUDIT_PROGRAM_LIST_ALL = AUDIT_PROGRAM + LIST_ALL;
    public static final String AUDIT_PROGRAM_BY_ENGAGEMENT_ID=AUDIT_PROGRAM + "byEngagementId/"+FIND_BY_ID;

    public static final String AUDIT_PROGRAM_BY_ID = AUDIT_PROGRAM +FIND_BY_ID;
    public static final String CHANGE_STATUS_BY_ID = AUDIT_PROGRAM +"changeStatus/"+FIND_BY_ID;
    public static final String AUDIT_PROGRAM_UPDATE= AUDIT_PROGRAM + UPDATE;



    public static final String AUDIT_PROGRAM_WBS = AUDIT_PROGRAM + "wbs/";
    public static final String AUDIT_PROGRAM_MAIN_ACTIVITY = AUDIT_PROGRAM + "mainActivity/";
    public static final String AUDIT_PROGRAM_OBJECTIVE = AUDIT_PROGRAM + "objective/";

    public static final String List_WBS_BY_AUDIT_PROGRAM_ID = AUDIT_PROGRAM_WBS +FIND_BY_ID;
    public static final String LIST_OBJECTIVES_BY_AUDIT_PROGRAM_ID = AUDIT_PROGRAM_OBJECTIVE + FIND_BY_ID;
    public static final String LIST_MAIN_ACTIVITIES_BY_AUDIT_PROGRAM_ID = AUDIT_PROGRAM_MAIN_ACTIVITY + FIND_BY_ID;
    public static final String AUDIT_PROGRAM_WBS_REGISTER = AUDIT_PROGRAM_WBS + REGISTER;

    public static final String AUDIT_PROGRAM_MAIN_ACTIVITY_REGISTER = AUDIT_PROGRAM_MAIN_ACTIVITY + REGISTER;
    public static final String AUDIT_PROGRAM_OBJECTIVE_REGISTER = AUDIT_PROGRAM_OBJECTIVE + REGISTER;

    public static final String AUDIT_PROGRAM_WBS_UPDATE= AUDIT_PROGRAM_WBS + UPDATE;
    public static final String AUDIT_PROGRAM_OBJECTIVE_UPDATE= AUDIT_PROGRAM_OBJECTIVE + UPDATE;
    public static final String AUDIT_PROGRAM_MAIN_ACTIVITY_UPDATE= AUDIT_PROGRAM_MAIN_ACTIVITY + UPDATE;
//Audit Program Finding and comment
public static final String AUDIT_PROGRAM_FINDING= "finding/";
    public static final String AUDIT_PROGRAM_FINDING_COMMENT= "comment/";

    public static final String AUDIT_PROGRAM_FINDING_REGISTER= AUDIT_PROGRAM + AUDIT_PROGRAM_FINDING + REGISTER;
    public static final String LIST_ALL_FINDINGS_BY_AUDIT_PROGRAM_ID=AUDIT_PROGRAM+AUDIT_PROGRAM_FINDING+FIND_BY_ID;
    public static final String AUDIT_PROGRAM_FINDING_COMMENT_REGISTER= AUDIT_PROGRAM + AUDIT_PROGRAM_FINDING +AUDIT_PROGRAM_FINDING_COMMENT+ REGISTER;

    public static final String AUDIT_PROGRAM_FINDING_COMMENT_UPDATE= AUDIT_PROGRAM + AUDIT_PROGRAM_FINDING +AUDIT_PROGRAM_FINDING_COMMENT+UPDATE;
    public static final String UPDATE_AUDIT_PROGRAM_FINDING= AUDIT_PROGRAM+AUDIT_PROGRAM_FINDING+UPDATE;
    public static final String LIST_ALL_COMMENTS_BY_FINDING_ID=AUDIT_PROGRAM+AUDIT_PROGRAM_FINDING+AUDIT_PROGRAM_FINDING_COMMENT+FIND_BY_ID;

    public static final String AUDIT_SCHEDULE = APPLICATION_CONTEXT + "/auditSchedule/";
    public static final String AUDIT_SCHEDULE_REGISTER = AUDIT_SCHEDULE + REGISTER;
    public static final String AUDIT_SCHEDULE_LIST_ALL = AUDIT_SCHEDULE + LIST_ALL;
    public static final String AUDIT_SCHEDULE_BY_ID = AUDIT_SCHEDULE + FIND_BY_ID;

    public static final String AUDIT_SCHEDULE_BY_YEAR = AUDIT_SCHEDULE + "findByYear";

    public static final String AUDIT_SCHEDULE_BY_YEAR_AND_QUARTER = AUDIT_SCHEDULE + "findByQuarter/{quarter}";

    public static final String AUDIT_SCHEDULE_UPDATE = AUDIT_SCHEDULE + UPDATE;
    public static final String ADD_AUDIT_SCHEDULE_TO_ENGAGEMENT = AUDIT_SCHEDULE + "addToEngagement";
    public static final String GET_AUDIT_ENGAGEMENT_BY_SCHEDULE = AUDIT_SCHEDULE + "getEngagementBySchedule";
    public static final String AUDIT_ENGAGEMENT_LIST_ALL = AUDIT_SCHEDULE + "listAllEngagement";
    public static final String GET_AUDIT_ENGAGEMENT_BY_YEAR = AUDIT_SCHEDULE + "getEngagementByYear";
    public static final String GET_AUDIT_ENGAGEMENT_BY_STATUS = AUDIT_SCHEDULE + "getByStatus/{status}";
    public static final String GET_AUDIT_ENGAGEMENT_BY_QUARTER = AUDIT_SCHEDULE + "getByQuarter/{quarter}";



    public static final String AUDIT_RISK= APPLICATION_CONTEXT + "/risk/";
    public static final String RISK_SCORE_BY_ANNUAL_ID = AUDIT_RISK + "riskScoreByAnn";
    public static final String GET_RISK_LEVEL = AUDIT_RISK + "riskLevel";

    public static final String AUDIT_OBJECT = APPLICATION_CONTEXT + "/auditObject/";
    public static final String AUDIT_OBJECT_REGISTER = AUDIT_OBJECT + REGISTER;
    public static final String AUDIT_OBJECT_LIST_ALL = AUDIT_OBJECT + LIST_ALL;
    public static final String AUDIT_OBJECT_BY_ID = AUDIT_OBJECT + "findById";
    public static final String AUDIT_OBJECT_UPDATE = AUDIT_OBJECT + UPDATE;
    public static final String AUDIT_OBJECT_BY_AUDIT_TYPE = AUDIT_OBJECT + "byAuditType";

    public static final String TEAM_MEMBER = APPLICATION_CONTEXT + "/teamMember/";
    public static final String TEAM_MEMBER_REGISTER = TEAM_MEMBER + REGISTER;
    public static final String TEAM_MEMBER_LIST_BY_SCHEDULE = TEAM_MEMBER + "bySchedule";
    public static final String TEAM_MEMBER_LIST_BY_STAFF_ID = TEAM_MEMBER + "byStaffId";
    public static final String TEAM_MEMBER_BY_ID = TEAM_MEMBER + "findById";
    public static final String TEAM_MEMBER_UPDATE = TEAM_MEMBER + UPDATE;
    public static final String USER_LIST_BALL= APPLICATION_CONTEXT + "/users";
    public static final String TEAM_MEMBER_REMOVE = TEAM_MEMBER + "remove";

    public static final String RESOURCE = APPLICATION_CONTEXT + "/resource/";
    public static final String RESOURCE_REGISTER = RESOURCE + REGISTER;
    public static final String RESOURCE_LIST_BY_SCHEDULE = RESOURCE + "bySchedule";
    public static final String RESOURCE_BY_ID = RESOURCE + "findById";
    public static final String RESOURCE_UPDATE = RESOURCE + UPDATE;

    public static final String AUDITABLE_AREA = APPLICATION_CONTEXT + "/auditableArea/";
    public static final String AUDITABLE_AREA_REGISTER = AUDITABLE_AREA + REGISTER;
    public static final String AUDITABLE_AREA_LIST_ALL = AUDITABLE_AREA + LIST_ALL;
    public static final String AUDITABLE_AREA_BY_ID = AUDITABLE_AREA + "findById";
    public static final String AUDITABLE_AREA_BY_OBJECT_ID = AUDITABLE_AREA + "findByObj";
    public static final String AUDITABLE_AREA_UPDATE = AUDITABLE_AREA + UPDATE;
    public static final String AUDITABLE_AREA_DELETE = AUDITABLE_AREA + "delete";

    public static final String CHECKLIST_ITEM = APPLICATION_CONTEXT + "/checkListItem/";
    public static final String CHECKLIST_ITEM_REGISTER = CHECKLIST_ITEM + REGISTER;
    public static final String CHECKLIST_ITEM_LIST_ALL = CHECKLIST_ITEM + LIST_ALL;
    public static final String CHECKLIST_ITEM_BY_ID = CHECKLIST_ITEM + FIND_BY_ID;
    public static final String CHECKLIST_ITEM_UPDATE = CHECKLIST_ITEM + UPDATE;
    public static final String CHECKLIST_ITEM_DELETE= CHECKLIST_ITEM + "delete";
    public static final String CHECK_LIST_BY_OBJECT_ID = CHECKLIST_ITEM + "findByObj";
    public static final String CHECKLIST_ITEM_BY_AAR = CHECKLIST_ITEM + "byAArea";

    public static final String AUDIT_TYPE = APPLICATION_CONTEXT + "/auditType/";
    public static final String AUDIT_TYPE_REGISTER = AUDIT_TYPE + REGISTER;
    public static final String AUDIT_TYPE_LIST_ALL = AUDIT_TYPE + LIST_ALL;
    public static final String AUDIT_TYPE_BY_ID = AUDIT_TYPE + FIND_BY_ID;
    public static final String AUDIT_TYPE_UPDATE = AUDIT_TYPE + UPDATE;
    public static final String AUDIT_TYPE_DELETE = AUDIT_TYPE + "delete";

    public static final String RISK_ITEM = APPLICATION_CONTEXT + "/riskItem/";
    public static final String RISK_ITEM_REGISTER = RISK_ITEM + REGISTER;
    public static final String RISK_ITEM_LIST_ALL = RISK_ITEM + LIST_ALL;
    public static final String RISK_ITEM_BY_ID = RISK_ITEM + FIND_BY_ID;
    public static final String RISK_ITEM_UPDATE = RISK_ITEM + UPDATE;
    public static final String RISK_ITEM_DELETE = RISK_ITEM + "delete";


    public static final String AUDIT_STAFF = APPLICATION_CONTEXT + "/auditStaff/";
    public static final String AUDIT_STAFF_REGISTER = AUDIT_STAFF + REGISTER;
    public static final String AUDIT_STAFF_BY_ID = AUDIT_STAFF + "findById";
    public static final String AUDIT_STAFF_UPDATE = AUDIT_STAFF + UPDATE;
    public static final String AUDIT_STAFF_LIST_ALL = AUDIT_STAFF + "listAll";
    public static final String AUDIT_STAFF_LIST_ACTIVE= AUDIT_STAFF + "listActive";

    public static final String AUDIT_STAFF_LBY_AUDIT_TYPE= AUDIT_STAFF + "byAuditType";

    public static final String AUDIT_STAFF_REMOVE = AUDIT_STAFF + "remove";

}
