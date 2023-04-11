package com.orion.math.geometry.shape.polygon;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;

public class PolygonRules extends MathRule
{
    public static void isValid(OrionList<Point> points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        PointRules.areValid(points.getAsArray());
    }


    public static void isValid(Point[] points)
    {
        Assert.notEmpty(points, "The points input cannot be null/empty.");
        PointRules.areValid(points);
    }


    public static void isValid(Polygon polygon)
    {
        Assert.notNull(polygon, "The polygon input cannot be null.");
        Assert.notNull(polygon.getPoints(), "The polygon points cannot be null.");
        Assert.isGreaterOrEqualTo(polygon.getPoints().getSize(), 3, "Polygon needs at least 3 points.");
        PointRules.areValid(polygon.getPoints().getAsArray());
    }
}