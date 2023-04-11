package com.orion.math.linearalgebra.matrix.functional;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.tasks.check.IsMatrixOfFunction1x1DiagonalTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.convert.ConvertFunctions1x1ToListOfVectorsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.convert.GetMatrixOfFunction1x1AsArrayOfArraysTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetCumulativeProductForColumnsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetCumulativeProductForRowsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetCumulativeSumForColumnsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetCumulativeSumForRowsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetReverseCumulativeProductForColumnsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetReverseCumulativeProductForRowsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetReverseCumulativeSumForColumnsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.cumulativity.GetReverseCumulativeSumForRowsOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.norm.GetMatrixOfFunction1x1Norm2Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetColumnOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetDeterminantOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetDiagonalOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetDifferencesBetweenSuccessiveMatrixOfFunction1x1ColumnElementsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetDifferencesBetweenSuccessiveMatrixOfFunction1x1RowElementsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetLowerTriangularPartOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetMatrixOfFunction1x1ColumnExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetMatrixOfFunction1x1ConjugateTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetMatrixOfFunction1x1RowExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetSubcolumnOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetSubmatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetSubrowOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetTraceOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.query.GetUpperTriangularPartOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.AddToColumnOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.AddToRowOfMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.AugmentMatrixOfFunction1x1WithTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.ExponentiateMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1AddTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1DivideTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1MultiplyInPlaceTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1MultiplyTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1NegateTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MatrixOfFunction1x1SubtractTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MultiplyMatrixOfFunction1x1ColumnTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.MultiplyMatrixOfFunction1x1RowTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.NormaliseMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.RotateMatrixOfFunction1x190DegreesClockwiseTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.SetMatrixOfFunction1x1ColumnTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.SubtractFromMatrixOfFunction1x1ColumnTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.SubtractFromMatrixOfFunction1x1RowTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.SwapMatrixOfFunction1x1ColumnsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.SwapMatrixOfFunction1x1RowsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.transform.TransposeMatrixOfFunction1x1Task;
import com.orion.math.number.ANumber;

public class MatrixOfFunction1x1Service extends OrionService
{
    public static OrionList<VectorOfFunction1x1> convertFunctionsToListOfVectors(Function1x1<ANumber, ANumber>[][] elements)
    {
        return ConvertFunctions1x1ToListOfVectorsTask.run(elements);
    }


    public static Function1x1<ANumber, ANumber>[][] getAsArrayOfArrays(MatrixOfFunction1x1 x)
    {
        return GetMatrixOfFunction1x1AsArrayOfArraysTask.run(x);
    }


    public static MatrixOfFunction1x1 rotate90DegreesClockwise(MatrixOfFunction1x1 x)
    {
        return RotateMatrixOfFunction1x190DegreesClockwiseTask.run(x);
    }


    public static VectorOfFunction1x1 getColumn(MatrixOfFunction1x1 x, int columnIndex)
    {
        return GetColumnOfMatrixOfFunction1x1Task.run(x, columnIndex);
    }


