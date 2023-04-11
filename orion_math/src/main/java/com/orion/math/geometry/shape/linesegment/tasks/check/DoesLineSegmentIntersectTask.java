package com.orion.math.geometry.shape.linesegment.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.Orientation;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.linesegment.LineSegmentRules;

public class DoesLineSegmentIntersectTask extends Orion
{
    public static boolean run(LineSegment x, LineSegment other)
    {
        LineSegmentRules.areValid(x, other);
        Orientation orientation1 = x.getStartPoint().getOrientation(x.getEndPoint(), other.getStartPoint());
        Orientation orientation2 = x.getStartPoint().getOrientation(x.getEndPoint(), other.getEndPoint());
        Orientation orientation3 = other.getStartPoint().getOrientation(other.getEndPoint(), x.getStartPoint());
        Orientation orientation4 = other.getStartPoint().getOrientation(other.getEndPoint(), x.getEndPoint());

        if(orientation1 != orientation2 && orientation3 != orientation4)
        {
            return true;
        }
        else if(orientation1.is(Orientation.Collinear) && x.isPointOnLineSegment(other.getStartPoint()))
        {
            return true;
        }
        else if(orientation2.is(Orientation.Collinear) && x.isPointOnLineSegment(other.getEndPoint()))
        {
            return true;
        }
        else if(orientation3.is(Orientation.Collinear) && other.isPointOnLineSegment(x.getStartPoint()))
        {
            return true;
        }
        else if(orientation4.is(Orientation.Collinear) && other.isPointOnLineSegment(x.getEndPoint()))
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}