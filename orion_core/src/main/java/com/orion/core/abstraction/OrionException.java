package com.orion.core.abstraction;

public class OrionException extends Exception
{
    public OrionException(String errorMessage)
    {
        super(errorMessage);
    }


    public OrionException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public OrionException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }
}