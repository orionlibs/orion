package com.orion.math.geometry.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import java.util.Arrays;

public class PointHashCodeTask extends Orion
{
    public static int run(Point x)
    {
        PointRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + Arrays.hashCode(x.getCoordinates());
    }
}