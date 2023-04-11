package com.orion.machine_learning.domainset;

import com.orion.math.MathError;

public class NullDomainSetException extends MathError
{
    private static final String DefaultErrorMessage = "The given domain set cannot be null.";


    public NullDomainSetException()
    {
        super(DefaultErrorMessage);
    }


    public NullDomainSetException(String message)
    {
        super(message);
    }


    public NullDomainSetException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullDomainSetException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullDomainSetException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
