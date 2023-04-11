package com.orion.math.linearalgebra.matrix.tasks.norm;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class GetMatrixNorm1Task extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValid(x);
        final ANumber result = ANumber.of(0);
        x.forAllColumnIndices(j ->
        {
            Vector columnWithAbsoluteValues = x.getColumn(j).getAbsoluteValues();
            ANumber sum = ArithmeticService.add(columnWithAbsoluteValues.getAsArray());
            result.setNewValues(ArithmeticService.getMaximum(result, sum));
        });
        return result;
    }
}