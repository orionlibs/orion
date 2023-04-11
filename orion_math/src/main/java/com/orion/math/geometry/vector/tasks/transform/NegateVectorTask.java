package com.orion.math.geometry.vector.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class NegateVectorTask extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[] elements = x.getAsArrayCopy();

        for(int i = 0; i < elements.length; i++)
        {
            elements[i].negate();
        }

        return Vector.of(elements);
    }
}