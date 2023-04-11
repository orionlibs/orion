package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class UserDetailsDoesNotExistException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "User details does not exist.";


    public UserDetailsDoesNotExistException(String message)
    {
        super(message);
    }


    public UserDetailsDoesNotExistException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserDetailsDoesNotExistException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserDetailsDoesNotExistException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}