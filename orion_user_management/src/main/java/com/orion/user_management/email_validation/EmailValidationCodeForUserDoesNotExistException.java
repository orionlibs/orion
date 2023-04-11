package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionCheckedException;

public class EmailValidationCodeForUserDoesNotExistException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Invalid email validation code.";


    public EmailValidationCodeForUserDoesNotExistException()
    {
        super(DefaultErrorMessage);
    }


    public EmailValidationCodeForUserDoesNotExistException(String message)
    {
        super(message);
    }


    public EmailValidationCodeForUserDoesNotExistException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public EmailValidationCodeForUserDoesNotExistException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public EmailValidationCodeForUserDoesNotExistException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}