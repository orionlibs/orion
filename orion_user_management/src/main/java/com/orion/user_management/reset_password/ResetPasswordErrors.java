package com.orion.user_management.reset_password;

import com.orion.core.abstraction.OrionErrorMessages;

public class ResetPasswordErrors extends OrionErrorMessages
{
    public static final String ErrorWithResetPasswordCode = "Problem with the reset password code";
    public static final String InvalidResetPasswordCode = "Invalid reset password code";
    public static final String ErrorWithResetPassword = "Problem with resetting the user password";
    public static final String ErrorWithEmailingUserAboutPasswordChange = "Problem with emailing the user about password change";
}