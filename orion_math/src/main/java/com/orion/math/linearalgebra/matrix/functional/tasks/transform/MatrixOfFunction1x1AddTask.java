package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class MatrixOfFunction1x1AddTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        MatrixOfFunction1x1Rules.areValid(x, y);
        MatrixOfFunction1x1Rules.doMatrixSizesMatch(x, y);
        Function1x1<ANumber, ANumber>[][] elements = new Function1x1[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).add(y.get(i, j)));
        return MatrixOfFunction1x1.of(elements);
    }
}