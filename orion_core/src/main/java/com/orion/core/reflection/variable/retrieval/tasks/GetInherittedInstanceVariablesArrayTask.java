package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetInherittedInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        List<Field> instanceVariables = new ArrayList<Field>();
        List<Field> publicInstanceVariables = Arrays.asList(GetDeclaredPublicInstanceVariablesArrayTask.run(aClass));
        List<Field> publicAndInherittedInstanceVariables = Arrays.asList(aClass.getFields());
        instanceVariables.addAll(publicAndInherittedInstanceVariables);
        // these are the inheritted instance variables only
        instanceVariables.removeAll(publicInstanceVariables);
        return instanceVariables.toArray(new Field[0]);
    }


    public static Field[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}