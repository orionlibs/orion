package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotSaveUserException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not save user to the database.";


    public CouldNotSaveUserException(String message)
    {
        super(message);
    }


    public CouldNotSaveUserException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotSaveUserException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotSaveUserException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}