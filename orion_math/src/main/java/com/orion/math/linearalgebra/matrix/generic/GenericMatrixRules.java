package com.orion.math.linearalgebra.matrix.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorRules;
import java.util.Arrays;

public class GenericMatrixRules extends MathRule
{
    public static void areValidDimensionIntervals(GenericMatrix genericMatrix, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        isValid(genericMatrix);
        Assert.isNonNegative(fromRow, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, genericMatrix.getNumberOfRows(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, genericMatrix.getNumberOfRows(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(fromColumn, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, genericMatrix.getNumberOfColumns(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, genericMatrix.getNumberOfColumns(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "GenericMatrix dimension intervals are outside the boundaries.");
    }


    public static void isValidRowsInterval(GenericMatrix genericMatrix, int fromRow, int toRow)
    {
        isValid(genericMatrix);
        Assert.isNonNegative(fromRow, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, genericMatrix.getNumberOfRows(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toRow, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toRow, genericMatrix.getNumberOfRows(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromRow, toRow, "GenericMatrix dimension intervals are outside the boundaries.");
    }


    public static void isValidColumnsInterval(GenericMatrix genericMatrix, int fromColumn, int toColumn)
    {
        isValid(genericMatrix);
        Assert.isNonNegative(fromColumn, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, genericMatrix.getNumberOfColumns(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isNonNegative(toColumn, "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(toColumn, genericMatrix.getNumberOfColumns(), "GenericMatrix dimension intervals are outside the boundaries.");
        Assert.isLessThanOrEqualTo(fromColumn, toColumn, "GenericMatrix dimension intervals are outside the boundaries.");
    }


    public static void doMatrixDimensionsMatch(GenericMatrix genericMatrix)
    {
        isValid(genericMatrix);
        Assert.areEqual(genericMatrix.getNumberOfRows(), genericMatrix.getNumberOfColumns(), "GenericMatrix dimensions do not match.");
    }


    public static void doMatrixSizesMatch(GenericMatrix matrix1, GenericMatrix matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Generic matrices sizes do not match.");
        Assert.areEqual(matrix1.getNumberOfColumns(), matrix2.getNumberOfColumns(), "Generic matrices sizes do not match.");
    }


    public static void doMatrixRowSizesMatch(GenericMatrix matrix1, GenericMatrix matrix2)
    {
        isValid(matrix1);
        isValid(matrix2);
        Assert.areEqual(matrix1.getNumberOfRows(), matrix2.getNumberOfRows(), "Generic matrices row sizes do not match.");
    }


    public static void doMatrixRowsAndVectorSizeMatch(GenericMatrix genericMatrix, GenericVector vector)
    {
        isValid(genericMatrix);
        GenericVectorRules.isValid(vector);
        Assert.areEqual(genericMatrix.getNumberOfRows(), vector.getSize(), "GenericMatrix rows and vector size do not match.");
    }


    public static void doMatrixRowsAndArraySizeMatch(GenericMatrix genericMatrix, Object[] array)
    {
        isValid(genericMatrix);
        GenericVectorRules.isValid(array);
        Assert.areEqual(genericMatrix.getNumberOfRows(), array.length, "GenericMatrix rows and array size do not match.");
    }


    public static void isValid(OrionList<GenericVector> elements)
    {
        Assert.notNull(elements, "GenericMatrix element(s) is/are empty.");
    }


    public static void isValidBlockMatrix(OrionList<GenericMatrix> elements)
    {
        Assert.notEmpty(elements, "GenericMatrix element(s) is/are empty.");
    }


    public static void isValid(Object[][] elements)
    {
        Assert.notEmpty(elements, "GenericMatrix element(s) is/are empty.");
    }


    public static void isValid(int numberOfRows, int numberOfColumns)
    {
        Assert.isNonNegative(numberOfRows, "GenericMatrix cannot have negative dimensions.");
    }


    public static void isSquareMatrix(int numberOfRows, int numberOfColumns)
    {
        Assert.isNonNegative(numberOfRows, "Square matrix cannot have different dimensions.");
        Assert.isNonNegative(numberOfColumns, "Square matrix cannot have different dimensions.");
        Assert.areEqual(numberOfRows, numberOfColumns, "Square matrix cannot have different dimensions.");
    }


    public static void isValid(GenericMatrix genericMatrix)
    {
        Assert.notNull(genericMatrix, "The genericMatrix input cannot be null.");
        isValid(genericMatrix.getElements());
    }


    public static void isValidSquareMatrix(GenericMatrix genericMatrix)
    {
        isValid(genericMatrix);
        isSquareMatrix(genericMatrix.getNumberOfRows(), genericMatrix.getNumberOfColumns());
    }


    public static void areValid(GenericMatrix... matrices)
    {
        Assert.notNull(matrices, "The matrices input cannot be null/empty.");
        Arrays.stream(matrices).forEach(matrix -> isValid(matrix));
    }


    public static void areValid(OrionList<GenericMatrix> matrices)
    {
        Assert.notEmpty(matrices, "The matrices input cannot be null/empty.");
        matrices.stream().forEach(matrix -> isValid(matrix));
    }


    public static void isValidRowIndex(GenericMatrix genericMatrix, int rowIndex)
    {
        isValid(genericMatrix);
        Assert.isNonNegative(rowIndex, "rowIndex is invalid.");
        Assert.isLessThanOrEqualTo(rowIndex, genericMatrix.getNumberOfRows(), "rowIndex is invalid.");
    }


    public static void isValidColumnIndex(GenericMatrix genericMatrix, int columnIndex)
    {
        isValid(genericMatrix);
        Assert.isNonNegative(columnIndex, "columnIndex is invalid.");
        Assert.isLessThanOrEqualTo(columnIndex, genericMatrix.getNumberOfColumns(), "columnIndex is invalid.");
    }
}