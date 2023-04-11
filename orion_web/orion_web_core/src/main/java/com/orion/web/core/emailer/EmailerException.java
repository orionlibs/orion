package com.orion.web.core.emailer;

import com.orion.core.abstraction.OrionUncheckedException;

public class EmailerException extends OrionUncheckedException
{
    private static final String DefaultErrorMessage = "Problem with the emailer.";


    public EmailerException()
    {
        super(DefaultErrorMessage);
    }


    public EmailerException(String message)
    {
        super(message);
    }


    public EmailerException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public EmailerException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(cause, String.format(errorMessage, arguments));
    }


    public EmailerException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}