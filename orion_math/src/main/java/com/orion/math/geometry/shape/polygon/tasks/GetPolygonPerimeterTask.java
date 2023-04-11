package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;
import com.orion.math.number.ANumber;

public class GetPolygonPerimeterTask extends Orion
{
    public static ANumber run(Polygon polygon)
    {
        PolygonRules.isValid(polygon);
        ANumber perimeter = ANumber.of(0);
        OrionList<Point> points = polygon.getPoints();
        points.forAllConsequtivePairs((Integer i, Integer j) ->
        {
            LineSegment polygonLineSegment = LineSegment.of(points.get(i), points.get(j));
            perimeter.add(polygonLineSegment.getLength());
        });
        return perimeter;
    }
}