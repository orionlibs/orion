package com.orion.math;

import com.orion.core.abstraction.OrionUncheckedException;

public abstract class MathError extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "There is a mathematical problem.";


    public MathError()
    {
        super(DefaultErrorMessage);
    }


    public MathError(String message)
    {
        super(message);
    }


    public MathError(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public MathError(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public MathError(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}