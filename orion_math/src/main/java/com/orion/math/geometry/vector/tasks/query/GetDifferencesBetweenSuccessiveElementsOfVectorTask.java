package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDifferencesBetweenSuccessiveElementsOfVectorTask extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);

        if(x.getDimensions() == 1)
        {
            return Vector.of(new ANumber[]
            {x.get(0)});
        }
        else
        {
            ANumber[] elements = new ANumber[x.getDimensions() - 1];
            IntStream.range(0, elements.length).forEach(i -> elements[i] = x.get(i + 1).subtractGET(x.get(i)));
            return Vector.of(elements);
        }

    }
}