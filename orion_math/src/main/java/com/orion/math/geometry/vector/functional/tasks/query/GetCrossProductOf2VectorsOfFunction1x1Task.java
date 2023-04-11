package com.orion.math.geometry.vector.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.number.ANumber;

public class GetCrossProductOf2VectorsOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        Function1x1<ANumber, ANumber> angleBetweenVectorsInDegrees = x.getAngleWithVectorAsDegrees(y);
        FunctionRules.isValid(angleBetweenVectorsInDegrees);
        Function1x1<ANumber, ANumber>[] elements = new Function1x1[3];
        elements[0] = x.get(1).multiply(y.get(2)).subtract(x.get(2).multiply(y.get(1)));
        elements[1] = x.get(2).multiply(y.get(0)).subtract(x.get(0).multiply(y.get(2)));
        elements[2] = x.get(0).multiply(y.get(1)).subtract(x.get(1).multiply(y.get(0)));
        return VectorOfFunction1x1.of(elements);
    }
}