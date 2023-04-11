package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotUpdateUserAuthorityException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not update user authority to the database.";


    public CouldNotUpdateUserAuthorityException(String message)
    {
        super(message);
    }


    public CouldNotUpdateUserAuthorityException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotUpdateUserAuthorityException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotUpdateUserAuthorityException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}