package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotSaveUserDetailsException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not save user details to the database.";


    public CouldNotSaveUserDetailsException(String message)
    {
        super(message);
    }


    public CouldNotSaveUserDetailsException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotSaveUserDetailsException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotSaveUserDetailsException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}