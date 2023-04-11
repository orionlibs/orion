package com.orion.core.data.structure.list;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.util.List;

public class ListRules extends Orion
{
    @SuppressWarnings("rawtypes")
    public static void notEmpty(List list)
    {
        Assert.notNull(list, "The given list cannot be null.");
    }
}