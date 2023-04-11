package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CannotEnableUserAccountException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Cannot enable user account.";


    public CannotEnableUserAccountException()
    {
        super(DefaultErrorMessage);
    }


    public CannotEnableUserAccountException(String message)
    {
        super(message);
    }


    public CannotEnableUserAccountException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CannotEnableUserAccountException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CannotEnableUserAccountException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}