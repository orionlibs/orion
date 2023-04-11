package com.orion.core.reflection.object.tasks;

import com.orion.core.abstraction.Orion;
import java.util.Arrays;

public class AreObjectsNotNullTask extends Orion
{
    public static boolean run(Object... objects)
    {

        if(objects != null && objects.length > 0)
        {
            return !Arrays.stream(objects).anyMatch(object -> object == null);
        }

        return false;
    }
}