package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionCheckedException;

public class AccountIsAlreadyValidatedException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "User account has already been validated.";


    public AccountIsAlreadyValidatedException()
    {
        super(DefaultErrorMessage);
    }


    public AccountIsAlreadyValidatedException(String message)
    {
        super(message);
    }


    public AccountIsAlreadyValidatedException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public AccountIsAlreadyValidatedException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public AccountIsAlreadyValidatedException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}