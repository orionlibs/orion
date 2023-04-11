package com.orion.user_management.authentication.logout.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class LogoutDatabaseModel
{
    public static final String tableUserLogoutCauses = "." + "user_logout_causes";
    public static final String logoutCause = "logoutCause";
    public static final String tableUserLogouts = "." + "user_logouts";
    public static final String logoutDate = "logoutDate";
    public static final String logoutDateTime = "logoutDateTime";
    public static final String logoutCauseID = "logoutCauseID";
    public static final String logoutID = "logoutID";
}