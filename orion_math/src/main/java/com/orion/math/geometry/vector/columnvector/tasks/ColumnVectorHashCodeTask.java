package com.orion.math.geometry.vector.columnvector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.columnvector.ColumnVector;
import com.orion.math.geometry.vector.columnvector.ColumnVectorRules;

public class ColumnVectorHashCodeTask extends Orion
{
    public static int run(ColumnVector x)
    {
        ColumnVectorRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getElements().hashCode();
    }
}