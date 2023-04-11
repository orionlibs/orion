package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class IsMatrixDiagonallyDominantTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {
            ANumber sumOfRowExceptDiagonalElement = ArithmeticService.add(x.getRowExceptDiagonalElement(i).getAsList());

            if(x.get(i, i).getAbsoluteValue().isLessThan(sumOfRowExceptDiagonalElement))
            {
                return false;
            }

        }

        return true;
    }
}