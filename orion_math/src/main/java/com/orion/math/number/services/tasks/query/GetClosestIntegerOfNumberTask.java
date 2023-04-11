package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public class GetClosestIntegerOfNumberTask extends Orion
{
    public static ANumber run(ANumber x, ANumber ceiling, ANumber floor)
    {
        ANumber ceilingAndXDiff = ceiling.subtractGET(x).getAbsoluteValue();
        ANumber floorAndXDiff = floor.subtractGET(x).getAbsoluteValue();

        if(ceilingAndXDiff.isLessThan(floorAndXDiff) || ceiling.isEven())
        {
            return ceiling;
        }
        else if(ceilingAndXDiff.isGreaterThan(floorAndXDiff))
        {
            return floor;
        }
        else
        {
            return floor;
        }

    }
}