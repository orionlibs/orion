package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class CouldNotSaveUserAuthorityException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Could not save user authority to the database.";


    public CouldNotSaveUserAuthorityException(String message)
    {
        super(message);
    }


    public CouldNotSaveUserAuthorityException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CouldNotSaveUserAuthorityException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CouldNotSaveUserAuthorityException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}