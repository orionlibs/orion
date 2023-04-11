package com.orion.user_management.authentication.security;

import com.orion.core.abstraction.OrionErrorMessages;

public class LoginErrors extends OrionErrorMessages
{
    public static final String LoginProblem = "Error with the login process.";
    public static final String ErrorWithSendingFailedLoginAttemptsEmail = "Problem with sending email for failed login attempts";
}