    public static MatrixOfFunction1x1 getMinor(MatrixOfFunction1x1 x, int rowToExclude, int columnToExclude)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1Rules.isValidRowIndex(x, rowToExclude);
        MatrixOfFunction1x1Rules.isValidColumnIndex(x, columnToExclude);
        return x.deleteRowAndColumnGET(rowToExclude, columnToExclude);
    }


    public static Function1x1<ANumber, ANumber> getDeterminant(MatrixOfFunction1x1 x)
    {
        return GetDeterminantOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getSubmatrix(MatrixOfFunction1x1 x, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return GetSubmatrixOfFunction1x1Task.run(x, fromRow, toRow, fromColumn, toColumn);
    }


    public static void setColumn(MatrixOfFunction1x1 x, int columnIndex, VectorOfFunction1x1 elements)
    {
        SetMatrixOfFunction1x1ColumnTask.run(x, columnIndex, elements);
    }


    public static VectorOfFunction1x1 getSubrow(MatrixOfFunction1x1 x, int rowIndex, int fromColumn, int toColumn)
    {
        return GetSubrowOfMatrixOfFunction1x1Task.run(x, rowIndex, fromColumn, toColumn);
    }


    public static VectorOfFunction1x1 getRowExceptDiagonalElement(MatrixOfFunction1x1 x, int columnIndex)
    {
        return GetMatrixOfFunction1x1RowExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static VectorOfFunction1x1 getColumnExceptDiagonalElement(MatrixOfFunction1x1 x, int columnIndex)
    {
        return GetMatrixOfFunction1x1ColumnExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static VectorOfFunction1x1 getSubcolumn(MatrixOfFunction1x1 x, int fromRow, int toRow, int columnIndex)
    {
        return GetSubcolumnOfMatrixOfFunction1x1Task.run(x, fromRow, toRow, columnIndex);
    }


    public static VectorOfFunction1x1 getDiagonal(MatrixOfFunction1x1 x)
    {
        return GetDiagonalOfMatrixOfFunction1x1Task.run(x);
    }


    public static ANumber getNumberOfNonZeroDiagonalElements(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return ANumber.of(x.getDiagonal().filter(element -> element.isNotZeroFunction()).count());
    }


    public static MatrixOfFunction1x1 negate(MatrixOfFunction1x1 x)
    {
        return MatrixOfFunction1x1NegateTask.run(x);
    }


    public static MatrixOfFunction1x1 transpose(MatrixOfFunction1x1 x)
    {
        return TransposeMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 add(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        return MatrixOfFunction1x1AddTask.run(x, y);
    }


    public static MatrixOfFunction1x1 subtract(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        return MatrixOfFunction1x1SubtractTask.run(x, y);
    }


    public static MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 x, ANumber y)
    {
        return MatrixOfFunction1x1MultiplyTask.run(x, y);
    }


    public static MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 x, Number y)
    {
        return MatrixOfFunction1x1MultiplyTask.run(x, y);
    }


    public static MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        return MatrixOfFunction1x1MultiplyTask.run(x, y);
    }


    public static MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return MatrixOfFunction1x1MultiplyTask.run(x, y);
    }


    public static MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 x, Function1x1<ANumber, ANumber> y)
    {
        return MatrixOfFunction1x1MultiplyTask.run(x, y);
    }


    public static void multiplyInPlace(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        MatrixOfFunction1x1MultiplyInPlaceTask.run(x, y);
    }


    public static MatrixOfFunction1x1 divide(MatrixOfFunction1x1 x, ANumber y)
    {
        return MatrixOfFunction1x1DivideTask.run(x, y);
    }


    public static MatrixOfFunction1x1 divide(MatrixOfFunction1x1 x, Function1x1<ANumber, ANumber> y)
    {
        return MatrixOfFunction1x1DivideTask.run(x, y);
    }


    public static MatrixOfFunction1x1 getUpperTriangularPart(MatrixOfFunction1x1 x)
    {
        return GetUpperTriangularPartOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getLowerTriangularPart(MatrixOfFunction1x1 x)
    {
        return GetLowerTriangularPartOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 swapRows(MatrixOfFunction1x1 x, int row1, int row2)
    {
        return SwapMatrixOfFunction1x1RowsTask.run(x, row1, row2);
    }


    public static MatrixOfFunction1x1 swapColumns(MatrixOfFunction1x1 x, int column1, int column2)
    {
        return SwapMatrixOfFunction1x1ColumnsTask.run(x, column1, column2);
    }


    public static void addToRow(MatrixOfFunction1x1 x, int rowIndex, ANumber y)
    {
        AddToRowOfMatrixOfFunction1x1Task.run(x, rowIndex, y);
    }


    public static void addToRow(MatrixOfFunction1x1 x, int rowIndex, VectorOfFunction1x1 y)
    {
        AddToRowOfMatrixOfFunction1x1Task.run(x, rowIndex, y);
    }


    public static void multiplyRow(MatrixOfFunction1x1 x, int rowIndex, ANumber y)
    {
        MultiplyMatrixOfFunction1x1RowTask.run(x, rowIndex, y);
    }


    public static void multiplyColumn(MatrixOfFunction1x1 x, int columnIndex, ANumber y)
    {
        MultiplyMatrixOfFunction1x1ColumnTask.run(x, columnIndex, y);
    }


    public static void addToColumn(MatrixOfFunction1x1 x, int columnIndex, ANumber y)
    {
        AddToColumnOfMatrixOfFunction1x1Task.run(x, columnIndex, y);
    }


    public static void addToColumn(MatrixOfFunction1x1 x, int columnIndex, VectorOfFunction1x1 y)
    {
        AddToColumnOfMatrixOfFunction1x1Task.run(x, columnIndex, y);
    }


    public static void subtractFromRow(MatrixOfFunction1x1 x, int rowIndex, ANumber y)
    {
        SubtractFromMatrixOfFunction1x1RowTask.run(x, rowIndex, y);
    }


    public static void subtractFromRow(MatrixOfFunction1x1 x, int rowIndex, VectorOfFunction1x1 y)
    {
        SubtractFromMatrixOfFunction1x1RowTask.run(x, rowIndex, y);
    }


    public static void subtractFromColumn(MatrixOfFunction1x1 x, int columnIndex, ANumber y)
    {
        SubtractFromMatrixOfFunction1x1ColumnTask.run(x, columnIndex, y);
    }


    public static void subtractFromColumn(MatrixOfFunction1x1 x, int columnIndex, VectorOfFunction1x1 y)
    {
        SubtractFromMatrixOfFunction1x1ColumnTask.run(x, columnIndex, y);
    }


    public static boolean isZeroMatrix(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNotZeroFunction());
    }


    public static boolean isLowerTriangular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i < j && x.get(i, j).isNotZeroFunction());
    }


    public static boolean isNotLowerTriangular(MatrixOfFunction1x1 x)
    {
        return !isLowerTriangular(x);
    }


    public static boolean isStrictlyLowerTriangular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i <= j && x.get(i, j).isNotZeroFunction());
    }


    public static boolean isUpperTriangular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i > j && x.get(i, j).isNotZeroFunction());
    }


    public static boolean isNotUpperTriangular(MatrixOfFunction1x1 x)
    {
        return !isUpperTriangular(x);
    }


    public static boolean isStrictlyUpperTriangular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i >= j && x.get(i, j).isNotZeroFunction());
    }


    public static boolean isDiagonal(MatrixOfFunction1x1 x)
    {
        return IsMatrixOfFunction1x1DiagonalTask.run(x);
    }


    public static MatrixOfFunction1x1 exponentiate(MatrixOfFunction1x1 x, int exponent)
    {
        return ExponentiateMatrixOfFunction1x1Task.run(x, exponent);
    }


    public static MatrixOfFunction1x1 augmentWith(MatrixOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return AugmentMatrixOfFunction1x1WithTask.run(x, y);
    }


    public static MatrixOfFunction1x1 augmentWith(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        return AugmentMatrixOfFunction1x1WithTask.run(x, y);
    }


    public static boolean isSingular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return x.getDeterminant().isZeroFunction();
    }


    public static boolean isNotSingular(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return x.getDeterminant().isNotZeroFunction();
    }


    public static boolean isInvertible(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        return isNotSingular(x);
    }


    public static MatrixOfFunction1x1 getConjugate(MatrixOfFunction1x1 x)
    {
        return GetMatrixOfFunction1x1ConjugateTask.run(x);
    }


    public static MatrixOfFunction1x1 getConjugateTranspose(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return x.getConjugate().transpose();
    }


    public static MatrixOfFunction1x1 getAdjoint(MatrixOfFunction1x1 x)
    {
        return getConjugateTranspose(x);
    }


    public static Function1x1<ANumber, ANumber> getTrace(MatrixOfFunction1x1 x)
    {
        return GetTraceOfMatrixOfFunction1x1Task.run(x);
    }


    public static Function1x1<ANumber, ANumber> getNorm2(MatrixOfFunction1x1 x)
    {
        return GetMatrixOfFunction1x1Norm2Task.run(x);
    }


    public static MatrixOfFunction1x1 getCumulativeSumForColumns(MatrixOfFunction1x1 x)
    {
        return GetCumulativeSumForColumnsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getCumulativeProductForColumns(MatrixOfFunction1x1 x)
    {
        return GetCumulativeProductForColumnsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getCumulativeSumForRows(MatrixOfFunction1x1 x)
    {
        return GetCumulativeSumForRowsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getCumulativeProductForRows(MatrixOfFunction1x1 x)
    {
        return GetCumulativeProductForRowsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getReverseCumulativeSumForColumns(MatrixOfFunction1x1 x)
    {
        return GetReverseCumulativeSumForColumnsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getReverseCumulativeProductForColumns(MatrixOfFunction1x1 x)
    {
        return GetReverseCumulativeProductForColumnsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getReverseCumulativeSumForRows(MatrixOfFunction1x1 x)
    {
        return GetReverseCumulativeSumForRowsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getReverseCumulativeProductForRows(MatrixOfFunction1x1 x)
    {
        return GetReverseCumulativeProductForRowsOfMatrixOfFunction1x1Task.run(x);
    }


    public static MatrixOfFunction1x1 getDifferencesBetweenSuccessiveRowElements(MatrixOfFunction1x1 x)
    {
        return GetDifferencesBetweenSuccessiveMatrixOfFunction1x1RowElementsTask.run(x);
    }


    public static MatrixOfFunction1x1 getDifferencesBetweenSuccessiveColumnElements(MatrixOfFunction1x1 x)
    {
        return GetDifferencesBetweenSuccessiveMatrixOfFunction1x1ColumnElementsTask.run(x);
    }


    public static boolean isSquareMatrix(MatrixOfFunction1x1 x)
    {
        return MatricesOfFunction1x1.isValidSquareMatrix(x);
    }


    public static boolean isRectangularMatrix(MatrixOfFunction1x1 x)
    {
        return MatricesOfFunction1x1.isValidRectangularMatrix(x);
    }


    public static boolean isTriangularMatrix(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        return x.isLowerTriangular() || x.isUpperTriangular();
    }


    public static MatrixOfFunction1x1 normalise(MatrixOfFunction1x1 x)
    {
        return NormaliseMatrixOfFunction1x1Task.run(x);
    }
}