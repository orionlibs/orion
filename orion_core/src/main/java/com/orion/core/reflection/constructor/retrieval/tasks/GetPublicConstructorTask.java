package com.orion.core.reflection.constructor.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Constructor;

public class GetPublicConstructorTask extends Orion
{
    public static Constructor<?> run(Object object, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass(), constructorParameterTypes);
    }


    public static Constructor<?> run(Class<?> aClass, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        Assert.notNull(aClass, "class input cannot be null.");

        if(constructorParameterTypes != null && constructorParameterTypes.length == 0)
        {
            constructorParameterTypes = new Class<?>[]
            {Object.class};
        }

        return aClass.getConstructor(constructorParameterTypes);
    }
}