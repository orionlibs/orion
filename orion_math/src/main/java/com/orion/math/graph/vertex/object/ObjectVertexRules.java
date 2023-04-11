package com.orion.math.graph.vertex.object;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class ObjectVertexRules extends MathRule
{
    public static void isValid(Object object)
    {
        Assert.notNull(object, "the object input cannot be null.");
    }


    public static void isValid(ObjectVertex objectVertex)
    {
        Assert.notNull(objectVertex, "the objectVertex input cannot be null.");
        isValid(objectVertex.getObject());
    }
}