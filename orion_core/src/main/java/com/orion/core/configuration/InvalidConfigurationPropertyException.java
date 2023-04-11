package com.orion.core.configuration;

import com.orion.core.abstraction.OrionCheckedException;

public class InvalidConfigurationPropertyException extends OrionCheckedException
{
    private static final String DefaultErrorMessage = "The given property value is invalid";


    public InvalidConfigurationPropertyException(String message)
    {
        super(message);
    }


    public InvalidConfigurationPropertyException(String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments));
    }


    public InvalidConfigurationPropertyException(Throwable cause, String errorMessage, Object... arguments)
    {
        super(String.format(errorMessage, arguments), cause);
    }


    public InvalidConfigurationPropertyException(Throwable cause)
    {
        super(cause, DefaultErrorMessage);
    }
}