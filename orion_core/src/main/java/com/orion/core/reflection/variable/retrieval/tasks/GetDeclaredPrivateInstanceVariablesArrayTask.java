package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class GetDeclaredPrivateInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> declaredPrivateInstanceVariables = new ArrayList<Field>();

        for(Field instanceVariable : aClass.getDeclaredFields())
        {

            if(Modifier.isPrivate(instanceVariable.getModifiers()) && IsNotStaticVariableTask.run(instanceVariable))
            {
                declaredPrivateInstanceVariables.add(instanceVariable);
            }

        }

        return declaredPrivateInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}