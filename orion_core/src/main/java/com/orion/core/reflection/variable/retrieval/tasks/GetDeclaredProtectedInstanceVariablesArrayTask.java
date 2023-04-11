package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GetDeclaredProtectedInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> declaredProtectedInstanceVariables = new ArrayList<Field>();

        for(Field instanceVariable : aClass.getDeclaredFields())
        {

            if(IsProtectedVariableTask.run(instanceVariable) && IsNotStaticVariableTask.run(instanceVariable))
            {
                declaredProtectedInstanceVariables.add(instanceVariable);
            }

        }

        return declaredProtectedInstanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}