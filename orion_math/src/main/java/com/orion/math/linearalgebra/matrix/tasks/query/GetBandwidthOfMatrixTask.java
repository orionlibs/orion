package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import java.util.concurrent.atomic.AtomicInteger;

public class GetBandwidthOfMatrixTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValid(x);
        AtomicInteger bandwidth = new AtomicInteger(-1);
        x.forAll((i, j) ->
        {
            int absoluteValueOfIndicesDifference = Math.abs(i - j);

            if(x.get(i, j).isNotZero() && absoluteValueOfIndicesDifference > bandwidth.intValue())
            {
                bandwidth.set(absoluteValueOfIndicesDifference);
            }

        });
        return ANumber.of(bandwidth.intValue());
    }
}