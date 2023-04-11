package com.orion.math.linearalgebra.matrix;

import com.orion.math.MathError;

public class MatrixIsNotPositiveDefiniteException extends MathError
{
    private static final String DefaultErrorMessage = "The given matrix is not positive definite.";


    public MatrixIsNotPositiveDefiniteException()
    {
        super(DefaultErrorMessage);
    }


    public MatrixIsNotPositiveDefiniteException(String message)
    {
        super(message);
    }


    public MatrixIsNotPositiveDefiniteException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public MatrixIsNotPositiveDefiniteException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public MatrixIsNotPositiveDefiniteException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
