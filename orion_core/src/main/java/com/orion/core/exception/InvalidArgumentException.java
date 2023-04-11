package com.orion.core.exception;

import com.orion.core.abstraction.OrionUncheckedException;

public class InvalidArgumentException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "The given input is invalid.";


    public InvalidArgumentException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidArgumentException(String message)
    {
        super(message);
    }


    public InvalidArgumentException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidArgumentException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidArgumentException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}