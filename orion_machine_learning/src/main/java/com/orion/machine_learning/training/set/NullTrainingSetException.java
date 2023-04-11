package com.orion.machine_learning.training.set;

import com.orion.math.MathError;

public class NullTrainingSetException extends MathError
{
    private static final String DefaultErrorMessage = "The given training set cannot be null.";


    public NullTrainingSetException()
    {
        super(DefaultErrorMessage);
    }


    public NullTrainingSetException(String message)
    {
        super(message);
    }


    public NullTrainingSetException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullTrainingSetException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullTrainingSetException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
