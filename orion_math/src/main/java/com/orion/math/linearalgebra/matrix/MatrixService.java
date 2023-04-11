package com.orion.math.linearalgebra.matrix;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.LinearAlgebraService;
import com.orion.math.linearalgebra.matrix.decomposition.CholeskyDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.EigenDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.LUDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.QRDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.SingularValueDecomposition;
import com.orion.math.linearalgebra.matrix.form.BidiagonalMatrixForm;
import com.orion.math.linearalgebra.matrix.form.HessenbergFormMatrix;
import com.orion.math.linearalgebra.matrix.form.SchurFormMatrix;
import com.orion.math.linearalgebra.matrix.form.TridiagonalMatrixForm;
import com.orion.math.linearalgebra.matrix.tasks.GetMatrixColumnCopyTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsCirculantMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsKacMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsMatrixCMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsMatrixDiagonalTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsMatrixDiagonallyDominantTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsMonotonicMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsNormalMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsOrthogonalMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsUnitaryMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.check.IsVandermondeMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.convert.ConvertNumbersToListOfVectorsTask;
import com.orion.math.linearalgebra.matrix.tasks.convert.GetMatrixAsArrayOfArraysTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetCumulativeProductForColumnsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetCumulativeProductForRowsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetCumulativeSumForColumnsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetCumulativeSumForRowsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetReverseCumulativeProductForColumnsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetReverseCumulativeProductForRowsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetReverseCumulativeSumForColumnsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.cumulativity.GetReverseCumulativeSumForRowsOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.decomposition.GetCholeskyDecompositionOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.decomposition.GetEigenDecompositionOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.decomposition.GetLUDecompositionOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.decomposition.GetQRDecompositionOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.decomposition.GetSingularValueDecompositionOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.norm.GetMatrixNorm1Task;
import com.orion.math.linearalgebra.matrix.tasks.norm.GetMatrixNorm2Task;
import com.orion.math.linearalgebra.matrix.tasks.norm.GetMatrixNormInfinitumTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetBandwidthOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetColumnOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetDeterminantOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetDiagonalOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetDifferencesBetweenSuccessiveMatrixColumnElementsTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetDifferencesBetweenSuccessiveMatrixRowElementsTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetEigenvectorsOfTridiagonalMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetExponentForMatrixToBeNilpotentTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetHadamartMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetLowerTriangularPartOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetMatrixAbsoluteValuesTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetMatrixColumnExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetMatrixConjugateTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetMatrixPeriodTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetMatrixRowExceptDiagonalElementTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetPositionsOfElementInMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetRankOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetSubcolumnOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetSubmatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetSubrowOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetTraceOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.query.GetUpperTriangularPartOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.AddToColumnOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.AddToRowOfMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.AugmentMatrixWithTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.ExponentiateMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixAddTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixDivideTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixMultiplyInPlaceTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixMultiplyTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixNegateTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MatrixSubtractTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MultiplyMatrixColumnTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.MultiplyMatrixRowTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.NormaliseMatrixFrom0To1Task;
import com.orion.math.linearalgebra.matrix.tasks.transform.NormaliseMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.RotateMatrix90DegreesClockwiseTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.SetMatrixColumnTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.SubtractFromMatrixColumnTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.SubtractFromMatrixRowTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.SwapMatrixColumnsTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.SwapMatrixRowsTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.TransformMatrixToBidiagonalMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.TransformMatrixToHessenbergFormMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.TransformMatrixToSchurFormMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.TransformMatrixToTridiagonalMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.transform.TransposeMatrixTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import java.util.stream.IntStream;

public class MatrixService extends OrionService
{
    public static void applyPrecision(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        x.forAll((i, j) -> x.get(i, j).applyPrecision(Precision.getValidPrecision(precision)));
    }


    public static ANumber getDeterminant(Matrix x)
    {
        return GetDeterminantOfMatrixTask.run(x);
    }


    public static ANumber getNumberOfNonZeroDiagonalElements(Matrix x)
    {
        MatrixRules.isValid(x);
        return ANumber.of(x.getDiagonal().filter(element -> element.isNotZero()).count());
    }


