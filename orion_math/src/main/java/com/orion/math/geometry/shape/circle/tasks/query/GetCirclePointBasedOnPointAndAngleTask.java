package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;

public class GetCirclePointBasedOnPointAndAngleTask extends Orion
{
    public static Point run(Circle circle, Point startPoint, ANumber angle, int trigPrecision)
    {
        CircleRules.isValid(circle);

        if(circle.isPointOnCircle(startPoint))
        {
            ANumber x = circle.getCenter().getX().addGET(circle.getRadius().multiplyGET(angle.getCosine(trigPrecision)));
            ANumber y = circle.getCenter().getY().addGET(circle.getRadius().multiplyGET(angle.getSine(trigPrecision)));
            return Point.of(x, y);
        }

        return null;
    }
}