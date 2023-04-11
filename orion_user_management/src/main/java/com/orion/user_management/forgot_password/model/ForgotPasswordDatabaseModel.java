package com.orion.user_management.forgot_password.model;

/**
 * model for the Orion database containing database tables and their columns
 * @author dimitrios.efthymiou
 */
public class ForgotPasswordDatabaseModel
{
    public static final String tableForgotPasswordCodes = "." + "forgot_password_codes";
    public static final String forgotPasswordCode = "forgotPasswordCode";
    public static final String expirationDateTime = "expirationDateTime";
}