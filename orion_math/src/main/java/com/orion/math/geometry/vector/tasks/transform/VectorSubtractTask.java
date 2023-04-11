package com.orion.math.geometry.vector.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class VectorSubtractTask extends Orion
{
    public static Vector run(Vector x, Vector y)
    {
        VectorRules.doVectorSizesMatch(x, y);
        ANumber[] newVectorPoints = new ANumber[x.getDimensions()];
        x.forAllIndices(i -> newVectorPoints[i] = x.get(i).subtractGET(y.get(i)));
        return Vector.of(newVectorPoints);
    }
}