package com.orion.math.geometry.vector.columnvector;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class ColumnVectorRules extends MathRule
{
    public static void doColumnVectorsSizesMatch(ColumnVector columnVector1, ColumnVector columnVector2)
    {
        isValid(columnVector1);
        isValid(columnVector2);
        Assert.isFalse((columnVector1.getNumberOfRows() != columnVector2.getNumberOfRows())
                        || (columnVector1.getNumberOfColumns() != columnVector2.getNumberOfColumns()), "Column vectors sizes do not match.");
    }


    public static void isValid(Matrix elements)
    {
        MatrixRules.isValid(elements);
        Assert.areEqual(elements.getNumberOfColumns(), 1, "Column vector element(s) is/are empty or the number of columns is not 1.");
    }


    public static void isValid(ColumnVector columnVector)
    {
        Assert.notNull(columnVector, "The columnVector input cannot be null.");
        isValid(columnVector.getElements());
    }
}