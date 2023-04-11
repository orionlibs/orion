package com.orion.math.geometry.shape.line;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class LineRules extends MathRule
{
    public static void doesPointHave2Dimensions(Point point)
    {
        PointRules.isValid(point);
        Assert.isFalse(point.getDimensions() != 2, "Point dimensions have to be 2.");
    }


    public static void isValid(Line line)
    {
        Assert.notNull(line, "The line input cannot be null.");
        NumberRules.isNotNull(line.getA());
        NumberRules.isNotNull(line.getB());
        NumberRules.isNotNull(line.getC());
    }


    public static void areValid(Line... lines)
    {
        Assert.notEmpty(lines, "The lines input cannot be null/empty.");
        Arrays.stream(lines).forEach(line -> isValid(line));
    }
}