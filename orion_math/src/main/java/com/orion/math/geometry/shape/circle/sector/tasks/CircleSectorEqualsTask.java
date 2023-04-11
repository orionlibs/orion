package com.orion.math.geometry.shape.circle.sector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.circle.sector.CircleSectorRules;

public class CircleSectorEqualsTask extends Orion
{
    public static boolean run(CircleSector x, Object y)
    {
        CircleSectorRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            CircleSector other = (CircleSector)y;
            return x.getCircle().equals(other.getCircle())
                            && x.getStartPoint().equals(other.getStartPoint())
                            && x.getAngleInRadians().equal(other.getAngleInRadians());
        }

    }
}