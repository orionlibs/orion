package com.orion.math.geometry.vector.functional.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;

public class VectorOfFunction1x1HashCodeTask extends Orion
{
    public static int run(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}