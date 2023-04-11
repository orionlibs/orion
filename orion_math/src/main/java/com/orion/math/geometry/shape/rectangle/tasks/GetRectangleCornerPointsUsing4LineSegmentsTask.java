package com.orion.math.geometry.shape.rectangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.tuple.Quadruple;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;
import java.util.LinkedHashSet;
import java.util.Set;

public class GetRectangleCornerPointsUsing4LineSegmentsTask extends Orion
{
    public static Quadruple<Point, Point, Point, Point> run(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        LineSegmentRules.areValid(s1, s2, s3, s4);
        Set<Point> set = new LinkedHashSet<Point>();
        set.add(s1.getStartPoint());
        set.add(s1.getEndPoint());
        set.add(s2.getStartPoint());
        set.add(s2.getEndPoint());
        set.add(s3.getStartPoint());
        set.add(s3.getEndPoint());
        set.add(s4.getStartPoint());
        set.add(s4.getEndPoint());

        if(set.size() != 4)
        {
            throw new InvalidArgumentException("The given line segments do not have the 4 unique corner points of a rectangle.");
        }
        else
        {
            OrionList<LineSegment> sortedLineSegments = OrionArrayList.<LineSegment>of(s1, s2, s3, s4);
            sortedLineSegments.sort();
            Point topLeftPoint = null;
            Point topRightPoint = null;
            Point bottomLeftPoint = null;
            Point bottomRightPoint = null;

            //3 line segments start at the same X ordinate (rectangle is parallel to the Cartesian axes)
            if(sortedLineSegments.get(0).getStartPoint().getX().equal(sortedLineSegments.get(1).getStartPoint().getX())
                            && sortedLineSegments.get(0).getStartPoint().getX().equal(sortedLineSegments.get(2).getStartPoint().getX()))
            {

                if(sortedLineSegments.get(0).getStartPoint().getY().isGreaterThan(sortedLineSegments.get(1).getEndPoint().getY()))
                {
                    bottomLeftPoint = sortedLineSegments.get(1).getStartPoint();
                    topLeftPoint = sortedLineSegments.get(1).getEndPoint();
                }
                else
                {
                    bottomLeftPoint = sortedLineSegments.get(0).getStartPoint();
                    topLeftPoint = sortedLineSegments.get(0).getEndPoint();
                }

                bottomRightPoint = sortedLineSegments.get(1).getEndPoint();
                topRightPoint = sortedLineSegments.get(2).getEndPoint();
            }
            //2 line segments start at the same X ordinate (rectangle is not parallel to the Cartesian axes)
            else
            {
                topLeftPoint = sortedLineSegments.get(0).getStartPoint();
                topRightPoint = sortedLineSegments.get(0).getEndPoint();
                bottomLeftPoint = sortedLineSegments.get(1).getStartPoint();
                bottomRightPoint = sortedLineSegments.get(2).getEndPoint();
            }

            return Quadruple.<Point, Point, Point, Point>of(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        }

    }
}