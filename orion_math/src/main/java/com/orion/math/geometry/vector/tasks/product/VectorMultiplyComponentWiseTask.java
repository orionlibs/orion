package com.orion.math.geometry.vector.tasks.product;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class VectorMultiplyComponentWiseTask extends Orion
{
    public static Vector run(Vector x, Vector y)
    {
        VectorRules.doVectorSizesMatch(x, y);
        ANumber[] newVectorPoints = new ANumber[x.getDimensions()];
        x.forAllIndices(i -> newVectorPoints[i] = x.get(i).multiplyGET(y.get(i)));
        return Vector.of(newVectorPoints);
    }
}