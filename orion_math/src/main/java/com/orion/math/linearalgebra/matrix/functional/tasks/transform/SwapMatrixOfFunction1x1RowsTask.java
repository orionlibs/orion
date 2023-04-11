package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class SwapMatrixOfFunction1x1RowsTask extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, int row1, int row2)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidRowsInterval(x, row1, row2);
        MatrixOfFunction1x1 temp = x.getCopy();
        VectorOfFunction1x1 tempVector = temp.getRow(row1);
        temp.setRow(row1, temp.getRow(row2));
        temp.setRow(row2, tempVector);
        return temp;
    }
}