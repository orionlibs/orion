package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;

public class GetInherittedInstanceVariableTask extends Orion
{
    public static Field run(String instanceVariableName, Object object) throws NoSuchFieldException, SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(instanceVariableName, object.getClass());
    }


    public static Field run(String instanceVariableName, Class<?> aClass) throws NoSuchFieldException, SecurityException
    {
        Assert.notEmpty(instanceVariableName, "instanceVariableName input cannot be null/empty.");
        Assert.notNull(aClass, "class input cannot be null.");
        Field publicOrInherittedInstanceVariable = aClass.getField(instanceVariableName);
        Field declaredInstanceVariable = GetDeclaredInstanceVariableTask.run(instanceVariableName, aClass);

        if(declaredInstanceVariable == null ||
                        (declaredInstanceVariable != null
                                        && IsNotPublicVariableTask.run(declaredInstanceVariable)
                                        && IsNotStaticVariableTask.run(declaredInstanceVariable)))
        {
            return publicOrInherittedInstanceVariable;
        }
        else
        {
            return null;
        }

    }
}