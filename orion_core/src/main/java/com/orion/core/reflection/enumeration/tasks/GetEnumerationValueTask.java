package com.orion.core.reflection.enumeration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.reflection.method.access.ReflectionMethodAccessService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetEnumerationValueTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes"})
    public static String run(Class<Enum> enumerationClass, String enumerationName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
        Assert.notNull(enumerationClass, "enumerationClass input cannot be null.");
        Assert.notEmpty(enumerationName, "enumerationName input cannot be null/empty.");
        Method getterMethod = enumerationClass.getMethod("get", new Class<?>[] {});
        String enumerationValue = (String)ReflectionMethodAccessService.callMethod(getterMethod, enumerationClass, new Object[0]);

        if(enumerationValue == null)
        {
            enumerationValue = "";
        }

        return enumerationValue;
    }
}