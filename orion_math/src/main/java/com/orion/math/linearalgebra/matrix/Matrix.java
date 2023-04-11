package com.orion.math.linearalgebra.matrix;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.decomposition.CholeskyDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.EigenDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.LUDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.QRDecomposition;
import com.orion.math.linearalgebra.matrix.decomposition.SingularValueDecomposition;
import com.orion.math.linearalgebra.matrix.form.BidiagonalMatrixForm;
import com.orion.math.linearalgebra.matrix.form.HessenbergFormMatrix;
import com.orion.math.linearalgebra.matrix.form.SchurFormMatrix;
import com.orion.math.linearalgebra.matrix.form.TridiagonalMatrixForm;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Matrix implements MathObject, Cloneable
{
    private OrionList<Vector> elements;


    public Matrix()
    {
        this(OrionArrayList.<Vector>of());
    }


    public Matrix(List<Vector> elements)
    {
        MatrixRules.isValid(elements);
        this.elements = OrionArrayList.<Vector>of(elements);
    }


    public Matrix(ANumber[][] elements)
    {
        MatrixRules.isValid(elements);
        this.elements = MatrixService.convertNumbersToListOfVectors(elements);
    }


    public Matrix(int numberOfRows, int numberOfColumns)
    {
        MatrixRules.isValid(numberOfRows, numberOfColumns);
        ANumber[][] newElements = new ANumber[numberOfRows][numberOfColumns];
        NumberArrayStream.setValue(newElements, ANumber.of(0));
        this.elements = MatrixService.convertNumbersToListOfVectors(newElements);
    }


    public Matrix(Vector elements)
    {
        MatrixRules.isValid(elements);
        OrionList<Vector> newElements = OrionArrayList.of(elements);
        this.elements = newElements;
    }


    public static Matrix of()
    {
        return new Matrix();
    }


    public static Matrix of(List<Vector> elements)
    {
        return new Matrix(elements);
    }


    public static Matrix of(Vector elements)
    {
        return new Matrix(elements);
    }


    public static Matrix of(ANumber[][] elements)
    {
        return new Matrix(elements);
    }


    public static Matrix of(int numberOfRows, int numberOfColumns)
    {
        return new Matrix(numberOfRows, numberOfColumns);
    }


    public static Matrix ofRandom(int numberOfRows, int numberOfColumns)
    {
        return ofRandom(numberOfRows, numberOfColumns, 0, 1);
    }


    public static Matrix ofRandom(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        return MatrixInternalService.ofRandom(numberOfRows, numberOfColumns, minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
    }


    public static Matrix ofDiagonal(Vector diagonalElements)
    {
        return MatrixInternalService.ofDiagonal(diagonalElements);
    }


    public static Matrix ofIdentity(int numberOfRowsAndColumns)
    {
        return MatrixInternalService.ofIdentity(numberOfRowsAndColumns);
    }


    public static Matrix ofZero(int numberOfRows, int numberOfColumns)
    {
        return MatrixInternalService.ofZero(numberOfRows, numberOfColumns);
    }


    public static Matrix ofSkewDiagonal(Vector skewDiagonalElements)
    {
        return MatrixInternalService.ofSkewDiagonal(skewDiagonalElements);
    }


    public int getNumberOfRows()
    {
        return getElements().getSize();
    }


    public int getNumberOfColumns()
    {
        return getElements().get(0).getDimensions();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public ANumber getDeterminant()
    {
        return MatrixService.getDeterminant(this);
    }


    public ANumber getRank()
    {
        return MatrixService.getRank(this);
    }


    public GenericMatrix getAsGenericMatrix()
    {
        return GenericMatrix.of(OrionArrayList.<GenericVector>of(getElements().mapToList(e -> e.getAsGenericVector())));
    }


    public ANumber[][] getAsArrayOfArrays()
    {
        return MatrixService.getAsArrayOfArrays(this);
    }


    public ANumber[][] getAsArrayOfArraysCopy()
    {
        return getCopy().getAsArrayOfArrays();
    }


    public void applyPrecision(int precision)
    {
        MatrixService.applyPrecision(this, precision);
    }


    public Matrix applyPrecisionGET(int precision)
    {
        Matrix copy = getCopy();
        MatrixService.applyPrecision(copy, precision);
        return copy;
    }


    public Matrix getSubmatrix(int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return MatrixService.getSubmatrix(this, fromRow, toRow, fromColumn, toColumn);
    }


    public void set(int rowIndex, int columnIndex, ANumber element)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        MatrixRules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).set(columnIndex, element);
    }


    public Matrix setGET(int rowIndex, int columnIndex, ANumber element)
    {
        Matrix newMatrix = getCopy();
        newMatrix.set(rowIndex, columnIndex, element);
        return newMatrix;
    }


    public void setRow(int rowIndex, Vector elements)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        getElements().set(rowIndex, elements);
    }


    public Matrix setRowGET(int rowIndex, Vector elements)
    {
        Matrix newMatrix = getCopy();
        newMatrix.setRow(rowIndex, elements);
        return newMatrix;
    }


    public void setColumn(int columnIndex, Vector elements)
    {
        MatrixService.setColumn(this, columnIndex, elements);
    }


    public Matrix setColumnGET(int columnIndex, Vector elements)
    {
        Matrix newMatrix = getCopy();
        newMatrix.setColumn(columnIndex, elements);
        return newMatrix;
    }


    public void delete(int rowIndex, int columnIndex)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        MatrixRules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).delete(columnIndex);
    }


    public Matrix deleteGET(int rowIndex, int columnIndex)
    {
        Matrix newMatrix = getCopy();
        newMatrix.delete(rowIndex, columnIndex);
        return newMatrix;
    }


    public void deleteRow(int rowIndex)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        getElements().delete(rowIndex);
    }


    public Matrix deleteRowGET(int rowIndex)
    {
        Matrix newMatrix = getCopy();
        newMatrix.deleteRow(rowIndex);
        return newMatrix;
    }


    public void deleteColumn(int columnIndex)
    {
        MatrixRules.isValidColumnIndex(this, columnIndex);
        IntStream.range(0, getNumberOfRows()).forEach(i -> delete(i, columnIndex));
    }


    public Matrix deleteColumnGET(int columnIndex)
    {
        Matrix newMatrix = getCopy();
        newMatrix.deleteColumn(columnIndex);
        return newMatrix;
    }


    public void deleteRowAndColumn(int rowIndex, int columnIndex)
    {
        deleteRow(rowIndex);
        deleteColumn(columnIndex);
    }


    public Matrix deleteRowAndColumnGET(int rowIndex, int columnIndex)
    {
        Matrix newMatrix = getCopy();
        newMatrix.deleteRowAndColumn(rowIndex, columnIndex);
        return newMatrix;
    }


    public Vector getSubrow(int rowIndex, int fromColumn, int toColumn)
    {
        return MatrixService.getSubrow(this, rowIndex, fromColumn, toColumn);
    }


    public Vector getRow(int rowIndex)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        return getElements().get(rowIndex);
    }


    public Vector getRowExceptDiagonalElement(int rowIndex)
    {
        return MatrixService.getRowExceptDiagonalElement(this, rowIndex);
    }


    public Vector getRowCopyExceptDiagonalElement(int rowIndex)
    {
        return MatrixService.getRowCopyExceptDiagonalElement(this, rowIndex);
    }


    public Vector getRowCopy(int rowIndex)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        return getElements().get(rowIndex).getCopy();
    }


    public ANumber get(int rowIndex, int columnIndex)
    {
        MatrixRules.isValidRowIndex(this, rowIndex);
        MatrixRules.isValidColumnIndex(this, columnIndex);
        return getElements().get(rowIndex).get(columnIndex);
    }


    public Vector getColumn(int columnIndex)
    {
        return MatrixService.getColumn(this, columnIndex);
    }


    public ANumber[] getColumnAsArray(int columnIndex)
    {
        return MatrixService.getColumn(this, columnIndex).getAsArray();
    }


    public Vector getColumnExceptDiagonalElement(int columnIndex)
    {
        return MatrixService.getColumnExceptDiagonalElement(this, columnIndex);
    }


    public Vector getColumnCopyExceptDiagonalElement(int columnIndex)
    {
        return MatrixService.getColumnCopyExceptDiagonalElement(this, columnIndex);
    }


    public Vector getColumnCopy(int columnIndex)
    {
        return MatrixService.getColumnCopy(this, columnIndex);
    }


    public ANumber[] getColumnCopyAsArray(int columnIndex)
    {
        return MatrixService.getColumnCopy(this, columnIndex).getAsArray();
    }


    public Vector getSubcolumn(int fromRow, int toRow, int columnIndex)
    {
        return MatrixService.getSubcolumn(this, fromRow, toRow, columnIndex);
    }


    public Vector getDiagonal()
    {
        return MatrixService.getDiagonal(this);
    }


    public ANumber getNumberOfNonZeroDiagonalElements()
    {
        return MatrixService.getNumberOfNonZeroDiagonalElements(this);
    }


    public ANumber getNumberOfNonZeroDiagonalElements(int precision)
    {
        return MatrixService.getNumberOfNonZeroDiagonalElements(this, precision);
    }


    public boolean contains(ANumber x)
    {
        return MatrixService.contains(this, x);
    }


    public boolean containsExceptInPosition(ANumber x, int rowIndex, int columnIndex)
    {
        return MatrixService.containsExceptInPosition(this, x, rowIndex, columnIndex);
    }


    public Pair<Integer, Integer>[] getPositionsOfElement(ANumber x)
    {
        return MatrixService.getPositionsOfElement(this, x);
    }


    public Matrix negate()
    {
        return MatrixService.negate(this);
    }


    public Matrix transpose()
    {
        return MatrixService.transpose(this);
    }


    public Matrix add(Matrix other)
    {
        return MatrixService.add(this, other);
    }


    public Matrix subtract(Matrix other)
    {
        return MatrixService.subtract(this, other);
    }


    public Matrix multiply(ANumber scalar)
    {
        return MatrixService.multiply(this, scalar);
    }


    public Matrix multiply(Number scalar)
    {
        return multiply(ANumber.of(scalar));
    }


    public Matrix multiply(Matrix other)
    {
        return MatrixService.multiply(this, other);
    }


    public void multiplyInPlace(Matrix other)
    {
        MatrixService.multiplyInPlace(this, other);
    }


    public Matrix multiply(Vector other)
    {
        return MatrixService.multiply(this, other);
    }


    public Matrix preMultiply(Matrix other)
    {
        return MatrixService.multiply(other, this);
    }


    public Matrix divide(ANumber scalar)
    {
        return MatrixService.divide(this, scalar);
    }


    public Matrix divide(Number scalar)
    {
        return divide(ANumber.of(scalar));
    }


    public Matrix getUpperTriangularPart()
    {
        return MatrixService.getUpperTriangularPart(this);
    }


    public Matrix getLowerTriangularPart()
    {
        return MatrixService.getLowerTriangularPart(this);
    }


    public Matrix swapRows(int row1, int row2)
    {
        return MatrixService.swapRows(this, row1, row2);
    }


    public Matrix swapColumns(int column1, int column2)
    {
        return MatrixService.swapColumns(this, column1, column2);
    }


    public void addToRow(int rowIndex, ANumber x)
    {
        MatrixService.addToRow(this, rowIndex, x);
    }


    public Matrix addToRowGET(int rowIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.addToRow(rowIndex, x);
        return newMatrix;
    }


    public void multiplyRow(int rowIndex, ANumber x)
    {
        MatrixService.multiplyRow(this, rowIndex, x);
    }


    public Matrix multiplyRowGET(int rowIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.multiplyRow(rowIndex, x);
        return newMatrix;
    }


    public void multiplyColumn(int columnIndex, ANumber x)
    {
        MatrixService.multiplyColumn(this, columnIndex, x);
    }


    public Matrix multiplyColumnGET(int columnIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.multiplyColumn(columnIndex, x);
        return newMatrix;
    }


    public void addToColumn(int columnIndex, ANumber x)
    {
        MatrixService.addToColumn(this, columnIndex, x);
    }


    public Matrix addToColumnGET(int columnIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.addToColumn(columnIndex, x);
        return newMatrix;
    }


    public void subtractFromRow(int rowIndex, ANumber x)
    {
        MatrixService.subtractFromRow(this, rowIndex, x);
    }


    public Matrix subtractFromRowGET(int rowIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.subtractFromRow(rowIndex, x);
        return newMatrix;
    }


    public void subtractFromColumn(int columnIndex, ANumber x)
    {
        MatrixService.subtractFromColumn(this, columnIndex, x);
    }


    public Matrix subtractFromColumnGET(int columnIndex, ANumber x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.subtractFromColumn(columnIndex, x);
        return newMatrix;
    }


    public void addToRow(int rowIndex, Vector x)
    {
        MatrixService.addToRow(this, rowIndex, x);
    }


    public Matrix addToRowGET(int rowIndex, Vector x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.addToRow(rowIndex, x);
        return newMatrix;
    }


    public void addToColumn(int columnIndex, Vector x)
    {
        MatrixService.addToColumn(this, columnIndex, x);
    }


    public Matrix addToColumnGET(int columnIndex, Vector x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.addToColumn(columnIndex, x);
        return newMatrix;
    }


    public void subtractFromRow(int rowIndex, Vector x)
    {
        MatrixService.subtractFromRow(this, rowIndex, x);
    }


    public Matrix subtractFromRowGET(int rowIndex, Vector x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.subtractFromRow(rowIndex, x);
        return newMatrix;
    }


    public void subtractFromColumn(int columnIndex, Vector x)
    {
        MatrixService.subtractFromColumn(this, columnIndex, x);
    }


    public Matrix subtractFromColumnGET(int columnIndex, Vector x)
    {
        Matrix newMatrix = getCopy();
        newMatrix.subtractFromColumn(columnIndex, x);
        return newMatrix;
    }


    public boolean isZeroMatrix()
    {
        return MatrixService.isZeroMatrix(this);
    }


    public boolean isZeroOneMatrix()
    {
        return MatrixService.isZeroOneMatrix(this);
    }


    public boolean isIdentityMatrix()
    {
        return MatrixService.isIdentityMatrix(this);
    }


    public boolean isLowerTriangular()
    {
        return MatrixService.isLowerTriangular(this);
    }


    public boolean isNotLowerTriangular()
    {
        return MatrixService.isNotLowerTriangular(this);
    }


    public boolean isStrictlyLowerTriangular()
    {
        return MatrixService.isStrictlyLowerTriangular(this);
    }


    public boolean isUpperTriangular()
    {
        return MatrixService.isUpperTriangular(this);
    }


    public boolean isNotUpperTriangular()
    {
        return MatrixService.isNotUpperTriangular(this);
    }


    public boolean isStrictlyUpperTriangular()
    {
        return MatrixService.isStrictlyUpperTriangular(this);
    }


    public boolean isDiagonal()
    {
        return MatrixService.isDiagonal(this);
    }


    public Matrix square()
    {
        return multiply(this);
    }


    public Matrix exponentiate(int exponent)
    {
        return MatrixService.exponentiate(this, exponent);
    }


    public ANumber getExponentForMatrixToBeNilpotent()
    {
        return MatrixService.getExponentForMatrixToBeNilpotent(this);
    }


    public Matrix augmentWith(Vector other)
    {
        return MatrixService.augmentWith(this, other);
    }


    public Matrix augmentWith(Matrix other)
    {
        return MatrixService.augmentWith(this, other);
    }


    public boolean isSingular()
    {
        return MatrixService.isSingular(this);
    }


    public boolean isSingular(int precision)
    {
        return MatrixService.isSingular(this, precision);
    }


    public boolean isNonSingular()
    {
        return MatrixService.isNonSingular(this);
    }


    public boolean isNonSingular(int precision)
    {
        return MatrixService.isNonSingular(this, precision);
    }


    public boolean isInvertible()
    {
        return MatrixService.isInvertible(this);
    }


    public boolean isInvertible(int precision)
    {
        return MatrixService.isInvertible(this, precision);
    }


    public boolean isSymmetric()
    {
        return MatrixService.isSymmetric(this);
    }


    public boolean isSkewSymmetric()
    {
        return MatrixService.isSkewSymmetric(this);
    }


    public boolean isAntiSymmetric()
    {
        return isSkewSymmetric();
    }


    public boolean isOrthogonal()
    {
        return MatrixService.isOrthogonal(this);
    }


    public Matrix getConjugateTranspose()
    {
        return MatrixService.getConjugateTranspose(this);
    }


    public Matrix getAdjoint()
    {
        return MatrixService.getAdjoint(this);
    }


    public boolean isUnitary()
    {
        return MatrixService.isUnitary(this);
    }


    public boolean isNormal()
    {
        return MatrixService.isNormal(this);
    }


    public boolean isHermitian()
    {
        return MatrixService.isHermitian(this);
    }


    public boolean isSelfAdjoint()
    {
        return MatrixService.isSelfAdjoint(this);
    }


    public boolean isBinary()
    {
        return MatrixService.isBinary(this);
    }


    public boolean isCMatrix()
    {
        return MatrixService.isCMatrix(this);
    }


    public ANumber getTrace()
    {
        return MatrixService.getTrace(this);
    }


    public LUDecomposition getLUDecomposition()
    {
        return MatrixService.getLUDecomposition(this);
    }


    public LUDecomposition getLUDecomposition(int precision)
    {
        return MatrixService.getLUDecomposition(this, precision);
    }


    public QRDecomposition getQRDecomposition()
    {
        return MatrixService.getQRDecomposition(this);
    }


    public QRDecomposition getQRDecomposition(int precision)
    {
        return MatrixService.getQRDecomposition(this, precision);
    }


    public SingularValueDecomposition getSingularValueDecomposition()
    {
        return MatrixService.getSingularValueDecomposition(this);
    }


    public SingularValueDecomposition getSingularValueDecomposition(int precision)
    {
        return MatrixService.getSingularValueDecomposition(this, precision);
    }


    public CholeskyDecomposition getCholeskyDecomposition()
    {
        return MatrixService.getCholeskyDecomposition(this);
    }


    public CholeskyDecomposition getCholeskyDecomposition(int precision)
    {
        return MatrixService.getCholeskyDecomposition(this, precision);
    }


    public EigenDecomposition getEigenDecomposition()
    {
        return MatrixService.getEigenDecomposition(this);
    }


    public EigenDecomposition getEigenDecomposition(int precision)
    {
        return MatrixService.getEigenDecomposition(this, precision);
    }


    public ANumber getNorm1()
    {
        return MatrixService.getNorm1(this);
    }


    public ANumber getNorm2()
    {
        return MatrixService.getNorm2(this);
    }


    public ANumber getNorm2(int squareRootPrecision)
    {
        return MatrixService.getNorm2(this, squareRootPrecision);
    }


    public ANumber getNormInfinitum()
    {
        return MatrixService.getNormInfinitum(this);
    }


    public ANumber getCondition()
    {
        return MatrixService.getCondition(this);
    }


    public ANumber getCondition(int precision)
    {
        return MatrixService.getCondition(this, precision);
    }


    public Matrix invert()
    {
        return MatrixService.getInverse(this);
    }


    public Matrix rotate90DegreesClockwise()
    {
        return MatrixService.rotate90DegreesClockwise(this);
    }


    public Matrix getCumulativeSumForColumns()
    {
        return MatrixService.getCumulativeSumForColumns(this);
    }


    public Matrix getCumulativeProductForColumns()
    {
        return MatrixService.getCumulativeProductForColumns(this);
    }


    public Matrix getCumulativeSumForRows()
    {
        return MatrixService.getCumulativeSumForRows(this);
    }


    public Matrix getCumulativeProductForRows()
    {
        return MatrixService.getCumulativeProductForRows(this);
    }


    public Matrix getReverseCumulativeSumForColumns()
    {
        return MatrixService.getReverseCumulativeSumForColumns(this);
    }


    public Matrix getReverseCumulativeProductForColumns()
    {
        return MatrixService.getReverseCumulativeProductForColumns(this);
    }


    public Matrix getReverseCumulativeSumForRows()
    {
        return MatrixService.getReverseCumulativeSumForRows(this);
    }


    public Matrix getReverseCumulativeProductForRows()
    {
        return MatrixService.getReverseCumulativeProductForRows(this);
    }


    public Matrix getDifferencesBetweenSuccessiveRowElements()
    {
        return MatrixService.getDifferencesBetweenSuccessiveRowElements(this);
    }


    public Matrix getDifferencesBetweenSuccessiveColumnElements()
    {
        return MatrixService.getDifferencesBetweenSuccessiveColumnElements(this);
    }


    public Matrix getMinor(int rowToExclude, int columnToExclude)
    {
        return MatrixService.getMinor(this, rowToExclude, columnToExclude);
    }


    public boolean isIntegerMatrix()
    {
        return MatrixService.isIntegerMatrix(this);
    }


    public boolean isSpecialMatrix()
    {
        return MatrixService.isSpecialMatrix(this);
    }


    public boolean isUnitMatrix()
    {
        return MatrixService.isUnitMatrix(this);
    }


    public boolean isCompatibleWith(Vector vector)
    {
        return MatrixService.isCompatibleWith(this, vector);
    }


    public boolean isCompatibleWith(Vector vector, int precision)
    {
        return MatrixService.isCompatibleWith(this, vector, precision);
    }


    public ANumber getBandwidth()
    {
        return MatrixService.getBandwidth(this);
    }


    public boolean isPositive()
    {
        return MatrixService.isPositive(this);
    }


    public boolean isNonPositive()
    {
        return MatrixService.isNonPositive(this);
    }


    public boolean isNegative()
    {
        return MatrixService.isNegative(this);
    }


    public boolean isNonNegative()
    {
        return MatrixService.isNonNegative(this);
    }


    public boolean isCentrosymmetric()
    {
        return MatrixService.isCentrosymmetric(this);
    }


    public boolean isBisymmetric()
    {
        return MatrixService.isBisymmetric(this);
    }


    public boolean isCirculantMatrix()
    {
        return MatrixService.isCirculantMatrix(this);
    }


    public boolean isCommutativeWith(Matrix other)
    {
        return MatrixService.isCommutativeWith(this, other);
    }


    public boolean isComplexMatrix()
    {
        return MatrixService.isComplexMatrix(this);
    }


    public Matrix getConjugate()
    {
        return MatrixService.getConjugate(this);
    }


    public boolean isCoxeterMatrix()
    {
        return MatrixService.isCoxeterMatrix(this);
    }


    public boolean isDiagonallyDominant()
    {
        return MatrixService.isDiagonallyDominant(this);
    }


    public boolean isDoublyStochastic()
    {
        return MatrixService.isDoublyStochastic(this);
    }


    public boolean isFibonacciQMatrix()
    {
        return MatrixService.isFibonacciQMatrix(this);
    }


    public boolean isHankelMatrix()
    {
        return MatrixService.isHankelMatrix(this);
    }


    public boolean isUpperHessenbergMatrix()
    {
        return MatrixService.isUpperHessenbergMatrix(this);
    }


    public boolean isLowerHessenbergMatrix()
    {
        return MatrixService.isLowerHessenbergMatrix(this);
    }


    public boolean isHessenbergMatrix()
    {
        return MatrixService.isHessenbergMatrix(this);
    }


    public boolean isHilbertMatrix()
    {
        return MatrixService.isHilbertMatrix(this);
    }


    public boolean isInvolutoryMatrix()
    {
        return MatrixService.isInvolutoryMatrix(this);
    }


    public boolean isJordanBlock()
    {
        return MatrixService.isJordanBlock(this);
    }


    public boolean isKMatrix()
    {
        return MatrixService.isKMatrix(this);
    }


    public boolean isKacMatrix()
    {
        return MatrixService.isKacMatrix(this);
    }


    public boolean isClementMatrix()
    {
        return MatrixService.isClementMatrix(this);
    }


    public boolean isMonotonicMatrix()
    {
        return MatrixService.isMonotonicMatrix(this);
    }


    public boolean isPeriodicMatrix()
    {
        return MatrixService.isPeriodicMatrix(this);
    }


    public ANumber getMatrixPeriod()
    {
        return MatrixService.getMatrixPeriod(this);
    }


    public boolean isSquareMatrix()
    {
        return MatrixService.isSquareMatrix(this);
    }


    public boolean isRectangularMatrix()
    {
        return MatrixService.isRectangularMatrix(this);
    }


    public boolean isRedhefferMatrix()
    {
        return MatrixService.isRedhefferMatrix(this);
    }


    public boolean isScalarMatrix()
    {
        return MatrixService.isScalarMatrix(this);
    }


    public boolean isSpecialOrthogonalMatrix()
    {
        return MatrixService.isSpecialOrthogonalMatrix(this);
    }


    public boolean isSpecialUnitaryMatrix()
    {
        return MatrixService.isSpecialUnitaryMatrix(this);
    }


    public boolean isStochasticMatrix()
    {
        return MatrixService.isStochasticMatrix(this);
    }


    public boolean isRightStochasticMatrix()
    {
        return MatrixService.isRightStochasticMatrix(this);
    }


    public boolean isLeftStochasticMatrix()
    {
        return MatrixService.isLeftStochasticMatrix(this);
    }


    public boolean isTriangularMatrix()
    {
        return MatrixService.isTriangularMatrix(this);
    }


    public boolean isTridiagonalMatrix()
    {
        return MatrixService.isTridiagonalMatrix(this);
    }


    public boolean isUnimodularMatrix()
    {
        return MatrixService.isUnimodularMatrix(this);
    }


    public boolean isVandermondeMatrix()
    {
        return MatrixService.isVandermondeMatrix(this);
    }


    public Matrix normalise()
    {
        return MatrixService.normalise(this);
    }


    public Matrix normaliseFrom0To1()
    {
        return MatrixService.normaliseFrom0To1(this);
    }


    public ANumber getArithmeticAverageOfColumn(int columnIndex)
    {
        return getColumn(columnIndex).getArithmeticAverage();
    }


    public ANumber getArithmeticAverageOfRow(int rowIndex)
    {
        return getRow(rowIndex).getArithmeticAverage();
    }


    public BidiagonalMatrixForm transformToBidiagonalMatrix()
    {
        return MatrixService.transformToBidiagonalMatrix(this);
    }


    public TridiagonalMatrixForm transformToTridiagonalMatrix()
    {
        return MatrixService.transformToTridiagonalMatrix(this);
    }


    public SchurFormMatrix transformToSchurFormMatrix()
    {
        return MatrixService.transformToSchurFormMatrix(this);
    }


    public HessenbergFormMatrix transformToHessenbergFormMatrix()
    {
        return MatrixService.transformToHessenbergFormMatrix(this);
    }


    public Vector getRealEigenvalues()
    {
        return getEigenDecomposition().getEigensystem().getRealEigenvalues();
    }


    public Vector getImaginaryEigenvalues()
    {
        return getEigenDecomposition().getEigensystem().getImaginaryEigenvalues();
    }


    public Matrix getEigenvectors()
    {
        return getEigenDecomposition().getEigensystem().getEigenvectors();
    }


    public ANumber getMinimum()
    {
        return getAsVector().getMinimum();
    }


    public ANumber getMaximum()
    {
        return getAsVector().getMaximum();
    }


    public List<ANumber> getAsList()
    {
        return getElements().stream().flatMap(vector -> vector.getStream()).collect(Collectors.toList());
    }


    public OrionList<ANumber> getAsOrionList()
    {
        return OrionArrayList.<ANumber>of(getAsList());
    }


    public Vector getAsVector()
    {
        return Vector.of(getAsList());
    }


    public Stream<ANumber> filterRow(int rowIndex, Predicate<ANumber> filterToApply)
    {
        return getRow(rowIndex).filter(filterToApply);
    }


    public Stream<ANumber> filterColumn(int columnIndex, Predicate<ANumber> filterToApply)
    {
        return getColumn(columnIndex).filter(filterToApply);
    }


    public Stream<ANumber> filterAll(Predicate<ANumber> filterToApply)
    {
        return getAsVector().filter(filterToApply);
    }


    public Stream<ANumber> filterAll(BiPredicate<Integer, Integer> filterToApply)
    {
        List<ANumber> filteredElements = new ArrayList<>();

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(filterToApply.test(i, j))
                {
                    filteredElements.add(get(i, j));
                }

            }

        }

        return Stream.<ANumber>of(filteredElements.toArray(new ANumber[0]));
    }


    public boolean findAny(Predicate<ANumber> filterToApply)
    {
        return getAsVector().findAny(filterToApply);
    }


    public boolean findAny(BiPredicate<Integer, Integer> filterToApply)
    {
        AtomicBoolean foundAny = new AtomicBoolean();
        IntStream.range(0, getNumberOfRows()).forEach(i ->
        {

            if(IntStream.range(0, getNumberOfColumns()).anyMatch(j -> filterToApply.test(i, j)))
            {
                foundAny.set(true);
                return;
            }

        });
        return foundAny.get();
    }


    public boolean findIfAll(BiPredicate<Integer, Integer> filterToApply)
    {
        AtomicBoolean findIfAll = new AtomicBoolean();
        IntStream.range(0, getNumberOfRows()).forEach(i ->
        {

            if(IntStream.range(0, getNumberOfColumns()).allMatch(j -> filterToApply.test(i, j)))
            {
                findIfAll.set(true);
                return;
            }

        });
        return findIfAll.get();
    }


    public boolean findAnyInRows(IntPredicate filterToApply)
    {
        return IntStream.range(0, getNumberOfRows()).anyMatch(i -> filterToApply.test(i));
    }


    public boolean findAnyInColumns(IntPredicate filterToApply)
    {
        return IntStream.range(0, getNumberOfColumns()).anyMatch(j -> filterToApply.test(j));
    }


    public boolean findAnyInDiagonal(BiPredicate<Integer, Integer> condition)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(i == j && condition.test(i, j))
                {
                    return true;
                }

            }

        }

        return false;
    }


    public boolean findNoneInDiagonal(BiPredicate<Integer, Integer> condition)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(i == j && condition.test(i, j))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public boolean findNone(BiPredicate<Integer, Integer> filterToApply)
    {
        AtomicBoolean foundNone = new AtomicBoolean(true);
        IntStream.range(0, getNumberOfRows()).forEach(i ->
        {

            if(IntStream.range(0, getNumberOfColumns()).anyMatch(j -> filterToApply.test(i, j)))
            {
                foundNone.set(false);
                return;
            }

        });
        return foundNone.get();
    }


    public boolean findNoneInRows(IntPredicate filterToApply)
    {
        return IntStream.range(0, getNumberOfRows()).noneMatch(i -> filterToApply.test(i));
    }


    public boolean findNoneInColumns(IntPredicate filterToApply)
    {
        return IntStream.range(0, getNumberOfColumns()).noneMatch(j -> filterToApply.test(j));
    }


    public void forAllInRow(int rowIndex, Consumer<ANumber> action)
    {
        getRow(rowIndex).forAll(action);
    }


    public void forAllInRow(int rowIndex, IntConsumer action)
    {
        getRow(rowIndex).forAllIndices(action);
    }


    public void forAllInColumn(int columnIndex, Consumer<ANumber> action)
    {
        getColumn(columnIndex).forAll(action);
    }


    public void forAllInColumn(int columnIndex, IntConsumer action)
    {
        getColumn(columnIndex).forAllIndices(action);
    }


    public void forAll(BiConsumer<Integer, Integer> action)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void forAll(Stream<ANumber> stream, Consumer<ANumber> action)
    {
        stream.forEach(action);
    }


    public void forAllRowIndices(IntConsumer action)
    {
        IntStream.range(0, getNumberOfRows()).forEach(action);
    }


    public void forAllRowIndices(Predicate<Integer> condition, Predicate<Integer> elseIfCondition, IntConsumer ifAction, IntConsumer elseIfAction, IntConsumer elseAction)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            if(condition.test(i))
            {
                ifAction.accept(i);
            }
            else if(elseIfCondition.test(i))
            {
                elseIfAction.accept(i);
            }
            else
            {
                elseAction.accept(i);
            }

        }

    }


    public void forAllRowIndicesReverse(IntConsumer action)
    {

        for(int i = getNumberOfRows() - 1; i >= 0; i--)
        {
            action.accept(i);
        }

    }


    public void forAllColumnIndices(IntConsumer action)
    {
        IntStream.range(0, getNumberOfColumns()).forEach(action);
    }


    public void forAllColumnIndices(Predicate<Integer> condition, Predicate<Integer> elseIfCondition, IntConsumer ifAction, IntConsumer elseIfAction, IntConsumer elseAction)
    {

        for(int j = 0; j < getNumberOfColumns(); j++)
        {

            if(condition.test(j))
            {
                ifAction.accept(j);
            }
            else if(elseIfCondition.test(j))
            {
                elseIfAction.accept(j);
            }
            else
            {
                elseAction.accept(j);
            }

        }

    }


    public void forAllColumnIndicesReverse(IntConsumer action)
    {

        for(int j = getNumberOfColumns() - 1; j >= 0; j--)
        {
            action.accept(j);
        }

    }


    public void forAllRowAndColumnIndices(BiConsumer<Integer, Integer> action)
    {
        forAll(action);
    }


    public void forAllColumnAndRowIndices(BiConsumer<Integer, Integer> action)
    {

        for(int i = 0; i < getNumberOfColumns(); i++)
        {

            for(int j = 0; j < getNumberOfRows(); j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void forAllRowAndColumnIndices(BiPredicate<Integer, Integer> condition, BiConsumer<Integer, Integer> action)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(condition.test(i, j))
                {
                    action.accept(i, j);
                }

            }

        }

    }


    public void forAllRowAndColumnIndices(BiPredicate<Integer, Integer> condition, BiConsumer<Integer, Integer> ifAction, BiConsumer<Integer, Integer> elseAction)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(condition.test(i, j))
                {
                    ifAction.accept(i, j);
                }
                else
                {
                    elseAction.accept(i, j);
                }

            }

        }

    }


    public void forAllRowAndColumnIndices(BiPredicate<Integer, Integer> condition, BiPredicate<Integer, Integer> elseIfCondition, BiConsumer<Integer, Integer> ifAction, BiConsumer<Integer, Integer> elseIfAction, BiConsumer<Integer, Integer> elseAction)
    {

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {

                if(condition.test(i, j))
                {
                    ifAction.accept(i, j);
                }
                else if(elseIfCondition.test(i, j))
                {
                    elseIfAction.accept(i, j);
                }
                else
                {
                    elseAction.accept(i, j);
                }

            }

        }

    }


    public void forAllColumnAndRowIndices(BiPredicate<Integer, Integer> condition, BiConsumer<Integer, Integer> action)
    {

        for(int j = 0; j < getNumberOfColumns(); j++)
        {

            for(int i = 0; i < getNumberOfRows(); i++)
            {

                if(condition.test(i, j))
                {
                    action.accept(i, j);
                }

            }

        }

    }


    public void forAllColumnAndRowIndices(BiPredicate<Integer, Integer> condition, BiConsumer<Integer, Integer> ifAction, BiConsumer<Integer, Integer> elseAction)
    {

        for(int j = 0; j < getNumberOfColumns(); j++)
        {

            for(int i = 0; i < getNumberOfRows(); i++)
            {

                if(condition.test(i, j))
                {
                    ifAction.accept(i, j);
                }
                else
                {
                    elseAction.accept(i, j);
                }

            }

        }

    }


    public void forAllColumnAndRowIndices(BiPredicate<Integer, Integer> condition, BiPredicate<Integer, Integer> elseIfCondition, BiConsumer<Integer, Integer> ifAction, BiConsumer<Integer, Integer> elseIfAction, BiConsumer<Integer, Integer> elseAction)
    {

        for(int j = 0; j < getNumberOfColumns(); j++)
        {

            for(int i = 0; i < getNumberOfRows(); i++)
            {

                if(condition.test(i, j))
                {
                    ifAction.accept(i, j);
                }
                else if(elseIfCondition.test(i, j))
                {
                    elseIfAction.accept(i, j);
                }
                else
                {
                    elseAction.accept(i, j);
                }

            }

        }

    }


    public void forIndices(int fromRow, int toRow, int fromColumn, int toColumn, BiConsumer<Integer, Integer> action)
    {
        MatrixRules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

        for(int i = fromRow; i <= toRow; i++)
        {

            for(int j = fromColumn; j <= toColumn; j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void forRowIndices(int fromRow, int toRow, IntConsumer action)
    {
        MatrixRules.isValidRowsInterval(this, fromRow, toRow);

        for(int i = fromRow; i <= toRow; i++)
        {
            action.accept(i);
        }

    }


    public void forColumnIndices(int fromColumn, int toColumn, IntConsumer action)
    {
        MatrixRules.isValidColumnsInterval(this, fromColumn, toColumn);

        for(int j = fromColumn; j <= toColumn; j++)
        {
            action.accept(j);
        }

    }


    public void forRowAndColumnIndices(int fromRow, int toRow, int fromColumn, int toColumn, BiConsumer<Integer, Integer> action)
    {
        MatrixRules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

        for(int i = fromRow; i <= toRow; i++)
        {

            for(int j = fromColumn; j <= toColumn; j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void filterAndLoop(Predicate<ANumber> filterToApply, Consumer<ANumber> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterAndLoop(BiPredicate<Integer, Integer> filterToApply, Consumer<ANumber> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterRowAndLoop(int rowIndex, Predicate<ANumber> filterToApply, Consumer<ANumber> action)
    {
        forAll(filterRow(rowIndex, filterToApply), action);
    }


    public void filterColumnAndLoop(int columnIndex, Predicate<ANumber> filterToApply, Consumer<ANumber> action)
    {
        forAll(filterColumn(columnIndex, filterToApply), action);
    }


    public void setElementsAsArrayOfrrays(ANumber[][] elements)
    {
        this.elements = MatrixService.convertNumbersToListOfVectors(elements);
    }


    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < getNumberOfRows(); i++)
        {

            for(int j = 0; j < getNumberOfColumns(); j++)
            {
                sb.append(get(i, j));

                if(j < getNumberOfColumns() - 1)
                {
                    sb.append(", ");
                }

            }

            sb.append("\n");
        }

        return sb.toString();
    }


    @Override
    public Matrix clone() throws CloneNotSupportedException
    {
        return (Matrix)CloningService.clone(this);
    }


    public Matrix getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return MatrixInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return MatrixInternalService.equals(this, object);
    }


    public OrionList<Vector> getElements()
    {
        return this.elements;
    }
}