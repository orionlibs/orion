package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class SwapMatrixOfFunction1x1ColumnsTask extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, int column1, int column2)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidColumnsInterval(x, column1, column2);
        MatrixOfFunction1x1 temp = x.getCopy();
        VectorOfFunction1x1 tempColumn = temp.getColumn(column1);
        temp.setColumn(column1, temp.getColumn(column2));
        temp.setColumn(column2, tempColumn);
        return temp;
    }
}