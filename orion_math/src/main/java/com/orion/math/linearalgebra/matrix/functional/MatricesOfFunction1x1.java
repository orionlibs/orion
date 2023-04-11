package com.orion.math.linearalgebra.matrix.functional;

import com.orion.core.data.structure.list.OrionList;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;

public class MatricesOfFunction1x1 extends MathRule
{
    public static boolean areValidDimensionIntervals(MatrixOfFunction1x1 matrix, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return isValid(matrix) && fromRow >= 0 && fromRow <= matrix.getNumberOfRows()
                        && toRow >= 0 && toRow <= matrix.getNumberOfRows()
                        && fromRow <= toRow;
    }


    public static boolean doMatrixDimensionsMatch(MatrixOfFunction1x1 matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() == matrix.getNumberOfColumns();
    }


    public static boolean doMatrixSizesMatch(MatrixOfFunction1x1 matrix1, MatrixOfFunction1x1 matrix2)
    {
        return isValid(matrix1) && isValid(matrix2)
                        && matrix1.getNumberOfRows() == matrix2.getNumberOfRows()
                        && matrix1.getNumberOfColumns() == matrix2.getNumberOfColumns();
    }


    public static boolean isValid(OrionList<VectorOfFunction1x1> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isValid(MatrixOfFunction1x1 matrix)
    {
        return matrix != null && isValid(matrix.getElements());
    }


    public static boolean areValid(MatrixOfFunction1x1... matrices)
    {

        if(matrices != null && matrices.length > 0)
        {

            for(MatrixOfFunction1x1 matrix : matrices)
            {

                if(!isValid(matrix))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static boolean isValidSquareMatrix(MatrixOfFunction1x1 matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() == matrix.getNumberOfColumns();
    }


    public static boolean isValidRectangularMatrix(MatrixOfFunction1x1 matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() != matrix.getNumberOfColumns();
    }
}