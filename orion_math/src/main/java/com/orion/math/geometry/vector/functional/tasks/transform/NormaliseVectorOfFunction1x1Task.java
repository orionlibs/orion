package com.orion.math.geometry.vector.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class NormaliseVectorOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, int precision)
    {
        VectorOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[] newVectorPoints = new Function1x1[x.getDimensions()];
        Function1x1<ANumber, ANumber> magnitude = x.getMagnitude(precision);

        if(magnitude.isZeroFunction())
        {
            return x;
        }
        else
        {
            x.forAllIndices(i -> newVectorPoints[i] = x.get(i).divide(magnitude));
            return VectorOfFunction1x1.of(newVectorPoints);
        }

    }
}