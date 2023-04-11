package com.orion.math.geometry.point.generic;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import java.util.Arrays;

public class GenericPointRules extends MathRule
{
    public static void doDimensionsMatch(GenericPoint point1, GenericPoint point2)
    {
        isValid(point1);
        isValid(point2);
        Assert.areEqual(point1.getDimensions(), point2.getDimensions(), "Generic points dimensions do not match.");
    }


    public static void doDimensionsMatch(GenericPoint... points)
    {
        areValid(points);

        for(int i = 0; i < points.length - 1; i++)
        {

            for(int j = i + 1; j < points.length; j++)
            {
                Assert.areEqual(points[i].getDimensions(), points[j].getDimensions(), "Generic points dimensions do not match.");
            }

        }

    }


    public static void doDimensionsMatch(int dimensions, GenericPoint... points)
    {
        areValid(points);

        for(int i = 0; i < points.length; i++)
        {
            Assert.areEqual(points[i].getDimensions(), dimensions, "Generic points dimensions do not match.");
        }

    }


    public static void isValid(GenericPoint genericPoint)
    {
        Assert.notNull(genericPoint, "The genericPoint input cannot be null.");
        isValid(genericPoint.getCoordinates());
    }


    public static void areValid(GenericPoint... points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        Arrays.stream(points).forEach(point -> isValid(point));
    }


    public static void isValid(Object[] coordinates)
    {
        Assert.notNull(coordinates, "GenericPoint has null coordinates.");
    }


    public static void isValid(Object x, Object y)
    {
        Assert.notNull(x, "GenericPoint has null coordinates.");
        Assert.notNull(y, "GenericPoint has null coordinates.");
    }


    public static void isValid(Object x, Object y, Object z)
    {
        Assert.notNull(x, "GenericPoint has null coordinates.");
        Assert.notNull(y, "GenericPoint has null coordinates.");
        Assert.notNull(z, "GenericPoint has null coordinates.");
    }


    public static void isValid(int dimensions)
    {
        Assert.isNonNegative(dimensions, "GenericPoint cannot have negative number of dimensions.");
    }
}