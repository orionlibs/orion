package com.orion.machine_learning.hypothesis;

import com.orion.math.MathError;

public class NullHypothesisException extends MathError
{
    private static final String DefaultErrorMessage = "The given hypothesis cannot be null.";


    public NullHypothesisException()
    {
        super(DefaultErrorMessage);
    }


    public NullHypothesisException(String message)
    {
        super(message);
    }


    public NullHypothesisException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullHypothesisException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullHypothesisException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
