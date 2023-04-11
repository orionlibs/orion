package com.orion.math.geometry.vector.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDifferenceBetweenSuccessiveElementsOfVectorOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x)
    {
        VectorOfFunction1x1Rules.isValid(x);

        if(x.getDimensions() == 1)
        {
            return VectorOfFunction1x1.of(new Function1x1[]
            {x.get(0)});
        }
        else
        {
            Function1x1<ANumber, ANumber>[] elements = new Function1x1[x.getDimensions() - 1];
            IntStream.range(0, elements.length).forEach(i -> elements[i] = x.get(i + 1).subtract(x.get(i)));
            return VectorOfFunction1x1.of(elements);
        }

    }
}