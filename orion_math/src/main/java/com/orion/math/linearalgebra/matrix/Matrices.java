package com.orion.math.linearalgebra.matrix;

import com.orion.core.data.structure.list.OrionList;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;

public class Matrices extends MathRule
{
    public static boolean areValidDimensionIntervals(Matrix matrix, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return isValid(matrix) && fromRow >= 0 && fromRow <= matrix.getNumberOfRows()
                        && toRow >= 0 && toRow <= matrix.getNumberOfRows()
                        && fromRow <= toRow;
    }


    public static boolean doMatrixDimensionsMatch(Matrix matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() == matrix.getNumberOfColumns();
    }


    public static boolean doMatrixSizesMatch(Matrix matrix1, Matrix matrix2)
    {
        return isValid(matrix1) && isValid(matrix2)
                        && matrix1.getNumberOfRows() == matrix2.getNumberOfRows()
                        && matrix1.getNumberOfColumns() == matrix2.getNumberOfColumns();
    }


    public static boolean isValid(OrionList<Vector> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isValid(Matrix matrix)
    {
        return matrix != null && isValid(matrix.getElements());
    }


    public static boolean areValid(Matrix... matrices)
    {

        if(matrices != null && matrices.length > 0)
        {

            for(Matrix matrix : matrices)
            {

                if(!isValid(matrix))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static boolean isValidSquareMatrix(Matrix matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() == matrix.getNumberOfColumns();
    }


    public static boolean isValidRectangularMatrix(Matrix matrix)
    {
        return isValid(matrix) && matrix.getNumberOfRows() != matrix.getNumberOfColumns();
    }
}