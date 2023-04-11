package com.orion.math.geometry.vector.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GetProjectionOfVectorsOfFunction1x1OntoAnotherTask extends Orion
{
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        VectorOfFunction1x1Rules.areValid(x, y);

        if(x.isZeroVector() || y.isZeroVector())
        {
            return VectorOfFunction1x1.of(x.getDimensions());
        }
        else
        {
            Function1x1<ANumber, ANumber> length = x.getDotProduct(y).divide(y.getMagnitude());
            List<Function1x1<ANumber, ANumber>> lengthElements = new ArrayList<>();
            IntStream.range(0, x.getDimensions()).forEach(i -> lengthElements.add(length));
            return y.normalise().multiplyComponentWise(VectorOfFunction1x1.of());
        }

    }
}