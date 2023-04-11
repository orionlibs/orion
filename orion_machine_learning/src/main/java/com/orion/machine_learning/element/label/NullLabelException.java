package com.orion.machine_learning.element.label;

import com.orion.math.MathError;

public class NullLabelException extends MathError
{
    private static final String DefaultErrorMessage = "The given label cannot be null.";


    public NullLabelException()
    {
        super(DefaultErrorMessage);
    }


    public NullLabelException(String message)
    {
        super(message);
    }


    public NullLabelException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullLabelException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullLabelException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
