package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CannotSaveUsersOldPasswordException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Cannot save user's old password.";


    public CannotSaveUsersOldPasswordException()
    {
        super(DefaultErrorMessage);
    }


    public CannotSaveUsersOldPasswordException(String message)
    {
        super(message);
    }


    public CannotSaveUsersOldPasswordException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CannotSaveUsersOldPasswordException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CannotSaveUsersOldPasswordException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}