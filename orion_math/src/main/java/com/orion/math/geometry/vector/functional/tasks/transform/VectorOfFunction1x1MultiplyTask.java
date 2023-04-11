package com.orion.math.geometry.vector.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class VectorOfFunction1x1MultiplyTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, ANumber y)
    {
        VectorOfFunction1x1Rules.isValid(x);
        NumberRules.isNotNull(y);
        Function1x1<ANumber, ANumber>[] newVectorPoints = new Function1x1[x.getDimensions()];
        x.forAllIndices(i -> newVectorPoints[i] = x.get(i).multiply(y));
        return VectorOfFunction1x1.of(newVectorPoints);
    }
}