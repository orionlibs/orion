package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class ResetPasswordCodeHasExpiredException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Reset password code has expired. Please request a new one.";


    public ResetPasswordCodeHasExpiredException()
    {
        super(DefaultErrorMessage);
    }


    public ResetPasswordCodeHasExpiredException(String message)
    {
        super(message);
    }


    public ResetPasswordCodeHasExpiredException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public ResetPasswordCodeHasExpiredException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public ResetPasswordCodeHasExpiredException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}