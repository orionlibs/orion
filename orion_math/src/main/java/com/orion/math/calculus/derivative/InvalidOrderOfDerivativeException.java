package com.orion.math.calculus.derivative;

import com.orion.math.MathError;

public class InvalidOrderOfDerivativeException extends MathError
{
    private static final String DefaultErrorMessage = "Invalid of order of derivative.";


    public InvalidOrderOfDerivativeException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidOrderOfDerivativeException(String message)
    {
        super(message);
    }


    public InvalidOrderOfDerivativeException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidOrderOfDerivativeException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidOrderOfDerivativeException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
