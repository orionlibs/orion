package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class SetMatrixColumnTask extends Orion
{
    public static void run(Matrix x, int columnIndex, Vector elements)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidColumnIndex(x, columnIndex);
        MatrixRules.doMatrixRowsAndVectorSizeMatch(x, elements);
        ANumber[][] elementsTemp = x.getAsArrayOfArrays();
        x.forAllRowIndices(i -> elementsTemp[i][columnIndex] = elements.get(i).getCopy());
        x.setElementsAsArrayOfrrays(elementsTemp);
    }
}