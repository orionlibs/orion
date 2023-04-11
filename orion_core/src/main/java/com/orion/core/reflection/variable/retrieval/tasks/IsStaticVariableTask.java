package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class IsStaticVariableTask extends Orion
{
    public static boolean run(Field instanceVariable)
    {
        Assert.notNull(instanceVariable, "instanceVariable input cannot be null.");
        return Modifier.isStatic(instanceVariable.getModifiers());
    }
}