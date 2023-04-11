package com.orion.user_management.reset_password.exception;

import com.orion.core.abstraction.OrionCheckedException;

public class NewPasswordMatchesOldPasswordException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "New user password cannot match any of the previously used passwords.";


    public NewPasswordMatchesOldPasswordException()
    {
        super(DefaultErrorMessage);
    }


    public NewPasswordMatchesOldPasswordException(String message)
    {
        super(message);
    }


    public NewPasswordMatchesOldPasswordException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NewPasswordMatchesOldPasswordException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NewPasswordMatchesOldPasswordException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}