package com.orion.math.geometry.vector.rowvector;

import com.orion.math.MathRule;
import com.orion.math.linearalgebra.matrix.Matrices;
import com.orion.math.linearalgebra.matrix.Matrix;

public class RowVectors extends MathRule
{
    public static boolean doRowVectorsSizesMatch(RowVector rowVector1, RowVector rowVector2)
    {
        return isValid(rowVector1) && isValid(rowVector2)
                        && rowVector1.getNumberOfRows() == rowVector2.getNumberOfRows()
                        && rowVector1.getNumberOfColumns() == rowVector2.getNumberOfColumns();
    }


    public static boolean isValid(Matrix elements)
    {
        return Matrices.isValid(elements) && elements.getNumberOfRows() == 1;
    }


    public static boolean isValid(RowVector rowVector)
    {
        return rowVector != null && isValid(rowVector.getElements());
    }
}