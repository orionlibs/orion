package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetAngleAsRadiansBetween2PointsOnCircleTask extends Orion
{
    public static ANumber run(Circle circle, Point startPoint, Point endPoint, int precision)
    {
        CircleRules.isValid(circle);
        precision = Precision.getValidPrecision(precision);

        if(circle.isPointOnCircle(startPoint, precision) && circle.isPointOnCircle(endPoint, precision))
        {
            Vector vector1 = Vector.of(circle.getCenter(), startPoint);
            Vector vector2 = Vector.of(circle.getCenter(), endPoint);
            return vector1.getAngleWithVectorAsRadians(vector2, precision);
        }

        return ANumber.ofNaN();
    }
}