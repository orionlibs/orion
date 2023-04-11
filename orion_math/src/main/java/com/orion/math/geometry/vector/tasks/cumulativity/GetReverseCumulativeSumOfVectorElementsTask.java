package com.orion.math.geometry.vector.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetReverseCumulativeSumOfVectorElementsTask extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[] elements = new ANumber[x.getDimensions()];
        ANumber sum = ANumber.of(0);

        for(int i = x.getDimensions() - 1; i >= 0; i--)
        {
            sum.add(x.get(i));
            elements[i] = sum.getCopy();
        }

        return Vector.of(elements);
    }
}