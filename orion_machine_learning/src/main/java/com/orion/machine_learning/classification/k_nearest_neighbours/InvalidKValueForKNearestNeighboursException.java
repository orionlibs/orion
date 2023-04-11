package com.orion.machine_learning.classification.k_nearest_neighbours;

import com.orion.math.MathError;

public class InvalidKValueForKNearestNeighboursException extends MathError
{
    private static final String DefaultErrorMessage = "The given K value is invalid.";


    public InvalidKValueForKNearestNeighboursException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidKValueForKNearestNeighboursException(String message)
    {
        super(message);
    }


    public InvalidKValueForKNearestNeighboursException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidKValueForKNearestNeighboursException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidKValueForKNearestNeighboursException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
