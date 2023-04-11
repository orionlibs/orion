package com.orion.machine_learning.training.element;

import com.orion.math.MathError;

public class NullElementException extends MathError
{
    private static final String DefaultErrorMessage = "The given element cannot be null.";


    public NullElementException()
    {
        super(DefaultErrorMessage);
    }


    public NullElementException(String message)
    {
        super(message);
    }


    public NullElementException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullElementException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullElementException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
