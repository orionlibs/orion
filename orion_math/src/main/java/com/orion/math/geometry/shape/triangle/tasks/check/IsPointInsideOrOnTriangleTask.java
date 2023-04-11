package com.orion.math.geometry.shape.triangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;

public class IsPointInsideOrOnTriangleTask extends Orion
{
    public static boolean run(Triangle x, Point other, int precision)
    {
        TriangleRules.isValid(x);
        PointRules.isValid(other);
        PointRules.doDimensionsMatch(x.getPointA(), x.getPointB(), x.getPointC(), other);
        Polygon polygon = Polygon.of(new Point[]
        {x.getPointA(), x.getPointB(), x.getPointC()});
        return polygon.isPointInsidePolygon(other);
    }
}