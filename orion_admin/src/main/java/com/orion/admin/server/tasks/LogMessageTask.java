package com.orion.admin.server.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.logger.LogType;

public class LogMessageTask extends Orion
{
    public static void run(String message, int logType)
    {

        if(logType == LogType.Information)
        {
            log(message);
        }
        else if(logType == LogType.Warning)
        {
            logWarning(message);
        }
        else if(logType == LogType.Error)
        {
            logError(message);
        }

    }
}