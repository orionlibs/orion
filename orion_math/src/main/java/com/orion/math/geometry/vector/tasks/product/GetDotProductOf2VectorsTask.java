package com.orion.math.geometry.vector.tasks.product;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDotProductOf2VectorsTask extends Orion
{
    public static ANumber run(Vector x, Vector y)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        ANumber result = ANumber.of(0);
        IntStream.range(0, x.getDimensions())
                        .forEach(i -> result.add(x.get(i).multiplyGET(y.get(i))));
        return result;
    }
}