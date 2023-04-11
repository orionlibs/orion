package com.orion.math.geometry.vector.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class NormaliseVectorTask extends Orion
{
    public static Vector run(Vector x, int precision)
    {
        VectorRules.isValid(x);
        ANumber[] newPoints = new ANumber[x.getDimensions()];
        ANumber magnitude = x.getMagnitude(precision);

        if(magnitude.isZero())
        {
            return x;
        }
        else
        {
            x.forAllIndices(i -> newPoints[i] = x.get(i).divideGET(magnitude));
            return Vector.of(newPoints);
        }

    }
}