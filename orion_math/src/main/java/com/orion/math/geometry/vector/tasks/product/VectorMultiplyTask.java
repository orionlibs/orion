package com.orion.math.geometry.vector.tasks.product;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class VectorMultiplyTask extends Orion
{
    public static Vector run(Vector x, ANumber y)
    {
        VectorRules.isValid(x);
        NumberRules.isNotNull(y);
        ANumber[] newVectorPoints = new ANumber[x.getDimensions()];
        x.forAllIndices(i -> newVectorPoints[i] = x.get(i).multiplyGET(y));
        return Vector.of(newVectorPoints);
    }
}