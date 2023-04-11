package com.orion.core.reflection.constructor.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Constructor;

public class GetPublicConstructorsArrayTask extends Orion
{
    public static Constructor<?>[] run(Class<?> aClass) throws SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");
        return aClass.getConstructors();
    }


    public static Constructor<?>[] run(Object object) throws SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}