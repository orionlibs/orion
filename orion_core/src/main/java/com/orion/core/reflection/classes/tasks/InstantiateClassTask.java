package com.orion.core.reflection.classes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InaccessibleException;
import com.orion.core.exception.InvalidArgumentException;
import java.lang.reflect.InvocationTargetException;

public class InstantiateClassTask extends Orion
{
    public static Object run(Class<?> classToInstantiate, Class<?>[] constructorArgumentTypes, Object[] constructorArguments) throws InvocationTargetException, InaccessibleException
    {
        Assert.notNull(classToInstantiate, "classToInstantiate cannot be null.");

        try
        {
            return classToInstantiate.getConstructor(constructorArgumentTypes).newInstance(constructorArguments);
        }
        catch(NoSuchMethodException e)
        {
            throw new InvalidArgumentException("The required constructor does not exist.");
        }
        catch(SecurityException e)
        {
            throw e;
        }
        catch(InstantiationException e)
        {
            throw new InaccessibleException("The constructor is inaccessible.", classToInstantiate.getName());
        }
        catch(IllegalAccessException e)
        {
            throw new InaccessibleException("The class {} is abstract and cannot be instantiated.", classToInstantiate.getName());
        }
        catch(IllegalArgumentException e)
        {
            throw e;
        }

    }


    public static Object run(String classToInstantiateString, Class<?>[] constructorArgumentTypes, Object[] constructorArguments) throws InvocationTargetException, InaccessibleException
    {

        try
        {
            Class<?> classToInstantiate = ClassLoader.getSystemClassLoader().loadClass(classToInstantiateString);
            return run(classToInstantiate, constructorArgumentTypes, constructorArguments);
        }
        catch(ClassNotFoundException e)
        {
            throw new InvalidArgumentException("The class {} does not exist.", classToInstantiateString);
        }

    }
}