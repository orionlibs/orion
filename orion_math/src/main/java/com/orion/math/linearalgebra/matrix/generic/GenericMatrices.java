package com.orion.math.linearalgebra.matrix.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.generic.GenericVector;

public class GenericMatrices extends MathRule
{
    public static boolean areValidDimensionIntervals(GenericMatrix genericMatrix, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return isValid(genericMatrix) && fromRow >= 0 && fromRow <= genericMatrix.getNumberOfRows()
                        && toRow >= 0 && toRow <= genericMatrix.getNumberOfRows()
                        && fromRow <= toRow;
    }


    public static boolean doMatrixDimensionsMatch(GenericMatrix genericMatrix)
    {
        return isValid(genericMatrix) && genericMatrix.getNumberOfRows() == genericMatrix.getNumberOfColumns();
    }


    public static boolean doMatrixSizesMatch(GenericMatrix matrix1, GenericMatrix matrix2)
    {
        return isValid(matrix1) && isValid(matrix2)
                        && matrix1.getNumberOfRows() == matrix2.getNumberOfRows()
                        && matrix1.getNumberOfColumns() == matrix2.getNumberOfColumns();
    }


    public static boolean isValid(OrionList<GenericVector> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isValid(GenericMatrix genericMatrix)
    {
        return genericMatrix != null && isValid(genericMatrix.getElements());
    }


    public static boolean areValid(GenericMatrix... matrices)
    {

        if(matrices != null && matrices.length > 0)
        {

            for(GenericMatrix genericMatrix : matrices)
            {

                if(!isValid(genericMatrix))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static boolean isValidSquareMatrix(GenericMatrix genericMatrix)
    {
        return isValid(genericMatrix) && genericMatrix.getNumberOfRows() == genericMatrix.getNumberOfColumns();
    }


    public static boolean isValidRectangularMatrix(GenericMatrix genericMatrix)
    {
        return isValid(genericMatrix) && genericMatrix.getNumberOfRows() != genericMatrix.getNumberOfColumns();
    }
}