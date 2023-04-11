package com.orion.core.exception;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.tasks.GetAllErrorMessagesFromTheHierarchyTask;

public class ExceptionService extends OrionService
{
    public static String getAllErrorMessagesFromTheHierarchy(Throwable exception)
    {
        return GetAllErrorMessagesFromTheHierarchyTask.run(exception);
    }
}