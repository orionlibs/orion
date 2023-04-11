package com.orion.machine_learning.training.element.characteristics;

import com.orion.math.MathError;

public class NullElementCharacteristicsException extends MathError
{
    private static final String DefaultErrorMessage = "The given element characteristics cannot be null.";


    public NullElementCharacteristicsException()
    {
        super(DefaultErrorMessage);
    }


    public NullElementCharacteristicsException(String message)
    {
        super(message);
    }


    public NullElementCharacteristicsException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public NullElementCharacteristicsException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public NullElementCharacteristicsException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
