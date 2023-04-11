package com.orion.math.geometry.vector.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetReverseCumulativeProductOfVectorElementsTask extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[] elements = new ANumber[x.getDimensions()];
        ANumber product = ANumber.of(1);

        for(int i = x.getDimensions() - 1; i >= 0; i--)
        {
            product.multiply(x.get(i));
            elements[i] = product.getCopy();
        }

        return Vector.of(elements);
    }
}