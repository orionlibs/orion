package com.orion.math.geometry.point.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.generic.GenericPoint;
import com.orion.math.geometry.point.generic.GenericPointRules;
import java.util.Arrays;

public class GenericPointEqualsTask extends Orion
{
    public static boolean run(GenericPoint x, Object y)
    {
        GenericPointRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return Arrays.equals(x.getCoordinates(), ((GenericPoint)y).getCoordinates());
        }

    }
}