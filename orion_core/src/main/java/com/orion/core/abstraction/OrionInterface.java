package com.orion.core.abstraction;

import com.orion.core.logger.LoggerService;
import java.io.Serializable;

public interface OrionInterface extends Serializable
{
    default void logInfo(String message, Object... parameters)
    {
        LoggerService.log(message, parameters);
    }


    default void logAWarning(String message, Object... parameters)
    {
        LoggerService.logWarning(message, parameters);
    }


    default void logAnError(String message, Object... parameters)
    {
        LoggerService.logError(message, parameters);
    }
}