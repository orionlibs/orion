package com.orion.core.reflection.object;

import com.orion.core.abstraction.OrionService;
import com.orion.core.reflection.object.tasks.AreObjectsNotNullTask;
import com.orion.core.reflection.object.tasks.AreObjectsNullTask;

public class ReflectionObjectsService extends OrionService
{
    public static boolean isObjectNull(Object object)
    {
        return object == null;
    }


    public static boolean isObjectNotNull(Object object)
    {
        return object != null;
    }


    public static boolean areObjectsNull(Object... objects)
    {
        return AreObjectsNullTask.run(objects);
    }


    public static boolean areObjectsNotNull(Object... objects)
    {
        return AreObjectsNotNullTask.run(objects);
    }
}