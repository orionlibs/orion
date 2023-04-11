package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class AddToColumnOfMatrixOfFunction1x1Task extends Orion
{
    public static void run(MatrixOfFunction1x1 x, int columnIndex, ANumber y)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        NumberRules.isNotNull(y);
        x.getColumn(columnIndex).forAll(e -> e = e.add(y));
    }


    public static void run(MatrixOfFunction1x1 x, int columnIndex, VectorOfFunction1x1 y)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        VectorOfFunction1x1Rules.isValid(y);
        VectorOfFunction1x1 column = x.getColumn(columnIndex);
        VectorOfFunction1x1Rules.doVectorSizesMatch(column, y);
        x.forAllInColumn(columnIndex, (int i) -> column.set(i, column.get(i).add(y.get(i))));
    }
}