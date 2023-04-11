package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class AddToColumnOfMatrixTask extends Orion
{
    public static void run(Matrix x, int columnIndex, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        x.getColumn(columnIndex).forAll(e -> e.add(y));
    }


    public static void run(Matrix x, int columnIndex, Vector y)
    {
        MatrixRules.isValid(x);
        VectorRules.isValid(y);
        Vector column = x.getColumn(columnIndex);
        VectorRules.doVectorSizesMatch(column, y);
        x.forAllInColumn(columnIndex, (int i) -> column.get(i).add(y.get(i)));
    }
}