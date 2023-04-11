package com.orion.user_management.authentication;

import com.orion.core.abstraction.OrionCheckedException;

public class UserIsUnauthorisedException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "There was an error.";


    public UserIsUnauthorisedException()
    {
        super(DefaultErrorMessage);
    }


    public UserIsUnauthorisedException(String message)
    {
        super(message);
    }


    public UserIsUnauthorisedException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserIsUnauthorisedException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserIsUnauthorisedException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}