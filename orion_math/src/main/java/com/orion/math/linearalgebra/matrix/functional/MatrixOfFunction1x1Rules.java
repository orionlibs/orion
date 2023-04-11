package com.orion.math.linearalgebra.matrix.functional;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.columnvector.ColumnVector;
import com.orion.math.geometry.vector.columnvector.ColumnVectorRules;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.Arrays;

public class MatrixOfFunction1x1Rules extends MathRule
{
    public static void areValidDimensionIntervals(MatrixOfFunction1x1 matrixOfFunction1x1, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        isValid(matrixOfFunction1x1);
        Assert.isNonNegative(fromRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, matrixOfFunction1x1.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, matrixOfFunction1x1.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(fromColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, matrixOfFunction1x1.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, matrixOfFunction1x1.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void isValidRowsInterval(MatrixOfFunction1x1 matrixOfFunction1x1, int fromRow, int toRow)
    {
        isValid(matrixOfFunction1x1);
        Assert.isNonNegative(fromRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, matrixOfFunction1x1.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, matrixOfFunction1x1.getNumberOfRows(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void isValidColumnsInterval(MatrixOfFunction1x1 matrixOfFunction1x1, int fromColumn, int toColumn)
    {
        isValid(matrixOfFunction1x1);
        Assert.isNonNegative(fromColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, matrixOfFunction1x1.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, matrixOfFunction1x1.getNumberOfColumns(), "Matrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "Matrix dimension intervals are outside the boundaries.");
    }


    public static void doMatrixDimensionsMatch(MatrixOfFunction1x1 matrixOfFunction1x1)
    {
        isValid(matrixOfFunction1x1);
        Assert.areEqual(matrixOfFunction1x1.getNumberOfRows(), matrixOfFunction1x1.getNumberOfColumns(), "Matrix dimensions do not match.");
    }


    public static void doMatrixSizesMatch(MatrixOfFunction1x1 matrix1, MatrixOfFunction1x1 matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Matrix sizes do not match.");
        Assert.areEqual(matrix1.getNumberOfColumns(), matrix2.getNumberOfColumns(), "Matrix sizes do not match.");
    }


    public static void doMatrixRowSizesMatch(MatrixOfFunction1x1 matrix1, MatrixOfFunction1x1 matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Matrix row sizes do not match.");
    }


    public static void doMatrixRowsAndVectorSizeMatch(MatrixOfFunction1x1 matrixOfFunction1x1, VectorOfFunction1x1 vector)
    {
        isValid(matrixOfFunction1x1);
        VectorOfFunction1x1Rules.isValid(vector);
        Assert.areEqual(matrixOfFunction1x1.getNumberOfRows(), vector.getSize(), "Matrix rows and vector size do not match.");
    }


    public static void doMatrixRowsAndArraySizeMatch(MatrixOfFunction1x1 matrixOfFunction1x1, Function1x1<ANumber, ANumber>[] array)
    {
        isValid(matrixOfFunction1x1);
        VectorOfFunction1x1Rules.isValid(array);
        Assert.areEqual(matrixOfFunction1x1.getNumberOfRows(), array.length, "Matrix rows and array size do not match.");
    }


    public static void doMatrixRowsAndVectorSizeMatch(MatrixOfFunction1x1 matrixOfFunction1x1, ColumnVector vector)
    {
        isValid(matrixOfFunction1x1);
        ColumnVectorRules.isValid(vector);
        Assert.areEqual(matrixOfFunction1x1.getNumberOfRows(), vector.getNumberOfRows(), "Matrix rows and column vector size do not match.");
    }


    public static void areMatrixSizesValidForMultiplication(MatrixOfFunction1x1 matrix1, MatrixOfFunction1x1 matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfColumns(), matrix2.getNumberOfRows(), "Matrices sizes are invalid for multiplication.");
    }


    public static void isValid(OrionList<VectorOfFunction1x1> elements)
    {
        Assert.notEmpty(elements, "Matrix element(s) is/are empty.");
    }


    public static void isValid(VectorOfFunction1x1 elements)
    {
        VectorOfFunction1x1Rules.isValid(elements);
    }


    public static void isValid(Function1x1<ANumber, ANumber>[][] elements)
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


    public static void isValid(MatrixOfFunction1x1 matrixOfFunction1x1)
    {
        Assert.notNull(matrixOfFunction1x1, "The matrix input cannot be null.");
        isValid(matrixOfFunction1x1.getElements());
    }


    public static void isValidSquareMatrix(MatrixOfFunction1x1 matrixOfFunction1x1)
    {
        isValid(matrixOfFunction1x1);
        isSquareMatrix(matrixOfFunction1x1.getNumberOfRows(), matrixOfFunction1x1.getNumberOfColumns());
    }


    public static void areValid(MatrixOfFunction1x1... matrices)
    {
        Assert.notEmpty(matrices, "The matrices input cannot be null/empty.");
        Arrays.stream(matrices).forEach(matrix -> isValid(matrix));
    }


    public static void areValid(OrionList<MatrixOfFunction1x1> matrices)
    {
        Assert.notEmpty(matrices, "The matrices input cannot be null/empty.");
        matrices.stream().forEach(matrix -> isValid(matrix));
    }


    public static void isValidRowIndex(MatrixOfFunction1x1 matrix, int rowIndex)
    {
        isValid(matrix);
        Assert.isNonNegative(rowIndex, "rowIndex is invalid.");
        Assert.isLessThanOrEqualTo(rowIndex, matrix.getNumberOfRows(), "rowIndex is invalid.");
    }


    public static void isValidColumnIndex(MatrixOfFunction1x1 matrix, int columnIndex)
    {
        isValid(matrix);
        Assert.isNonNegative(columnIndex, "columnIndex is invalid.");
        Assert.isLessThanOrEqualTo(columnIndex, matrix.getNumberOfColumns(), "columnIndex is invalid.");
    }
}