package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetUpperTriangularPartOfMatrixOfFunction1x1Task extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        Function1x1<ANumber, ANumber>[][] elements = x.getAsArrayOfArrays();
        x.forAll((i, j) -> elements[i][j] = (i <= j) ? elements[i][j] : Function1x1.Zero);
        return MatrixOfFunction1x1.of(elements);
    }
}