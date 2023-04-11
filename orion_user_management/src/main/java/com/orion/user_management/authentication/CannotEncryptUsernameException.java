package com.orion.user_management.authentication;

import com.orion.core.abstraction.OrionCheckedException;

public class CannotEncryptUsernameException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "Cannot encrypt username.";


    public CannotEncryptUsernameException()
    {
        super(DefaultErrorMessage);
    }


    public CannotEncryptUsernameException(String message)
    {
        super(message);
    }


    public CannotEncryptUsernameException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public CannotEncryptUsernameException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public CannotEncryptUsernameException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}