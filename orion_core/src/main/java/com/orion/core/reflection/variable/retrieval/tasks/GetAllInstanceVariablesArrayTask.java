package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> instanceVariables = new ArrayList<Field>();
        List<Field> inherittedInstanceVariables = Arrays.asList(GetInherittedInstanceVariablesArrayTask.run(aClass));
        List<Field> declaredInstanceVariables = Arrays.asList(GetDeclaredInstanceVariablesArrayTask.run(aClass));
        instanceVariables.addAll(inherittedInstanceVariables);
        instanceVariables.addAll(declaredInstanceVariables);
        return instanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}