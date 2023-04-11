package com.orion.core.calendar.date;

import com.orion.core.abstraction.OrionUncheckedException;

public class InvalidDateException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "dateString does not have - or / as seperators/delimiters.";


    public InvalidDateException()
    {
        super(DefaultErrorMessage);
    }


    public InvalidDateException(String message)
    {
        super(message);
    }


    public InvalidDateException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidDateException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidDateException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}
