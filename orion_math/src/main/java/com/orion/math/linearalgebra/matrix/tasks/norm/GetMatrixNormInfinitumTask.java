package com.orion.math.linearalgebra.matrix.tasks.norm;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class GetMatrixNormInfinitumTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValid(x);
        final ANumber result = ANumber.of(0);
        x.forAllRowIndices(i ->
        {
            ANumber sum = ArithmeticService.add(x.getRow(i).getAbsoluteValues().getAsArray());
            result.setNewValues(ArithmeticService.getMaximum(result, sum));
        });
        return result;
    }
}