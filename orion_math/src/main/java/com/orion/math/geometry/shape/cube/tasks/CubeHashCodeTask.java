package com.orion.math.geometry.shape.cube.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.cube.Cube;
import com.orion.math.geometry.shape.cube.CubeRules;

public class CubeHashCodeTask extends Orion
{
    public static int run(Cube x)
    {
        CubeRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getLengthOfSide().hashCode();
    }
}