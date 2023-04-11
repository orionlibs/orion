package com.orion.core.reflection.variable.access.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class MakeInstanceVariableAccessibleTask extends Orion
{
    public void run(Field instanceVariable) throws InaccessibleObjectException, SecurityException
    {
        Assert.notNull(instanceVariable, "instanceVariable input cannot be null.");
        instanceVariable.setAccessible(true);
    }
}