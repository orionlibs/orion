package com.orion.core.reflection.method.access.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Method;

public class MakeMethodAccessibleTask extends Orion
{
    public void run(Method method) throws SecurityException
    {
        Assert.notNull(method, "method input cannot be null.");
        method.setAccessible(true);
    }
}