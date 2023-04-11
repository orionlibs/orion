package com.orion.math.geometry.vector.rowvector;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class RowVectorRules extends MathRule
{
    public static void doRowVectorsSizesMatch(RowVector rowVector1, RowVector rowVector2)
    {
        isValid(rowVector1);
        isValid(rowVector2);
        Assert.areEqual(rowVector1.getNumberOfRows(), rowVector2.getNumberOfRows(), "Row vectors sizes do not match.");
        Assert.areEqual(rowVector1.getNumberOfColumns(), rowVector2.getNumberOfColumns(), "Row vectors sizes do not match.");
    }


    public static void isValid(Matrix elements)
    {
        MatrixRules.isValid(elements);
        Assert.areEqual(elements.getNumberOfRows(), 1, "ow vector element(s) is/are empty or the number of rows is not 1.");
    }


    public static void isValid(RowVector rowVector)
    {
        Assert.notNull(rowVector, "The rowVector input cannot be null.");
        isValid(rowVector.getElements());
    }
}