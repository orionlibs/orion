package com.orion.math.linearalgebra.matrix.tasks.norm;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetMatrixNorm2Task extends Orion
{
    public static ANumber run(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        ANumber result = ANumber.of(0);
        x.forAll((i, j) -> result.add(x.get(i, j).squareGET()));
        return result.getSquareRoot(precision);
    }
}