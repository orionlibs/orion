package com.orion.core.reflection.constructor.retrieval;

import com.orion.core.abstraction.OrionService;
import com.orion.core.reflection.constructor.retrieval.tasks.GetDeclaredConstructorTask;
import com.orion.core.reflection.constructor.retrieval.tasks.GetPublicConstructorTask;
import java.lang.reflect.Constructor;

public class ReflectionConstructorRetrievalService extends OrionService
{
    public static Constructor<?> getDeclaredConstructor(Object object, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetDeclaredConstructorTask.run(object, constructorParameterTypes);
    }


    public static Constructor<?> getDeclaredConstructor(Class<?> aClass, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetDeclaredConstructorTask.run(aClass, constructorParameterTypes);
    }


    public static Constructor<?> getPublicConstructor(Object object, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetPublicConstructorTask.run(object, constructorParameterTypes);
    }


    public static Constructor<?> getPublicConstructor(Class<?> aClass, Class<?>... constructorParameterTypes) throws NoSuchMethodException, SecurityException
    {
        return GetPublicConstructorTask.run(aClass, constructorParameterTypes);
    }
}