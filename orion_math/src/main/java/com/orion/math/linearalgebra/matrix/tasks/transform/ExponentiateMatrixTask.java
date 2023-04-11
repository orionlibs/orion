package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.IntStream;

public class ExponentiateMatrixTask extends Orion
{
    public static Matrix run(Matrix x, int exponent)
    {
        MatrixRules.isValidSquareMatrix(x);
        NumberRules.isNonNegative(ANumber.of(exponent));

        if(exponent == 0)
        {
            return Matrix.ofIdentity(x.getNumberOfRows());
        }
        else
        {
            Matrix newMatrix = x.getCopy();
            IntStream.range(2, exponent + 1).forEach(i -> newMatrix.multiplyInPlace(x));
            return newMatrix;
        }

    }
}