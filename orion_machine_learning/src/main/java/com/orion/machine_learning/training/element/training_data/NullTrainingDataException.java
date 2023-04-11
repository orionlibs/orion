package com.orion.machine_learning.training.element.training_data;

import com.orion.math.MathError;

public class NullTrainingDataException extends MathError
{
    private static final String DefaultErrorMessage = "The given training data cannot be null.";


    public NullTrainingDataException()
    {
        super(DefaultErrorMessage);
    }


    public NullTrainingDataException(String message)
    {
        super(message);
    }


    public NullTrainingDataException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullTrainingDataException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullTrainingDataException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
