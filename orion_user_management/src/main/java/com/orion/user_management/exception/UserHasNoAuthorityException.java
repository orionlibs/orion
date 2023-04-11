package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class UserHasNoAuthorityException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "There was an error.";


    public UserHasNoAuthorityException()
    {
        super(DefaultErrorMessage);
    }


    public UserHasNoAuthorityException(String message)
    {
        super(message);
    }


    public UserHasNoAuthorityException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserHasNoAuthorityException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserHasNoAuthorityException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}