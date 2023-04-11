package com.orion.math.geometry.shape.circle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.precision.Precision;

public class IsPointInsideCircleTask extends Orion
{
    public static boolean run(Circle x, Point other, int precision)
    {
        CircleRules.isValid(x);
        PointRules.isValid(other);
        PointRules.doDimensionsMatch(x.getCenter(), other);
        precision = Precision.getValidPrecision(precision);
        return Vector.of(x.getCenter(), other).getMagnitude(precision).isLessThan(x.getRadius());
    }
}