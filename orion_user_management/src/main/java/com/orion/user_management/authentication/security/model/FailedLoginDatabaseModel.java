package com.orion.user_management.authentication.security.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class FailedLoginDatabaseModel
{
    public static final String tableUserFailedLoginAttempts = "." + "user_failed_login_attempts";
    public static final String IPAddress = "IPAddress";
    public static final String firstFailedLoginAttemptDateTime = "firstFailedLoginAttemptDateTime";
    public static final String failedLoginAttempts = "failedLoginAttempts";
    public static final String accountDisabled = "accountDisabled";
}