package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.IntStream;

public class ExponentiateMatrixOfFunction1x1Task extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, int exponent)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        NumberRules.isNonNegative(ANumber.of(exponent));

        if(exponent == 0)
        {
            return MatrixOfFunction1x1.ofIdentity(x.getNumberOfRows());
        }
        else
        {
            MatrixOfFunction1x1 newMatrix = x.getCopy();
            IntStream.range(2, exponent + 1).forEach(i -> newMatrix.multiplyInPlace(x));
            return newMatrix;
        }

    }
}