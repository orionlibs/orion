package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;

public class GetDeclaredProtectedInstanceVariableTask extends Orion
{
    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Field field = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);

        if(field != null && IsProtectedVariableTask.run(field) && IsNotStaticVariableTask.run(field))
        {
            return field;
        }

        return null;
    }


    public static Field run(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(instanceVariableName, object.getClass());
    }
}