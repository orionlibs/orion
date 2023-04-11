package com.orion.math.geometry.vector.rowvector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.rowvector.RowVector;
import com.orion.math.geometry.vector.rowvector.RowVectorRules;

public class RowVectorHashCodeTask extends Orion
{
    public static int run(RowVector x)
    {
        RowVectorRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}