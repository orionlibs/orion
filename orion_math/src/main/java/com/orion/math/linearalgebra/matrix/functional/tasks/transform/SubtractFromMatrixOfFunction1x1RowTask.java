package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class SubtractFromMatrixOfFunction1x1RowTask extends Orion
{
    public static void run(MatrixOfFunction1x1 x, int rowIndex, ANumber y)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        NumberRules.isNotNull(y);
        VectorOfFunction1x1 row = x.getRow(rowIndex);
        row.forAllIndices(i -> row.set(i, row.get(i).subtract(y)));
    }


    public static void run(MatrixOfFunction1x1 x, int rowIndex, VectorOfFunction1x1 y)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        VectorOfFunction1x1Rules.isValid(y);
        VectorOfFunction1x1 row = x.getRow(rowIndex);
        VectorOfFunction1x1Rules.doVectorSizesMatch(row, y);
        row.forAllIndices(i -> row.set(i, row.get(i).subtract(y.get(i))));
    }
}