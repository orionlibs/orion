package com.orion.math.linearalgebra.matrix;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.geometry.vector.columnvector.ColumnVector;
import com.orion.math.geometry.vector.columnvector.ColumnVectorRules;
import com.orion.math.linearalgebra.matrix.block.BlockMatrix;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class MatrixRules extends MathRule
{
    public static void isLowerTriangular(Matrix matrix)
    {
        isValid(matrix);
        Assert.isFalse(matrix.isNotLowerTriangular(), "Matrix is not lower triangular.");
    }


    public static void isUpperTriangular(Matrix matrix)
    {
        isValid(matrix);
        Assert.isFalse(matrix.isNotUpperTriangular(), "Matrix is not upper triangular.");
    }


    public static void areValidDimensionIntervals(Matrix matrix, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        isValid(matrix);
        Assert.isNonNegative(fromRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, matrix.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, matrix.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(fromColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, matrix.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, matrix.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void isValidRowsInterval(Matrix matrix, int fromRow, int toRow)
    {
        isValid(matrix);
        Assert.isNonNegative(fromRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, matrix.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, matrix.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void isValidColumnsInterval(Matrix matrix, int fromColumn, int toColumn)
    {
        isValid(matrix);
        Assert.isNonNegative(fromColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, matrix.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, matrix.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void doMatrixDimensionsMatch(Matrix matrix)
    {
        isValid(matrix);
        Assert.areEqual(matrix.getNumberOfRows(), matrix.getNumberOfColumns(), "Matrix dimensions do not match.");
    }


    public static void doMatrixSizesMatch(Matrix matrix1, Matrix matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Matrix sizes do not match.");
        Assert.areEqual(matrix1.getNumberOfColumns(), matrix2.getNumberOfColumns(), "Matrix sizes do not match.");
    }


    public static void doMatrixRowSizesMatch(Matrix matrix1, Matrix matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Matrix row sizes do not match.");
    }


    public static void doMatrixRowsAndVectorSizeMatch(Matrix matrix, Vector vector)
    {
        isValid(matrix);
        VectorRules.isValid(vector);
        Assert.areEqual(matrix.getNumberOfRows(), vector.getSize(), "Matrix rows and vector size do not match.");
    }


    public static void doMatrixRowsAndArraySizeMatch(Matrix matrix, ANumber[] array)
    {
        isValid(matrix);
        VectorRules.isValid(array);
        Assert.areEqual(matrix.getNumberOfRows(), array.length, "Matrix rows and array size do not match.");
    }


    public static void doMatrixRowsAndVectorSizeMatch(Matrix matrix, ColumnVector vector)
    {
        isValid(matrix);
        ColumnVectorRules.isValid(vector);
        Assert.areEqual(matrix.getNumberOfRows(), vector.getNumberOfRows(), "Matrix rows and column vector size do not match.");
    }


    public static void areMatrixSizesValidForMultiplication(Matrix matrix1, Matrix matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfColumns(), matrix2.getNumberOfRows(), "Matrices sizes are invalid for multiplication.");
    }


    public static void isValid(List<Vector> elements)
    {
        Assert.notEmpty(elements, "Matrix element(s) is/are empty.");
    }


    public static void isValid(Vector elements)
    {
        VectorRules.isValid(elements);
    }


    public static void isValidBlockMatrix(OrionList<Matrix> elements)
    {
        Assert.notEmpty(elements, "Matrix element(s) is/are empty.");
    }


    public static void isValid(ANumber[][] elements)
    {
        Assert.notEmpty(elements, "Matrix element(s) is/are empty.");
    }


    public static void isValid(int numberOfRows, int numberOfColumns)
    {
        Assert.isNonNegative(numberOfRows, "Matrix cannot have negative dimensions.");
        Assert.isNonNegative(numberOfColumns, "Matrix cannot have negative dimensions.");
    }


    public static void isSquareMatrix(int numberOfRows, int numberOfColumns)
    {
        Assert.isNonNegative(numberOfRows, "Square matrix cannot have different dimensions.");
        Assert.isNonNegative(numberOfColumns, "Square matrix cannot have different dimensions.");
        Assert.areEqual(numberOfRows, numberOfColumns, "Square matrix cannot have different dimensions.");
    }


    public static void isValid(Matrix matrix)
    {
        Assert.notNull(matrix, "The matrix input cannot be null.");
        isValid(matrix.getElements());
    }


    public static void isValid(BlockMatrix matrix)
    {
        Assert.notNull(matrix, "The matrix input cannot be null.");
        isValidBlockMatrix(matrix.getElements());
    }


    public static void isValidSquareMatrix(Matrix matrix)
    {
        isValid(matrix);
        isSquareMatrix(matrix.getNumberOfRows(), matrix.getNumberOfColumns());
    }


    public static void areValid(Matrix... matrices)
    {
        Assert.notEmpty(matrices, "The matrices input cannot be null/empty.");
        Arrays.stream(matrices).forEach(matrix -> isValid(matrix));
    }


    public static void areValid(OrionList<Matrix> matrices)
    {
        Assert.notEmpty(matrices, "The matrices input cannot be null/empty.");
        matrices.stream().forEach(matrix -> isValid(matrix));
    }


    public static void isValidRowIndex(Matrix matrix, int rowIndex)
    {
        isValid(matrix);
        Assert.isNonNegative(rowIndex, "rowIndex is invalid.");
        Assert.isLessThanOrEqualTo(rowIndex, matrix.getNumberOfRows(), "rowIndex is invalid.");
    }


    public static void isValidColumnIndex(Matrix matrix, int columnIndex)
    {
        isValid(matrix);
        Assert.isNonNegative(columnIndex, "columnIndex is invalid.");
        Assert.isLessThanOrEqualTo(columnIndex, matrix.getNumberOfColumns(), "columnIndex is invalid.");
    }


    public static void isSymmetric(Matrix matrix)
    {
        isValid(matrix);
        Assert.isFalse(matrix.isAntiSymmetric(), "Matrix is not symmetric.");
    }
}