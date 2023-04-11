package com.orion.core.reflection.acccessible_object.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.reflection.constructor.retrieval.tasks.GetDeclaredConstructorsArrayTask;
import com.orion.core.reflection.method.retrieval.tasks.GetDeclaredMethodsArrayTask;
import com.orion.core.reflection.variable.retrieval.tasks.GetDeclaredInstanceVariablesArrayTask;
import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetDeclaredAccessibleObjectsArrayTask extends Orion
{
    public static AccessibleObject[] run(Class<?> aClass)
    {
        List<AccessibleObject> accessibleObjects = new ArrayList<AccessibleObject>();
        accessibleObjects.addAll(Arrays.asList(GetDeclaredInstanceVariablesArrayTask.run(aClass)));
        accessibleObjects.addAll(Arrays.asList(GetDeclaredConstructorsArrayTask.run(aClass)));
        accessibleObjects.addAll(Arrays.asList(GetDeclaredMethodsArrayTask.run(aClass)));
        return accessibleObjects.toArray(new AccessibleObject[0]);
    }


    public static AccessibleObject[] run(Object object)
    {
        return run(object);
    }
}