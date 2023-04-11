package com.orion.core.reflection.enumeration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class GetEnumerationNameTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes"})
    public static String run(Enum enumerationDefinition)
    {
        Assert.notNull(enumerationDefinition, "enumerationDefinition input cannot be null.");
        return enumerationDefinition.name();
    }
}