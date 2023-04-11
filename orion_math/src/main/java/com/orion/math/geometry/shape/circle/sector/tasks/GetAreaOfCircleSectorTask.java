package com.orion.math.geometry.shape.circle.sector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.circle.sector.CircleSectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class GetAreaOfCircleSectorTask extends Orion
{
    public static ANumber run(CircleSector sector)
    {
        CircleSectorRules.isValidIgnoringEndPoint(sector);

        if(Numbers.isBetweenExclusive(sector.getAngleInRadians(), 0, Constants.twoPI))
        {
            return sector.getCircle().getArea().multiplyGET(sector.getAngleInRadians()).divideGET(Constants.twoPI);
        }

        return ANumber.of(0);
    }
}