package com.orion.core.logger;

import java.util.logging.Logger;

public class LoggerService
{
    private static final transient Logger LOG = Logger.getLogger(LoggerService.class.getName());


    public static void log(String message, Object... parameters)
    {
        String messageTemp = message;

        if(parameters != null && parameters.length > 0)
        {
            String.format(message, parameters);
        }

        LOG.info(messageTemp);
    }


    public static void logWarning(String message, Object... parameters)
    {
        String messageTemp = message;

        if(parameters != null && parameters.length > 0)
        {
            String.format(message, parameters);
        }

        LOG.warning(messageTemp);
    }


    public static void logError(String message, Object... parameters)
    {
        String messageTemp = message;

        if(parameters != null && parameters.length > 0)
        {

            if(parameters[0] instanceof Throwable)
            {
                Throwable error = (Throwable)parameters[0];
                messageTemp += ". Error: " + error.getMessage();
            }
            else
            {
                String.format(message, parameters);
            }

        }

        LOG.severe(messageTemp);
    }


    public static void logError(Throwable exception, String message, Object... parameters)
    {
        String messageTemp = message + ". Error: " + exception.getMessage();

        if(parameters != null && parameters.length > 0)
        {
            String.format(message, parameters);
        }

        LOG.severe(messageTemp);
    }
}