    public static ANumber getNumberOfNonZeroDiagonalElements(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        final int precision1 = Precision.getValidPrecision(precision);
        return ANumber.of(x.getDiagonal().filter(element -> element.applyPrecisionGET(precision1).isNotZero()).count());
    }


    public static Vector getDiagonal(Matrix x)
    {
        return GetDiagonalOfMatrixTask.run(x);
    }


    public static ANumber getRank(Matrix x)
    {
        return GetRankOfMatrixTask.run(x);
    }


    public static ANumber[][] getAsArrayOfArrays(Matrix x)
    {
        return GetMatrixAsArrayOfArraysTask.run(x);
    }


    public static Matrix getSubmatrix(Matrix x, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return GetSubmatrixTask.run(x, fromRow, toRow, fromColumn, toColumn);
    }


    public static Matrix negate(Matrix x)
    {
        return MatrixNegateTask.run(x);
    }


    public static Matrix add(Matrix x, Matrix y)
    {
        return MatrixAddTask.run(x, y);
    }


    public static Matrix subtract(Matrix x, Matrix y)
    {
        return MatrixSubtractTask.run(x, y);
    }


    public static boolean isZeroMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNotZero());
    }


    public static boolean isZeroOneMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNotZero() && x.get(i, j).isNotOne());
    }


    public static boolean isIdentityMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> (i == j && x.get(i, j).isNotOne()) || (i != j && x.get(i, j).isNotZero()));
    }


    public static Matrix multiply(Matrix x, ANumber y)
    {
        return MatrixMultiplyTask.run(x, y);
    }


    public static Matrix multiply(Matrix x, Vector y)
    {
        return MatrixMultiplyTask.run(x, y);
    }


    public static Matrix multiply(Matrix x, Matrix y)
    {
        return MatrixMultiplyTask.run(x, y);
    }


    public static void multiplyInPlace(Matrix x, Matrix y)
    {
        MatrixMultiplyInPlaceTask.run(x, y);
    }


    public static Matrix divide(Matrix x, ANumber y)
    {
        return MatrixDivideTask.run(x, y);
    }


    public static OrionList<Vector> convertNumbersToListOfVectors(ANumber[][] elements)
    {
        return ConvertNumbersToListOfVectorsTask.run(elements);
    }


    public static Vector getColumn(Matrix x, int columnIndex)
    {
        return GetColumnOfMatrixTask.run(x, columnIndex);
    }


    public static Vector getColumnExceptDiagonalElement(Matrix x, int columnIndex)
    {
        return GetMatrixColumnExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static Vector getColumnCopyExceptDiagonalElement(Matrix x, int columnIndex)
    {
        return getColumnExceptDiagonalElement(x, columnIndex).getCopy();
    }


    public static Vector getColumnCopy(Matrix x, int columnIndex)
    {
        return GetMatrixColumnCopyTask.run(x, columnIndex);
    }


    public static Vector getSubcolumn(Matrix x, int fromRow, int toRow, int columnIndex)
    {
        return GetSubcolumnOfMatrixTask.run(x, fromRow, toRow, columnIndex);
    }


    public static Vector getRowExceptDiagonalElement(Matrix x, int columnIndex)
    {
        return GetMatrixRowExceptDiagonalElementTask.run(x, columnIndex);
    }


    public static Vector getRowCopyExceptDiagonalElement(Matrix x, int columnIndex)
    {
        return getRowExceptDiagonalElement(x, columnIndex).getCopy();
    }


    public static Vector getSubrow(Matrix x, int rowIndex, int fromColumn, int toColumn)
    {
        return GetSubrowOfMatrixTask.run(x, rowIndex, fromColumn, toColumn);
    }


    public static Matrix transpose(Matrix x)
    {
        return TransposeMatrixTask.run(x);
    }


    public static Matrix getUpperTriangularPart(Matrix x)
    {
        return GetUpperTriangularPartOfMatrixTask.run(x);
    }


    public static Matrix getLowerTriangularPart(Matrix x)
    {
        return GetLowerTriangularPartOfMatrixTask.run(x);
    }


    public static Matrix swapRows(Matrix x, int row1, int row2)
    {
        return SwapMatrixRowsTask.run(x, row1, row2);
    }


    public static void setColumn(Matrix x, int columnIndex, Vector elements)
    {
        SetMatrixColumnTask.run(x, columnIndex, elements);
    }


    public static Matrix swapColumns(Matrix x, int column1, int column2)
    {
        return SwapMatrixColumnsTask.run(x, column1, column2);
    }


    public static void addToRow(Matrix x, int rowIndex, ANumber y)
    {
        AddToRowOfMatrixTask.run(x, rowIndex, y);
    }


    public static void multiplyRow(Matrix x, int rowIndex, ANumber y)
    {
        MultiplyMatrixRowTask.run(x, rowIndex, y);
    }


    public static void multiplyColumn(Matrix x, int columnIndex, ANumber y)
    {
        MultiplyMatrixColumnTask.run(x, columnIndex, y);
    }


    public static void addToColumn(Matrix x, int columnIndex, ANumber y)
    {
        AddToColumnOfMatrixTask.run(x, columnIndex, y);
    }


    public static void subtractFromRow(Matrix x, int rowIndex, ANumber y)
    {
        SubtractFromMatrixRowTask.run(x, rowIndex, y);
    }


    public static void subtractFromColumn(Matrix x, int columnIndex, ANumber y)
    {
        SubtractFromMatrixColumnTask.run(x, columnIndex, y);
    }


    public static void addToRow(Matrix x, int rowIndex, Vector y)
    {
        AddToRowOfMatrixTask.run(x, rowIndex, y);
    }


    public static void addToColumn(Matrix x, int columnIndex, Vector y)
    {
        AddToColumnOfMatrixTask.run(x, columnIndex, y);
    }


    public static void subtractFromRow(Matrix x, int rowIndex, Vector y)
    {
        SubtractFromMatrixRowTask.run(x, rowIndex, y);
    }


    public static void subtractFromColumn(Matrix x, int columnIndex, Vector y)
    {
        SubtractFromMatrixColumnTask.run(x, columnIndex, y);
    }


    public static boolean isLowerTriangular(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i < j && x.get(i, j).isNotZero());
    }


    public static boolean isNotLowerTriangular(Matrix x)
    {
        return !isLowerTriangular(x);
    }


    public static boolean isStrictlyLowerTriangular(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i <= j && x.get(i, j).isNotZero());
    }


    public static boolean isUpperTriangular(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i > j && x.get(i, j).isNotZero());
    }


    public static boolean isNotUpperTriangular(Matrix x)
    {
        return !isUpperTriangular(x);
    }


    public static boolean isStrictlyUpperTriangular(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i >= j && x.get(i, j).isNotZero());
    }


    public static boolean isDiagonal(Matrix x)
    {
        return IsMatrixDiagonalTask.run(x);
    }


    public static Matrix exponentiate(Matrix x, int exponent)
    {
        return ExponentiateMatrixTask.run(x, exponent);
    }


    public static ANumber getExponentForMatrixToBeNilpotent(Matrix x)
    {
        return GetExponentForMatrixToBeNilpotentTask.run(x);
    }


    public static Matrix augmentWith(Matrix x, Vector y)
    {
        return AugmentMatrixWithTask.run(x, y);
    }


    public static Matrix augmentWith(Matrix x, Matrix y)
    {
        return AugmentMatrixWithTask.run(x, y);
    }


    public static boolean isSingular(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getDeterminant().isZero();
    }


    public static boolean isSingular(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        return x.getDeterminant().applyPrecisionGET(precision).isZero();
    }


    public static boolean isNonSingular(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getDeterminant().isNotZero();
    }


    public static boolean isNonSingular(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        return x.getDeterminant().applyPrecisionGET(precision).isNotZero();
    }


    public static boolean isNotSingular(Matrix x)
    {
        return !isSingular(x);
    }


    public static boolean isNotSingular(Matrix x, int precision)
    {
        return !isSingular(x, precision);
    }


    public static boolean isInvertible(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return isNotSingular(x);
    }


    public static boolean isInvertible(Matrix x, int precision)
    {
        MatrixRules.isValidSquareMatrix(x);
        return isNotSingular(x, precision);
    }


    public static boolean isSymmetric(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.transpose().equals(x);
    }


    public static boolean isSkewSymmetric(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.transpose().negate().equals(x);
    }


    public static boolean isAntiSymmetric(Matrix x)
    {
        return isSkewSymmetric(x);
    }


    public static boolean isOrthogonal(Matrix x)
    {
        return IsOrthogonalMatrixTask.run(x);
    }


    public static Matrix getConjugateTranspose(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.getConjugate().transpose();
    }


    public static Matrix getAdjoint(Matrix x)
    {
        return getConjugateTranspose(x);
    }


    public static boolean isUnitary(Matrix x)
    {
        return IsUnitaryMatrixTask.run(x, isNormal(x));
    }


    public static boolean isNormal(Matrix x)
    {
        return IsNormalMatrixTask.run(x);
    }


    public static ANumber getTrace(Matrix x)
    {
        return GetTraceOfMatrixTask.run(x);
    }


    public static Matrix getInverse(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        int n = x.getNumberOfRows();
        Matrix identityMatrix = Matrix.ofIdentity(n);
        Vector[] inverseMatrixColumns = new Vector[n];
        IntStream.range(0, n)
                        .forEach(j -> inverseMatrixColumns[j] = LinearAlgebraService.solveSystemOfLinearEquationsUsingGaussJordanElimination(x, identityMatrix.getColumn(j)));
        OrionList<Vector> vectors = OrionArrayList.of(inverseMatrixColumns);
        return Matrix.of(vectors).transpose();
    }


    public static LUDecomposition getLUDecomposition(Matrix x) throws MatrixIsSingularException
    {
        return GetLUDecompositionOfMatrixTask.run(x, Precision.precision);
    }


    public static LUDecomposition getLUDecomposition(Matrix x, int precision) throws MatrixIsSingularException
    {
        return GetLUDecompositionOfMatrixTask.run(x, precision);
    }


    public static QRDecomposition getQRDecomposition(Matrix x)
    {
        return GetQRDecompositionOfMatrixTask.run(x, Precision.precision);
    }


    public static QRDecomposition getQRDecomposition(Matrix x, int precision)
    {
        return GetQRDecompositionOfMatrixTask.run(x, precision);
    }


    public static SingularValueDecomposition getSingularValueDecomposition(Matrix x)
    {
        return GetSingularValueDecompositionOfMatrixTask.run(x, Precision.precision);
    }


    public static SingularValueDecomposition getSingularValueDecomposition(Matrix x, int precision)
    {
        return GetSingularValueDecompositionOfMatrixTask.run(x, precision);
    }


    public static ANumber getNorm1(Matrix x)
    {
        return GetMatrixNorm1Task.run(x);
    }


    public static ANumber getNorm2(Matrix x)
    {
        return GetMatrixNorm2Task.run(x, Precision.precision);
    }


    public static ANumber getNorm2(Matrix x, int precision)
    {
        return GetMatrixNorm2Task.run(x, precision);
    }


    public static ANumber getNormInfinitum(Matrix x)
    {
        return GetMatrixNormInfinitumTask.run(x);
    }


    public static ANumber getCondition(Matrix x)
    {
        return getCondition(x, Precision.precision);
    }


    public static ANumber getCondition(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        return x.getNorm2(precision).multiplyGET(x.invert().getNorm2(precision));
    }


    public static Matrix rotate90DegreesClockwise(Matrix x)
    {
        return RotateMatrix90DegreesClockwiseTask.run(x);
    }


    public static Matrix getAbsoluteValues(Matrix x)
    {
        return GetMatrixAbsoluteValuesTask.run(x);
    }


    public static Matrix getCumulativeSumForColumns(Matrix x)
    {
        return GetCumulativeSumForColumnsOfMatrixTask.run(x);
    }


    public static Matrix getCumulativeProductForColumns(Matrix x)
    {
        return GetCumulativeProductForColumnsOfMatrixTask.run(x);
    }


    public static Matrix getCumulativeSumForRows(Matrix x)
    {
        return GetCumulativeSumForRowsOfMatrixTask.run(x);
    }


    public static Matrix getCumulativeProductForRows(Matrix x)
    {
        return GetCumulativeProductForRowsOfMatrixTask.run(x);
    }


    public static Matrix getReverseCumulativeSumForColumns(Matrix x)
    {
        return GetReverseCumulativeSumForColumnsOfMatrixTask.run(x);
    }


    public static Matrix getReverseCumulativeProductForColumns(Matrix x)
    {
        return GetReverseCumulativeProductForColumnsOfMatrixTask.run(x);
    }


    public static Matrix getReverseCumulativeSumForRows(Matrix x)
    {
        return GetReverseCumulativeSumForRowsOfMatrixTask.run(x);
    }


    public static Matrix getReverseCumulativeProductForRows(Matrix x)
    {
        return GetReverseCumulativeProductForRowsOfMatrixTask.run(x);
    }


    public static Matrix getDifferencesBetweenSuccessiveRowElements(Matrix x)
    {
        return GetDifferencesBetweenSuccessiveMatrixRowElementsTask.run(x);
    }


    public static Matrix getDifferencesBetweenSuccessiveColumnElements(Matrix x)
    {
        return GetDifferencesBetweenSuccessiveMatrixColumnElementsTask.run(x);
    }


    public static boolean isHermitian(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.equals(x.getConjugateTranspose());
    }


    public static boolean isSelfAdjoint(Matrix x)
    {
        return isHermitian(x);
    }


    public static boolean isAntihermitian(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.equals(x.getConjugateTranspose().negate());
    }


    public static Matrix getMinor(Matrix x, int rowToExclude, int columnToExclude)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidRowIndex(x, rowToExclude);
        MatrixRules.isValidColumnIndex(x, columnToExclude);
        return x.deleteRowAndColumnGET(rowToExclude, columnToExclude);
    }


    public static boolean isBinary(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.findNone((i, j) -> x.get(i, j).isNotZero() && x.get(i, j).isNotOne());
    }


    public static boolean isCMatrix(Matrix x)
    {
        return IsMatrixCMatrixTask.run(x);
    }


    public static boolean isIntegerMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).hasDecimalValue());
    }


    public static boolean isSpecialMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> (i + 1 < j && x.get(i, j).isNotZero())
                        || (i + 1 == j && x.get(i, j).isNotMinusOne())
                        || (i >= j && x.get(i, j).isNotZero() && x.get(i, j).isNotOne()));
    }


    public static boolean isUnitMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNotOne());
    }


    public static boolean isCompatibleWith(Matrix x, Vector vector)
    {
        MatrixRules.isValid(x);
        VectorRules.isValid(vector);
        return x.multiply(vector).getNorm2().isLessThanOrEqual(x.getNorm2().multiplyGET(vector.getMagnitude()));
    }


    public static boolean isCompatibleWith(Matrix x, Vector vector, int precision)
    {
        MatrixRules.isValid(x);
        VectorRules.isValid(vector);
        return x.multiply(vector).getNorm2(precision).isLessThanOrEqual(x.getNorm2(precision).multiplyGET(vector.getMagnitude(precision)));
    }


    public static ANumber getBandwidth(Matrix x)
    {
        return GetBandwidthOfMatrixTask.run(x);
    }


    public static boolean isPositive(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNonPositive());
    }


    public static boolean isNonPositive(Matrix x)
    {
        return !isPositive(x);
    }


    public static boolean isNegative(Matrix x)
    {
        MatrixRules.isValid(x);
        return !x.findAny((i, j) -> x.get(i, j).isNonNegative());
    }


    public static boolean isNonNegative(Matrix x)
    {
        return !isNegative(x);
    }


    public static boolean isCentrosymmetric(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.findNone((i, j) -> x.get(i, j).notEqual(x.get(x.getNumberOfRows() - i + 1, x.getNumberOfRows() - j + 1)));
    }


    public static boolean isBisymmetric(Matrix x)
    {
        return isCentrosymmetric(x) && (isSymmetric(x) || isAntiSymmetric(x));
    }


    public static boolean isCirculantMatrix(Matrix x)
    {
        return IsCirculantMatrixTask.run(x);
    }


    public static boolean isCommutativeWith(Matrix x, Matrix other)
    {
        MatrixRules.areMatrixSizesValidForMultiplication(x, other);
        MatrixRules.areMatrixSizesValidForMultiplication(other, x);
        return x.multiply(other).equals(other.multiply(x));
    }


    public static boolean isComplexMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.findAny((i, j) -> x.get(i, j).isComplexNumber());
    }


    public static Matrix getConjugate(Matrix x)
    {
        return GetMatrixConjugateTask.run(x);
    }


    public static boolean isCoxeterMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.findIfAll((i, j) -> (i == j && x.get(i, j).isOne())
                        && (x.get(i, j).equal(x.get(j, i)) && x.get(i, j).isGreaterThan(1)));
    }


    public static boolean isDiagonallyDominant(Matrix x)
    {
        return IsMatrixDiagonallyDominantTask.run(x);
    }


    public static boolean isDoublyStochastic(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.isLeftStochasticMatrix() && x.isRightStochasticMatrix();
    }


    public static boolean isFibonacciQMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.getNumberOfRows() == 2 && x.get(0, 0).isOne() && x.get(0, 1).isOne()
                        && x.get(1, 0).isOne() && x.get(1, 1).isZero();
    }


    public static boolean isHankelMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> (i + j - 1 > x.getNumberOfRows() && x.get(i, j).isNotZero())
                        || x.get(i, j).notEqual(i + j - 1));
    }


    public static boolean isUpperHessenbergMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> i - j >= 2 && x.get(i, j).isNotZero());
    }


    public static boolean isLowerHessenbergMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> j - i >= 2 && x.get(i, j).isNotZero());
    }


    public static boolean isHessenbergMatrix(Matrix x)
    {
        return isLowerHessenbergMatrix(x) || isUpperHessenbergMatrix(x);
    }


    public static boolean isHilbertMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> x.get(i, j).notEqual(ANumber.of(1).divideGET(i + j - 1)));
    }


    public static boolean isInvolutoryMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.square().equals(Matrix.ofIdentity(x.getNumberOfRows()));
    }


    public static boolean isJordanBlock(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> (i == j && x.get(i, j).notEqual(x.get(0, 0)))
                        || (j - i == 1 && x.get(i, j).isNotOne())
                        || (j - i == 1 && x.get(i, j).isNotZero()));
    }


    public static boolean isKMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.exponentiate(3).equals(Matrix.ofIdentity(x.getNumberOfRows()));
    }


    public static boolean isKacMatrix(Matrix x)
    {
        return IsKacMatrixTask.run(x);
    }


    public static boolean isClementMatrix(Matrix x)
    {
        return isKacMatrix(x);
    }


    public static boolean isMonotonicMatrix(Matrix x)
    {
        return IsMonotonicMatrixTask.run(x);
    }


    public static boolean contains(Matrix x, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        return x.findAny((i, j) -> x.get(i, j).equal(y));
    }


    public static boolean containsExceptInPosition(Matrix x, ANumber y, int rowIndex, int columnIndex)
    {
        MatrixRules.isValid(x);
        MatrixRules.isValidRowIndex(x, rowIndex);
        MatrixRules.isValidColumnIndex(x, columnIndex);
        NumberRules.isNotNull(y);
        return x.findAny((i, j) -> i != rowIndex && j != columnIndex && x.get(i, j).equal(y));
    }


    public static Pair<Integer, Integer>[] getPositionsOfElement(Matrix x, ANumber y)
    {
        return GetPositionsOfElementInMatrixTask.run(x, y);
    }


    public static boolean isPeriodicMatrix(Matrix x)
    {
        return getMatrixPeriod(x).isNotZero();
    }


    public static ANumber getMatrixPeriod(Matrix x)
    {
        return GetMatrixPeriodTask.run(x);
    }


    public static boolean isSquareMatrix(Matrix x)
    {
        return Matrices.isValidSquareMatrix(x);
    }


    public static boolean isRectangularMatrix(Matrix x)
    {
        return Matrices.isValidRectangularMatrix(x);
    }


    public static boolean isRedhefferMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> ((j == 1 || j % i == 0) && x.get(i, j).isNotOne())
                        || x.get(i, j).isNotZero());
    }


    public static boolean isScalarMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> (i == j && x.get(i, j).notEqual(x.get(0, 0)))
                        || x.get(i, j).isNotZero());
    }


    public static boolean isSpecialOrthogonalMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.multiply(x.transpose()).equals(Matrix.ofIdentity(x.getNumberOfRows()))
                        && x.getDeterminant().isOne();
    }


    public static boolean isSpecialUnitaryMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.multiply(x.getConjugateTranspose()).equals(Matrix.ofIdentity(x.getNumberOfRows()))
                        && x.getDeterminant().isOne();
    }


    public static boolean isStochasticMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> Numbers.isNotBetween(x.get(i, j), 0, 1));
    }


    public static boolean isRightStochasticMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.isStochasticMatrix()
                        && !x.findAnyInRows(i -> ArithmeticService.add(x.getRow(i).getAsList()).isNotOne());
    }


    public static boolean isLeftStochasticMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return x.isStochasticMatrix()
                        && !x.findAnyInColumns(j -> ArithmeticService.add(x.getColumn(j).getAsList()).isNotOne());
    }


    public static boolean isTriangularMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        return x.isLowerTriangular() || x.isUpperTriangular();
    }


    public static boolean isTridiagonalMatrix(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        return !x.findAny((i, j) -> ((i == j || j - i == 1 || i - j == 1) && x.get(i, j).isZero())
                        || x.get(i, j).isNotZero());
    }


    public static boolean isUnimodularMatrix(Matrix x)
    {
        MatrixRules.isValid(x);
        ANumber determinant = x.getDeterminant();
        return determinant.isOne() || determinant.isMinusOne();
    }


    public static boolean isVandermondeMatrix(Matrix x)
    {
        return IsVandermondeMatrixTask.run(x);
    }


    public static CholeskyDecomposition getCholeskyDecomposition(Matrix x) throws MatrixIsNotPositiveDefiniteException
    {
        return GetCholeskyDecompositionOfMatrixTask.run(x, Precision.precision);
    }


    public static CholeskyDecomposition getCholeskyDecomposition(Matrix x, int precision) throws MatrixIsNotPositiveDefiniteException
    {
        return GetCholeskyDecompositionOfMatrixTask.run(x, precision);
    }


    public static EigenDecomposition getEigenDecomposition(Matrix x)
    {
        return getEigenDecomposition(x, Precision.precision);
    }


    public static EigenDecomposition getEigenDecomposition(Matrix x, int precision)
    {
        return GetEigenDecompositionOfMatrixTask.run(x, precision);
    }


    public static Matrix getHadamartMatrix(int order)
    {
        return GetHadamartMatrixTask.run(order);
    }


    public static Matrix normalise(Matrix x)
    {
        return NormaliseMatrixTask.run(x);
    }


    public static Matrix normaliseFrom0To1(Matrix x)
    {
        return NormaliseMatrixFrom0To1Task.run(x);
    }


    public static BidiagonalMatrixForm transformToBidiagonalMatrix(Matrix x)
    {
        return TransformMatrixToBidiagonalMatrixTask.run(x);
    }


    public static TridiagonalMatrixForm transformToTridiagonalMatrix(Matrix x)
    {
        return TransformMatrixToTridiagonalMatrixTask.run(x);
    }


    public static EigenSystem getEigenvectorsOfTridiagonalMatrix(TridiagonalMatrixForm form)
    {
        return GetEigenvectorsOfTridiagonalMatrixTask.run(form);
    }


    public static SchurFormMatrix transformToSchurFormMatrix(Matrix x)
    {
        return TransformMatrixToSchurFormMatrixTask.run(x);
    }


    public static HessenbergFormMatrix transformToHessenbergFormMatrix(Matrix x)
    {
        return TransformMatrixToHessenbergFormMatrixTask.run(x);
    }
}