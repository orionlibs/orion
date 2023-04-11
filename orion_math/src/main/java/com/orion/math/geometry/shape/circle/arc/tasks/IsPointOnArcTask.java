package com.orion.math.geometry.shape.circle.arc.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.arc.CircleArc;
import com.orion.math.geometry.shape.circle.arc.CircleArcRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;

public class IsPointOnArcTask extends Orion
{
    public static boolean run(CircleArc arc, Point point, int precision)
    {
        CircleArcRules.isValidIgnoringEndPoint(arc);
        PointRules.isValid(point);
        precision = Precision.getValidPrecision(precision);
        Vector vector1 = Vector.of(arc.getCenter(), arc.getStartPoint());
        ANumber angleBetweenStartPointAndXAxis = vector1.getAngleWithXAxisAsRadians(precision);
        ANumber angleBetweenEndPointAndXAxis = angleBetweenStartPointAndXAxis.addGET(arc.getAngleInRadians());
        Vector vector2 = Vector.of(arc.getCenter(), point);
        return arc.getCircle().isPointOnCircle(point, precision)
                        && Numbers.isBetween(vector2.getAngleWithXAxisAsRadians(precision), angleBetweenStartPointAndXAxis, angleBetweenEndPointAndXAxis);
    }
}