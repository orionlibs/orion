package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;

public class TriangleHashCodeTask extends Orion
{
    public static int run(Triangle x)
    {
        TriangleRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;

        if(x.isLengthOnlyTriangle())
        {
            hash = defaultPrimeNumberForHashing * hash + x.getLengthOfA().hashCode();
            hash = defaultPrimeNumberForHashing * hash + x.getLengthOfB().hashCode();
            return defaultPrimeNumberForHashing * hash + x.getLengthOfC().hashCode();
        }
        else
        {
            hash = defaultPrimeNumberForHashing * hash + x.getPointA().hashCode();
            hash = defaultPrimeNumberForHashing * hash + x.getPointB().hashCode();
            return defaultPrimeNumberForHashing * hash + x.getPointC().hashCode();
        }

    }
}