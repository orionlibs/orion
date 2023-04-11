package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CannotResetUserPasswordException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Cannot reset user password.";


    public CannotResetUserPasswordException()
    {
        super(DefaultErrorMessage);
    }


    public CannotResetUserPasswordException(String message)
    {
        super(message);
    }


    public CannotResetUserPasswordException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CannotResetUserPasswordException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CannotResetUserPasswordException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}