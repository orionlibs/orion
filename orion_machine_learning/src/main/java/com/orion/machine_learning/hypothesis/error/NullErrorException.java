package com.orion.machine_learning.hypothesis.error;

import com.orion.math.MathError;

public class NullErrorException extends MathError
{
    private static final String DefaultErrorMessage = "The given error cannot be null.";


    public NullErrorException()
    {
        super(DefaultErrorMessage);
    }


    public NullErrorException(String message)
    {
        super(message);
    }


    public NullErrorException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullErrorException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullErrorException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
