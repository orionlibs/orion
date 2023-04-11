package com.orion.math.geometry.vector.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDotProductOf2VectorsOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        VectorOfFunction1x1Rules.doVectorSizesMatch(x, y);
        Function1x1<ANumber, ANumber>[] results = new Function1x1[1];
        results[0] = Function1x1.Zero;
        IntStream.range(0, x.getDimensions())
                        .forEach(i -> results[0] = results[0].add(x.get(i).multiply(y.get(i))));
        return results[0];
    }
}