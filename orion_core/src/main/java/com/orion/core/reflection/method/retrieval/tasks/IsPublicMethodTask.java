package com.orion.core.reflection.method.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IsPublicMethodTask extends Orion
{
    public static boolean run(Method method)
    {
        Assert.notNull(method, "method input cannot be null.");
        return Modifier.isPublic(method.getModifiers());
    }
}