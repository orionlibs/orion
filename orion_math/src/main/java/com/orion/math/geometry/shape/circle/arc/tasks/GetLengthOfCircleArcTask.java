package com.orion.math.geometry.shape.circle.arc.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.shape.circle.arc.CircleArc;
import com.orion.math.geometry.shape.circle.arc.CircleArcRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class GetLengthOfCircleArcTask extends Orion
{
    public static ANumber run(CircleArc arc)
    {
        CircleArcRules.isValidIgnoringEndPoint(arc);

        if(Numbers.isBetweenExclusive(arc.getAngleInRadians(), 0, Constants.twoPI))
        {
            return arc.getCircle().getCircumference().multiplyGET(arc.getAngleInRadians()).divideGET(Constants.twoPI);
        }

        return ANumber.of(0);
    }
}