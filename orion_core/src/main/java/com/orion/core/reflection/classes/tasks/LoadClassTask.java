package com.orion.core.reflection.classes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class LoadClassTask extends Orion
{
    public static Class<?> run(String className) throws ClassNotFoundException
    {
        Assert.notEmpty(className, "className input cannot be null/empty.");
        return ClassLoader.getSystemClassLoader().loadClass(className);
    }
}