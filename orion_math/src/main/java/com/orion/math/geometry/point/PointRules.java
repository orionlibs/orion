package com.orion.math.geometry.point;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import java.util.Arrays;

public class PointRules extends MathRule
{
    public static void areNotCollinear(Point point1, Point point2, Point point3)
    {
        Assert.isFalse(PointService.areCollinear(point1, point2, point3), "Points are collinear and cannot form a circle.");
    }


    public static void areNotEqual(Point point1, Point point2)
    {
        areValid(point1, point2);
        Assert.isFalse(point1.equals(point2), "Points cannot be the same.");
    }


    public static void doDimensionsMatch(Point point1, Point point2)
    {
        isValid(point1);
        isValid(point2);
        Assert.isFalse(point1.getDimensions() != point2.getDimensions(), "Points dimensions do not match.");
    }


    public static void doDimensionsMatch(Point... points)
    {
        areValid(points);

        for(int i = 0; i < points.length - 1; i++)
        {

            for(int j = i + 1; j < points.length; j++)
            {
                Assert.isFalse(points[i].getDimensions() != points[j].getDimensions(), "Points dimensions do not match.");
            }

        }

    }


    public static void doDimensionsMatch(OrionList<Point> points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        doDimensionsMatch(points.getAsArray());
    }


    public static void doDimensionsMatch(int dimensions, Point... points)
    {
        areValid(points);

        for(int i = 0; i < points.length; i++)
        {
            Assert.isFalse(points[i].getDimensions() != dimensions, "Points dimensions do not match.");
        }

    }


    public static void doDimensionsMatch(int dimensions, OrionList<Point> points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        doDimensionsMatch(dimensions, points.getAsArray());
    }


    public static void isValid(Point point)
    {
        Assert.notNull(point, "The point input cannot be null.");
        isValid(point.getCoordinates());
    }


    public static void areValid(Point... points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        Arrays.stream(points).forEach(point -> isValid(point));
    }


    public static void isValid(ANumber[] coordinates)
    {
        Assert.notNull(coordinates, "Point has null coordinates.");
    }


    public static void isValid(int dimensions)
    {
        Assert.isNonNegative(dimensions, "Point cannot have negative number of dimensions.");
    }


    public static void areValidForConvexHull(Point... points)
    {
        Assert.notNull(points, "The points input cannot be null.");
        Assert.isFalse(points.length < 3, "At least 3 points are needed to create a convex hull.");
        Arrays.stream(points).forEach(point -> isValid(point));
    }
}