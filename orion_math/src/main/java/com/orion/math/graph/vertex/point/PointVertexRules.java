package com.orion.math.graph.vertex.point;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;

public class PointVertexRules extends MathRule
{
    public static void isValid(Point point)
    {
        PointRules.isValid(point);
    }


    public static void isValid(PointVertex pointVertex)
    {
        Assert.notNull(pointVertex, "the pointVertex input cannot be null.");
        isValid(pointVertex.getPoint());
    }
}