package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotUpdateUserDetailsException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not update user details to the database.";


    public CouldNotUpdateUserDetailsException(String message)
    {
        super(message);
    }


    public CouldNotUpdateUserDetailsException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotUpdateUserDetailsException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotUpdateUserDetailsException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}