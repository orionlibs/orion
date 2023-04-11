package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class AddToRowOfMatrixTask extends Orion
{
    public static void run(Matrix x, int rowIndex, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        x.getRow(rowIndex).forAll(e -> e.add(y));
    }


    public static void run(Matrix x, int rowIndex, Vector y)
    {
        MatrixRules.isValid(x);
        VectorRules.isValid(y);
        Vector row = x.getRow(rowIndex);
        VectorRules.doVectorSizesMatch(row, y);
        x.forAllInRow(rowIndex, (int i) -> row.get(i).add(y.get(i)));
    }
}