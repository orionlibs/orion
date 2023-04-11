package com.orion.math.geometry.point.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.generic.GenericPoint;
import com.orion.math.geometry.point.generic.GenericPointRules;
import java.util.Arrays;

public class GenericPointHashCodeTask extends Orion
{
    public static int run(GenericPoint x)
    {
        GenericPointRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + Arrays.hashCode(x.getCoordinates());
    }
}