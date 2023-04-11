package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.point.PointService;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;

public class GetCircleThatEnclosesPointsTask extends Orion
{
    public static Circle run(OrionList<Point> points)
    {
        PointRules.doDimensionsMatch(points);
        Pair<Point, Point> farthestPoints = PointService.getFarthestPairOfPoints(points.getAsArray());
        ANumber diameter = farthestPoints.getFirst().getDistanceFromPoint(farthestPoints.getSecond());
        LineSegment lineSegment = LineSegment.of(farthestPoints.getFirst(), farthestPoints.getSecond());
        return Circle.of(lineSegment.getMidpoint(), diameter.halfGET());
    }
}