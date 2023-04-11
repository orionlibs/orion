package com.orion.math.linearalgebra.matrix;

import com.orion.math.MathError;

public class MatrixIsSingularException extends MathError
{
    private static final String DefaultErrorMessage = "The given matrix is singular.";


    public MatrixIsSingularException()
    {
        super(DefaultErrorMessage);
    }


    public MatrixIsSingularException(String message)
    {
        super(message);
    }


    public MatrixIsSingularException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public MatrixIsSingularException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public MatrixIsSingularException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
