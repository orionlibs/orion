package com.orion.machine_learning.classification.k_nearest_neighbours.error;

import com.orion.math.MathError;

public class InvalidExpectedLabelForKNearestNeighboursErrorException extends MathError
{
    private static final String DefaultErrorMessage = "The given expected label is invalid.";


    public InvalidExpectedLabelForKNearestNeighboursErrorException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidExpectedLabelForKNearestNeighboursErrorException(String message)
    {
        super(message);
    }


    public InvalidExpectedLabelForKNearestNeighboursErrorException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidExpectedLabelForKNearestNeighboursErrorException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidExpectedLabelForKNearestNeighboursErrorException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
