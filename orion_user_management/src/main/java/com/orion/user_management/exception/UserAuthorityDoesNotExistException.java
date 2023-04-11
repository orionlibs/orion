package com.orion.user_management.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class UserAuthorityDoesNotExistException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "User authority does not exist.";


    public UserAuthorityDoesNotExistException()
    {
        super(DefaultErrorMessage);
    }


    public UserAuthorityDoesNotExistException(String message)
    {
        super(message);
    }


    public UserAuthorityDoesNotExistException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public UserAuthorityDoesNotExistException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public UserAuthorityDoesNotExistException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}