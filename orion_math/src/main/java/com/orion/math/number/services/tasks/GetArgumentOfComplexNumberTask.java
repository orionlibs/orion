package com.orion.math.number.services.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetArgumentOfComplexNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(x.isComplexNumber())
        {
            Point startPoint = Point.ofZeroPoint(2);
            Point endPoint = Point.of(x.getAsANumber(), x.getImaginaryValueAsANumber());
            return Vector.of(startPoint, endPoint).getAngleWithXAxisAsRadians();
        }
        else
        {
            return ANumber.of(0);
        }

    }
}