package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetAbsoluteValuesOfVectorElementsTask extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[] elementsWithAbsoluteValue = new ANumber[x.getDimensions()];
        x.forAllIndices(i -> elementsWithAbsoluteValue[i] = x.get(i).getAbsoluteValue());
        return Vector.of(elementsWithAbsoluteValue);
    }
}