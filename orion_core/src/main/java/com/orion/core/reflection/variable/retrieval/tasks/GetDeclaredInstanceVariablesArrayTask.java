package com.orion.core.reflection.variable.retrieval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.stream.OrionStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class GetDeclaredInstanceVariablesArrayTask extends Orion
{
    public static Field[] run(Class<?> aClass)
    {
        Assert.notNull(aClass, "aClass input cannot be null.");
        Field[] fields = aClass.getDeclaredFields();
        Stream<Field> stream = Arrays.stream(fields)
                        .filter(field -> IsNotStaticVariableTask.run(field));
        return OrionStream.getAsArray(stream, Field.class);
    }


    public static Field[] run(Object object)
    {
        Assert.notNull(object, "object input cannot be null.");
        return run(object.getClass());
    }
}