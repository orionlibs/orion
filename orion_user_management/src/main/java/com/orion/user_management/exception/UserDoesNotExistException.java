package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class UserDoesNotExistException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "User does not exist.";


    public UserDoesNotExistException(String message)
    {
        super(message);
    }


    public UserDoesNotExistException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserDoesNotExistException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserDoesNotExistException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}