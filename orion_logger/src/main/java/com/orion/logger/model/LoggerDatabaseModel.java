package com.orion.logger.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class LoggerDatabaseModel
{
    public static final String tableErrorLogs = "." + "error_logs";
    public static final String operationID = "operationID";
    public static final String userID = "userID";
    public static final String errorMessage = "errorMessage";
    public static final String errorType = "errorType";
    public static final String logDate = "logDate";
    public static final String logDateTime = "logDateTime";
    public static final String errorLogID = "errorLogID";
    public static final String comment = "comment";
    public static final String lastUpdateDateTime = "lastUpdateDateTime";
    public static final String isBeingInvestigated = "isBeingInvestigated";
    public static final String hasBeingInvestigated = "hasBeingInvestigated";
    public static final String isBeingIgnored = "isBeingIgnored";
    public static final String tableUserAndSystemActionsLogs = "." + "user_and_system_actions_logs";
    public static final String userAndSystemActionLogID = "userAndSystemActionLogID";
    public static final String actionDescription = "actionDescription";
    public static final String IPAddress = "IPAddress";
    public static final String actorType = "actorType";
    public static final String actionType = "actionType";
    public static final String tableUniqueAPIRequests = "." + "unique_api_requests";
    public static final String requestID = "requestID";
    public static final String requestEpochInNanoseconds = "requestEpochInNanoseconds";
    public static final String requestDateTime = "requestDateTime";
    public static final String status = "status";
}