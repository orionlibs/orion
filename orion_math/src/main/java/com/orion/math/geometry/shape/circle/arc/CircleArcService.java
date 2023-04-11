package com.orion.math.geometry.shape.circle.arc;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.arc.tasks.GetLengthOfCircleArcTask;
import com.orion.math.geometry.shape.circle.arc.tasks.IsPointOnArcTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class CircleArcService extends OrionService
{
    public static ANumber getLength(CircleArc arc)
    {
        return GetLengthOfCircleArcTask.run(arc);
    }


    public static boolean isPointOnArc(CircleArc arc, Point point)
    {
        return IsPointOnArcTask.run(arc, point, Precision.precision);
    }


    public static boolean isPointOnArc(CircleArc arc, Point point, int precision)
    {
        return IsPointOnArcTask.run(arc, point, precision);
    }


    public static ANumber getAreaFormedByArc(CircleArc arc)
    {
        CircleArcRules.isValidIgnoringEndPoint(arc);
        return arc.getRadius().squareGET().multiplyGET(arc.getAngleInRadians()).halfGET();
    }


    public static ANumber getAreaOfMinorSegmentFormedByArc(CircleArc arc)
    {
        return getAreaOfMinorSegmentFormedByArc(arc, Precision.precision);
    }


    public static ANumber getAreaOfMinorSegmentFormedByArc(CircleArc arc, int precision)
    {
        CircleArcRules.isValidIgnoringEndPoint(arc);
        precision = Precision.getValidPrecision(precision);
        return arc.getRadius().squareGET().multiplyGET(arc.getAngleInRadians().subtractGET(arc.getAngleInRadians().getSine(precision))).halfGET();
    }


    public static ANumber getAreaOfMajorSegmentFormedByArc(CircleArc arc)
    {
        return getAreaOfMajorSegmentFormedByArc(arc, Precision.precision);
    }


    public static ANumber getAreaOfMajorSegmentFormedByArc(CircleArc arc, int precision)
    {
        CircleArcRules.isValidIgnoringEndPoint(arc);
        precision = Precision.getValidPrecision(precision);
        return arc.getCircle().getArea().subtractGET(getAreaOfMinorSegmentFormedByArc(arc, precision)).getAbsoluteValue();
    }
}