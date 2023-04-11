package com.orion.admin.server;

import com.orion.admin.server.tasks.LogMessageTask;
import com.orion.core.abstraction.OrionService;

public class AdminServerLoggerService extends OrionService
{
    public static void logMessage(String message, int logType)
    {
        LogMessageTask.run(message, logType);
    }
}