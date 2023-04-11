package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class UserAlreadyExistsException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "User already exists.";


    public UserAlreadyExistsException(String message)
    {
        super(message);
    }


    public UserAlreadyExistsException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserAlreadyExistsException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserAlreadyExistsException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}