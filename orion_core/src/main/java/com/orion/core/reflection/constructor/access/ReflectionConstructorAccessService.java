package com.orion.core.reflection.constructor.access;

import com.orion.core.abstraction.OrionService;
import com.orion.core.reflection.constructor.access.tasks.CallConstructorTask;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionConstructorAccessService extends OrionService
{
    public static Object callConstructor(Constructor<?> constructor, Object... constructorArguments) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
    {
        return CallConstructorTask.run(constructor, constructorArguments);
    }
}