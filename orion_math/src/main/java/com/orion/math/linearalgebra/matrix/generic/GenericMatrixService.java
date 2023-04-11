package com.orion.math.linearalgebra.matrix.generic;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.tasks.check.IsCirculantGenericMatrixTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.check.IsGenericMatrixDiagonalTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.convert.ConvertElementsOfGenericMatrixToListOfVectorsTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.convert.GetGenericMatrixAsArrayOfArraysTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.copy.GetGenericMatrixColumnCopyTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GenericMatrixContainsExceptInPositionTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixColumnExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixColumnTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixDiagonalTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixLowerTriangularPartTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixPositionsOfElementTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixRowExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixSubcolumnTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixSubmatrixTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixSubrowTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.query.GetGenericMatrixUpperTriangularPartTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.AugmentGenericMatrixWithTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.RotateGenericMatrix90DegreesClockwiseTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.SetGenericMatrixColumnTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.SwapGenericMatrixColumnsTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.SwapGenericMatrixRowsTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.transform.TransposeGenericMatrixTask;
import com.orion.math.number.ANumber;

public class GenericMatrixService extends OrionService
{
    public static Object[][] getAsArrayOfArrays(GenericMatrix x)
    {
        return GetGenericMatrixAsArrayOfArraysTask.run(x);
    }


    public static ANumber getNumberOfNonNullDiagonalElements(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        return ANumber.of(x.getDiagonal().filter(element -> element != null).count());
    }


    public static GenericVector getDiagonal(GenericMatrix x)
    {
        return GetGenericMatrixDiagonalTask.run(x);
    }


    public static GenericMatrix getSubmatrix(GenericMatrix x, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        Object[][] elementsArray = getAsArrayOfArrays(x);
        return GetGenericMatrixSubmatrixTask.run(x, elementsArray, fromRow, toRow, fromColumn, toColumn);
    }


    public static boolean isNullMatrix(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j) != null);
    }


    public static OrionList<GenericVector> convertElementsToListOfVectors(Object[][] elements)
    {
        return ConvertElementsOfGenericMatrixToListOfVectorsTask.run(elements);
    }


    public static GenericVector getColumn(GenericMatrix x, int columnIndex)
    {
        return GetGenericMatrixColumnTask.run(x, columnIndex);
    }


    public static GenericVector getColumnExceptDiagonalElement(GenericMatrix x, int columnIndex)
    {
        return GetGenericMatrixColumnExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static GenericVector getColumnCopyExceptDiagonalElement(GenericMatrix x, int columnIndex)
    {
        return getColumnExceptDiagonalElement(x, columnIndex).getCopy();
    }


    public static GenericVector getColumnCopy(GenericMatrix x, int columnIndex)
    {
        return GetGenericMatrixColumnCopyTask.run(x, columnIndex);
    }


    public static GenericVector getSubcolumn(GenericMatrix x, int fromRow, int toRow, int columnIndex)
    {
        return GetGenericMatrixSubcolumnTask.run(x, fromRow, toRow, columnIndex);
    }


    public static GenericVector getRowExceptDiagonalElement(GenericMatrix x, int columnIndex)
    {
        return GetGenericMatrixRowExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static GenericVector getRowCopyExceptDiagonalElement(GenericMatrix x, int columnIndex)
    {
        return getRowExceptDiagonalElement(x, columnIndex).getCopy();
    }


    public static GenericVector getSubrow(GenericMatrix x, int rowIndex, int fromColumn, int toColumn)
    {
        return GetGenericMatrixSubrowTask.run(x, rowIndex, fromColumn, toColumn);
    }


    public static GenericMatrix transpose(GenericMatrix x)
    {
        return TransposeGenericMatrixTask.run(x);
    }


    public static GenericMatrix getUpperTriangularPart(GenericMatrix x)
    {
        return GetGenericMatrixUpperTriangularPartTask.run(x);
    }


    public static GenericMatrix getLowerTriangularPart(GenericMatrix x)
    {
        return GetGenericMatrixLowerTriangularPartTask.run(x);
    }


    public static GenericMatrix swapRows(GenericMatrix x, int row1, int row2)
    {
        return SwapGenericMatrixRowsTask.run(x, row1, row2);
    }


    public static void setColumn(GenericMatrix x, int columnIndex, GenericVector elements)
    {
        SetGenericMatrixColumnTask.run(x, columnIndex, elements);
    }


    public static GenericMatrix swapColumns(GenericMatrix x, int column1, int column2)
    {
        return SwapGenericMatrixColumnsTask.run(x, column1, column2);
    }


    public static boolean isLowerTriangular(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i < j && x.get(i, j) != null);
    }


    public static boolean isStrictlyLowerTriangular(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i <= j && x.get(i, j) != null);
    }


    public static boolean isUpperTriangular(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i > j && x.get(i, j) != null);
    }


    public static boolean isStrictlyUpperTriangular(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i >= j && x.get(i, j) != null);
    }


    public static boolean isDiagonal(GenericMatrix x)
    {
        return IsGenericMatrixDiagonalTask.run(x);
    }


    public static GenericMatrix augmentWith(GenericMatrix x, GenericVector y)
    {
        return AugmentGenericMatrixWithTask.run(x, y);
    }


    public static GenericMatrix augmentWith(GenericMatrix x, GenericMatrix y)
    {
        return AugmentGenericMatrixWithTask.run(x, y);
    }


    public static boolean isSymmetric(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        return x.transpose().equals(x);
    }


    public static GenericMatrix rotate90DegreesClockwise(GenericMatrix x)
    {
        return RotateGenericMatrix90DegreesClockwiseTask.run(x);
    }


    public static GenericMatrix getMinor(GenericMatrix x, int rowToExclude, int columnToExclude)
    {
        GenericMatrixRules.isValid(x);
        GenericMatrixRules.isValidRowIndex(x, rowToExclude);
        GenericMatrixRules.isValidColumnIndex(x, columnToExclude);
        return x.deleteRowAndColumnGET(rowToExclude, columnToExclude);
    }


    public static boolean isCirculantMatrix(GenericMatrix x)
    {
        return IsCirculantGenericMatrixTask.run(x);
    }


    public static boolean contains(GenericMatrix x, Object y)
    {
        GenericMatrixRules.isValid(x);
        return x.findAny((i, j) -> x.get(i, j).equals(y));
    }


    public static boolean containsExceptInPosition(GenericMatrix x, Object y, int rowIndex, int columnIndex)
    {
        return GenericMatrixContainsExceptInPositionTask.run(x, y, rowIndex, columnIndex);
    }


    public static Pair<Integer, Integer>[] getPositionsOfElement(GenericMatrix x, Object y)
    {
        return GetGenericMatrixPositionsOfElementTask.run(x, y);
    }


    public static boolean isSquareMatrix(GenericMatrix x)
    {
        return GenericMatrices.isValidSquareMatrix(x);
    }


    public static boolean isRectangularMatrix(GenericMatrix x)
    {
        return GenericMatrices.isValidRectangularMatrix(x);
    }


    public static boolean isTriangularMatrix(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        return x.isLowerTriangular() || x.isUpperTriangular();
    }


    public static boolean isTridiagonalMatrix(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> ((i == j || j - i == 1 || i - j == 1) && x.get(i, j) == null)
                        || x.get(i, j) != null);
    }
}