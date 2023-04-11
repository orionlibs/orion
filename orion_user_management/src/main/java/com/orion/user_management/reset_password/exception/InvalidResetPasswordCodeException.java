package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class InvalidResetPasswordCodeException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Invalid reset password code.";


    public InvalidResetPasswordCodeException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidResetPasswordCodeException(String message)
    {
        super(message);
    }


    public InvalidResetPasswordCodeException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidResetPasswordCodeException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidResetPasswordCodeException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}