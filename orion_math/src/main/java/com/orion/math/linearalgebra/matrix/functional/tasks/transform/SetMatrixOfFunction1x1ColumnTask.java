package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class SetMatrixOfFunction1x1ColumnTask extends Orion
{
    public static void run(MatrixOfFunction1x1 x, int columnIndex, VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidColumnIndex(x, columnIndex);
        MatrixOfFunction1x1Rules.doMatrixRowsAndVectorSizeMatch(x, elements);
        Function1x1<ANumber, ANumber>[][] elementsTemp = x.getAsArrayOfArrays();
        x.forAllRowIndices(i -> elementsTemp[i][columnIndex] = elements.get(i));
        x.setElementsAsArrayOfrrays(elementsTemp);
    }
}