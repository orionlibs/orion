package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionCheckedException;

public class EmailValidationCodeHasExpiredException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "The given email validation code has expired.";


    public EmailValidationCodeHasExpiredException()
    {
        super(DefaultErrorMessage);
    }


    public EmailValidationCodeHasExpiredException(String message)
    {
        super(message);
    }


    public EmailValidationCodeHasExpiredException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public EmailValidationCodeHasExpiredException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public EmailValidationCodeHasExpiredException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}