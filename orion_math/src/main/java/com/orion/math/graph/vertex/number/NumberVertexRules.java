package com.orion.math.graph.vertex.number;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class NumberVertexRules extends MathRule
{
    public static void isValid(ANumber point)
    {
        NumberRules.isNotNull(point);
    }


    public static void isValid(NumberVertex numberVertex)
    {
        Assert.notNull(numberVertex, "the numberVertex input cannot be null.");
        isValid(numberVertex.getPoint());
    }
}