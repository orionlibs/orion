package com.orion.machine_learning.training.element.training_data_point;

import com.orion.math.MathError;

public class NullTrainingDataPointException extends MathError
{
    private static final String DefaultErrorMessage = "The given training data point cannot be null.";


    public NullTrainingDataPointException()
    {
        super(DefaultErrorMessage);
    }


    public NullTrainingDataPointException(String message)
    {
        super(message);
    }


    public NullTrainingDataPointException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullTrainingDataPointException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullTrainingDataPointException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
