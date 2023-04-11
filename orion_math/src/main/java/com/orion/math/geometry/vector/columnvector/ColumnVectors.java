package com.orion.math.geometry.vector.columnvector;

import com.orion.math.MathRule;
import com.orion.math.linearalgebra.matrix.Matrices;
import com.orion.math.linearalgebra.matrix.Matrix;

public class ColumnVectors extends MathRule
{
    public static boolean doColumnVectorsSizesMatch(ColumnVector columnVector1, ColumnVector columnVector2)
    {
        return isValid(columnVector1) && isValid(columnVector2)
                        && columnVector1.getNumberOfRows() == columnVector2.getNumberOfRows()
                        && columnVector1.getNumberOfColumns() == columnVector2.getNumberOfColumns();
    }


    public static boolean isValid(Matrix elements)
    {
        return Matrices.isValid(elements) && elements.getNumberOfColumns() == 1;
    }


    public static boolean isValid(ColumnVector columnVector)
    {
        return columnVector != null && isValid(columnVector.getElements());
    }
}