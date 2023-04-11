package com.orion.math.geometry.vector.functional.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetVectorOfFunction1x1CumulativeReverseSumOfVectorElementsTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[] elements = new Function1x1[x.getDimensions()];
        Function1x1<ANumber, ANumber> sum = Function1x1.Zero;

        for(int i = x.getDimensions() - 1; i >= 0; i--)
        {
            sum = sum.add(x.get(i));
            elements[i] = sum;
        }

        return VectorOfFunction1x1.of(elements);
    }
}