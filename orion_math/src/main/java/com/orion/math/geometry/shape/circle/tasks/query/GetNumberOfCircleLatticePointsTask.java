package com.orion.math.geometry.shape.circle.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetNumberOfCircleLatticePointsTask extends Orion
{
    public static ANumber run(Circle circle, int precision)
    {
        CircleRules.isValid(circle);
        precision = Precision.getValidPrecision(precision);

        if(circle.getRadius().isNonPositive())
        {
            return ANumber.of(0);
        }
        else
        {
            ANumber result = ANumber.of(0);
            ANumber xMinimum = circle.getCenter().getX().subtractGET(circle.getRadius()).getFloor();
            ANumber xMaximum = circle.getCenter().getX().addGET(circle.getRadius()).getCeiling();
            ANumber yMinimum = circle.getCenter().getY().subtractGET(circle.getRadius()).getFloor();
            ANumber yMaximum = circle.getCenter().getY().addGET(circle.getRadius()).getCeiling();

            for(int i = xMinimum.getAsInt(); i <= xMaximum.getAsInt(); i++)
            {

                for(int j = yMinimum.getAsInt(); j <= yMaximum.getAsInt(); j++)
                {

                    if(circle.isPointOnCircle(Point.of(i, j), precision))
                    {
                        result.addOne();
                    }

                }

            }

            return result;
        }

    }
}