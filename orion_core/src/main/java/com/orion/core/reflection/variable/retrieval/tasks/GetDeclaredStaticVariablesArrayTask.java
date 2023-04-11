package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GetDeclaredStaticVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "aClass input cannot be null.");
        Field[] fields = aClass.getDeclaredFields();
        return Arrays.stream(fields)
                        .filter(field -> Modifier.isStatic(field.getModifiers()))
                        .collect(Collectors.toList())
                        .toArray(new Field[0]);
    }
}