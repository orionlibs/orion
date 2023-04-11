package com.orion.user_management.registration;

import com.orion.core.abstraction.OrionErrorMessages;

public class RegistrationErrors extends OrionErrorMessages
{
    public static final String RegistrationProblem = "Error with the customer registration process.";
    public static final String RegistrationProblemForUser = "There was a problem with your registration. Please try again.";
    public static final String InvalidInputForUser = "Some fields are invalid. Please try again.";
    public static final String ErrorWithSendingRegistrationEmailToUser = "Problem with sending registration email to user.";
}