package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotUpdateUserException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not update user to the database.";


    public CouldNotUpdateUserException(String message)
    {
        super(message);
    }


    public CouldNotUpdateUserException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotUpdateUserException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotUpdateUserException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}