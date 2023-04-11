package com.orion.math.linearalgebra.matrix.functional;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.Matrix;
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

public class MatrixOfFunction1x1 implements MathObject, Cloneable
{
    private OrionList<VectorOfFunction1x1> elements;


    public MatrixOfFunction1x1()
    {
        this(OrionArrayList.<VectorOfFunction1x1>of());
    }


    public MatrixOfFunction1x1(OrionList<VectorOfFunction1x1> elements)
    {
        MatrixOfFunction1x1Rules.isValid(elements);
        this.elements = elements;
    }


    public MatrixOfFunction1x1(Function1x1<ANumber, ANumber>[][] elements)
    {
        MatrixOfFunction1x1Rules.isValid(elements);
        this.elements = MatrixOfFunction1x1Service.convertFunctionsToListOfVectors(elements);
    }


    @SuppressWarnings("unchecked")
    public MatrixOfFunction1x1(int numberOfRows, int numberOfColumns)
    {
        MatrixOfFunction1x1Rules.isValid(numberOfRows, numberOfColumns);
        Function1x1<ANumber, ANumber>[][] newElements = new Function1x1[numberOfRows][numberOfColumns];
        NumberArrayStream.setValue(newElements, Function1x1.Zero);
        this.elements = MatrixOfFunction1x1Service.convertFunctionsToListOfVectors(newElements);
    }


    public MatrixOfFunction1x1(VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1Rules.isValid(elements);
        OrionList<VectorOfFunction1x1> newElements = OrionArrayList.of(elements);
        this.elements = newElements;
    }


    public static MatrixOfFunction1x1 of()
    {
        return new MatrixOfFunction1x1();
    }


    public static MatrixOfFunction1x1 of(OrionList<VectorOfFunction1x1> elements)
    {
        return new MatrixOfFunction1x1(elements);
    }


    public static MatrixOfFunction1x1 of(VectorOfFunction1x1 elements)
    {
        return new MatrixOfFunction1x1(elements);
    }


    public static MatrixOfFunction1x1 of(Function1x1<ANumber, ANumber>[][] elements)
    {
        return new MatrixOfFunction1x1(elements);
    }


    public static MatrixOfFunction1x1 of(int numberOfRows, int numberOfColumns)
    {
        return new MatrixOfFunction1x1(numberOfRows, numberOfColumns);
    }


    public static MatrixOfFunction1x1 ofRandom(int numberOfRows, int numberOfColumns)
    {
        return ofRandom(numberOfRows, numberOfColumns, 0, 1);
    }


    public static MatrixOfFunction1x1 ofRandom(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        return MatrixOfFunction1x1InternalService.ofRandom(numberOfRows, numberOfColumns, minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
    }


    public static MatrixOfFunction1x1 ofDiagonal(VectorOfFunction1x1 diagonalElements)
    {
        return MatrixOfFunction1x1InternalService.ofDiagonal(diagonalElements);
    }


    public static MatrixOfFunction1x1 ofIdentity(int numberOfRowsAndColumns)
    {
        return MatrixOfFunction1x1InternalService.ofIdentity(numberOfRowsAndColumns);
    }


    public static MatrixOfFunction1x1 ofZero(int numberOfRows, int numberOfColumns)
    {
        return MatrixOfFunction1x1InternalService.ofZero(numberOfRows, numberOfColumns);
    }


    public static MatrixOfFunction1x1 ofSkewDiagonal(VectorOfFunction1x1 skewDiagonalElements)
    {
        return MatrixOfFunction1x1InternalService.ofSkewDiagonal(skewDiagonalElements);
    }


    public VectorOfFunction1x1 getRow(int rowIndex)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        return getElements().get(rowIndex);
    }


    public VectorOfFunction1x1 getColumn(int columnIndex)
    {
        return MatrixOfFunction1x1Service.getColumn(this, columnIndex);
    }


    public Function1x1<ANumber, ANumber> get(int rowIndex, int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        MatrixOfFunction1x1Rules.isValidColumnIndex(this, columnIndex);
        return getElements().get(rowIndex).get(columnIndex);
    }


    public MatrixOfFunction1x1 rotate90DegreesClockwise()
    {
        return MatrixOfFunction1x1Service.rotate90DegreesClockwise(this);
    }


    public MatrixOfFunction1x1 getMinor(int rowToExclude, int columnToExclude)
    {
        return MatrixOfFunction1x1Service.getMinor(this, rowToExclude, columnToExclude);
    }


    public Function1x1<ANumber, ANumber> getDeterminant()
    {
        return MatrixOfFunction1x1Service.getDeterminant(this);
    }


    public void delete(int rowIndex, int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        MatrixOfFunction1x1Rules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).delete(columnIndex);
    }


    public MatrixOfFunction1x1 deleteGET(int rowIndex, int columnIndex)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.delete(rowIndex, columnIndex);
        return newMatrix;
    }


    public void deleteRow(int rowIndex)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        getElements().delete(rowIndex);
    }


    public MatrixOfFunction1x1 deleteRowGET(int rowIndex)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.deleteRow(rowIndex);
        return newMatrix;
    }


    public void deleteColumn(int columnIndex)
    {
        MatrixOfFunction1x1Rules.isValidColumnIndex(this, columnIndex);
        IntStream.range(0, getNumberOfRows()).forEach(i -> delete(i, columnIndex));
    }


    public MatrixOfFunction1x1 deleteColumnGET(int columnIndex)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.deleteColumn(columnIndex);
        return newMatrix;
    }


    public void deleteRowAndColumn(int rowIndex, int columnIndex)
    {
        deleteRow(rowIndex);
        deleteColumn(columnIndex);
    }


    public MatrixOfFunction1x1 deleteRowAndColumnGET(int rowIndex, int columnIndex)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.deleteRowAndColumn(rowIndex, columnIndex);
        return newMatrix;
    }


    public MatrixOfFunction1x1 getSubmatrix(int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return MatrixOfFunction1x1Service.getSubmatrix(this, fromRow, toRow, fromColumn, toColumn);
    }


    public void set(int rowIndex, int columnIndex, Function1x1<ANumber, ANumber> element)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        MatrixOfFunction1x1Rules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).set(columnIndex, element);
    }


    public MatrixOfFunction1x1 setGET(int rowIndex, int columnIndex, Function1x1<ANumber, ANumber> element)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.set(rowIndex, columnIndex, element);
        return newMatrix;
    }


    public void setRow(int rowIndex, VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1Rules.isValidRowIndex(this, rowIndex);
        getElements().set(rowIndex, elements);
    }


    public MatrixOfFunction1x1 setRowGET(int rowIndex, VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.setRow(rowIndex, elements);
        return newMatrix;
    }


    public void setColumn(int columnIndex, VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1Service.setColumn(this, columnIndex, elements);
    }


    public MatrixOfFunction1x1 setColumnGET(int columnIndex, VectorOfFunction1x1 elements)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.setColumn(columnIndex, elements);
        return newMatrix;
    }


    public VectorOfFunction1x1 getSubrow(int rowIndex, int fromColumn, int toColumn)
    {
        return MatrixOfFunction1x1Service.getSubrow(this, rowIndex, fromColumn, toColumn);
    }


    public VectorOfFunction1x1 getRowExceptDiagonalElement(int rowIndex)
    {
        return MatrixOfFunction1x1Service.getRowExceptDiagonalElement(this, rowIndex);
    }


    public Function1x1<ANumber, ANumber>[] getColumnAsArray(int columnIndex)
    {
        return MatrixOfFunction1x1Service.getColumn(this, columnIndex).getAsArray();
    }


    public VectorOfFunction1x1 getColumnExceptDiagonalElement(int columnIndex)
    {
        return MatrixOfFunction1x1Service.getColumnExceptDiagonalElement(this, columnIndex);
    }


    public VectorOfFunction1x1 getSubcolumn(int fromRow, int toRow, int columnIndex)
    {
        return MatrixOfFunction1x1Service.getSubcolumn(this, fromRow, toRow, columnIndex);
    }


    public VectorOfFunction1x1 getDiagonal()
    {
        return MatrixOfFunction1x1Service.getDiagonal(this);
    }


    public ANumber getNumberOfNonZeroDiagonalElements()
    {
        return MatrixOfFunction1x1Service.getNumberOfNonZeroDiagonalElements(this);
    }


    public MatrixOfFunction1x1 negate()
    {
        return MatrixOfFunction1x1Service.negate(this);
    }


    public MatrixOfFunction1x1 transpose()
    {
        return MatrixOfFunction1x1Service.transpose(this);
    }


    public MatrixOfFunction1x1 add(MatrixOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.add(this, other);
    }


    public MatrixOfFunction1x1 subtract(MatrixOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.subtract(this, other);
    }


    public MatrixOfFunction1x1 multiply(ANumber scalar)
    {
        return MatrixOfFunction1x1Service.multiply(this, scalar);
    }


    public MatrixOfFunction1x1 multiply(Number scalar)
    {
        return MatrixOfFunction1x1Service.multiply(this, scalar);
    }


    public MatrixOfFunction1x1 multiply(MatrixOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.multiply(this, other);
    }


    public MatrixOfFunction1x1 multiply(VectorOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.multiply(this, other);
    }


    public MatrixOfFunction1x1 multiply(Function1x1<ANumber, ANumber> other)
    {
        return MatrixOfFunction1x1Service.multiply(this, other);
    }


    public void multiplyInPlace(MatrixOfFunction1x1 other)
    {
        MatrixOfFunction1x1Service.multiplyInPlace(this, other);
    }


    public MatrixOfFunction1x1 preMultiply(MatrixOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.multiply(other, this);
    }


    public MatrixOfFunction1x1 divide(ANumber scalar)
    {
        return MatrixOfFunction1x1Service.divide(this, scalar);
    }


    public MatrixOfFunction1x1 divide(Number scalar)
    {
        return divide(ANumber.of(scalar));
    }


    public MatrixOfFunction1x1 divide(Function1x1<ANumber, ANumber> other)
    {
        return MatrixOfFunction1x1Service.divide(this, other);
    }


    public MatrixOfFunction1x1 getUpperTriangularPart()
    {
        return MatrixOfFunction1x1Service.getUpperTriangularPart(this);
    }


    public MatrixOfFunction1x1 getLowerTriangularPart()
    {
        return MatrixOfFunction1x1Service.getLowerTriangularPart(this);
    }


    public MatrixOfFunction1x1 swapRows(int row1, int row2)
    {
        return MatrixOfFunction1x1Service.swapRows(this, row1, row2);
    }


    public MatrixOfFunction1x1 swapColumns(int column1, int column2)
    {
        return MatrixOfFunction1x1Service.swapColumns(this, column1, column2);
    }


    public void addToRow(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.addToRow(this, rowIndex, x);
    }


    public MatrixOfFunction1x1 addToRowGET(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.addToRow(rowIndex, x);
        return newMatrix;
    }


    public void addToRow(int rowIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1Service.addToRow(this, rowIndex, x);
    }


    public MatrixOfFunction1x1 addToRowGET(int rowIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.addToRow(rowIndex, x);
        return newMatrix;
    }


    public void multiplyRow(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.multiplyRow(this, rowIndex, x);
    }


    public MatrixOfFunction1x1 multiplyRowGET(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.multiplyRow(rowIndex, x);
        return newMatrix;
    }


    public void multiplyColumn(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.multiplyColumn(this, columnIndex, x);
    }


    public MatrixOfFunction1x1 multiplyColumnGET(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.multiplyColumn(columnIndex, x);
        return newMatrix;
    }


    public void addToColumn(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.addToColumn(this, columnIndex, x);
    }


    public MatrixOfFunction1x1 addToColumnGET(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.addToColumn(columnIndex, x);
        return newMatrix;
    }


    public void addToColumn(int columnIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1Service.addToColumn(this, columnIndex, x);
    }


    public MatrixOfFunction1x1 addToColumnGET(int columnIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.addToColumn(columnIndex, x);
        return newMatrix;
    }


    public void subtractFromRow(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.subtractFromRow(this, rowIndex, x);
    }


    public MatrixOfFunction1x1 subtractFromRowGET(int rowIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.subtractFromRow(rowIndex, x);
        return newMatrix;
    }


    public void subtractFromRow(int rowIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1Service.subtractFromRow(this, rowIndex, x);
    }


    public MatrixOfFunction1x1 subtractFromRowGET(int rowIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.subtractFromRow(rowIndex, x);
        return newMatrix;
    }


    public void subtractFromColumn(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1Service.subtractFromColumn(this, columnIndex, x);
    }


    public MatrixOfFunction1x1 subtractFromColumnGET(int columnIndex, ANumber x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.subtractFromColumn(columnIndex, x);
        return newMatrix;
    }


    public void subtractFromColumn(int columnIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1Service.subtractFromColumn(this, columnIndex, x);
    }


    public MatrixOfFunction1x1 subtractFromColumnGET(int columnIndex, VectorOfFunction1x1 x)
    {
        MatrixOfFunction1x1 newMatrix = getCopy();
        newMatrix.subtractFromColumn(columnIndex, x);
        return newMatrix;
    }


    public boolean isZeroMatrix()
    {
        return MatrixOfFunction1x1Service.isZeroMatrix(this);
    }


    public boolean isLowerTriangular()
    {
        return MatrixOfFunction1x1Service.isLowerTriangular(this);
    }


    public boolean isNotLowerTriangular()
    {
        return MatrixOfFunction1x1Service.isNotLowerTriangular(this);
    }


    public boolean isStrictlyLowerTriangular()
    {
        return MatrixOfFunction1x1Service.isStrictlyLowerTriangular(this);
    }


    public boolean isUpperTriangular()
    {
        return MatrixOfFunction1x1Service.isUpperTriangular(this);
    }


    public boolean isNotUpperTriangular()
    {
        return MatrixOfFunction1x1Service.isNotUpperTriangular(this);
    }


    public boolean isStrictlyUpperTriangular()
    {
        return MatrixOfFunction1x1Service.isStrictlyUpperTriangular(this);
    }


    public boolean isDiagonal()
    {
        return MatrixOfFunction1x1Service.isDiagonal(this);
    }


    public MatrixOfFunction1x1 square()
    {
        return multiply(this);
    }


    public MatrixOfFunction1x1 exponentiate(int exponent)
    {
        return MatrixOfFunction1x1Service.exponentiate(this, exponent);
    }


    public MatrixOfFunction1x1 augmentWith(VectorOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.augmentWith(this, other);
    }


    public MatrixOfFunction1x1 augmentWith(MatrixOfFunction1x1 other)
    {
        return MatrixOfFunction1x1Service.augmentWith(this, other);
    }


    public boolean isSingular()
    {
        return MatrixOfFunction1x1Service.isSingular(this);
    }


    public boolean isNotSingular()
    {
        return MatrixOfFunction1x1Service.isNotSingular(this);
    }


    public boolean isInvertible()
    {
        return MatrixOfFunction1x1Service.isInvertible(this);
    }


    public MatrixOfFunction1x1 getConjugate()
    {
        return MatrixOfFunction1x1Service.getConjugate(this);
    }


    public MatrixOfFunction1x1 getConjugateTranspose()
    {
        return MatrixOfFunction1x1Service.getConjugateTranspose(this);
    }


    public MatrixOfFunction1x1 getAdjoint()
    {
        return MatrixOfFunction1x1Service.getAdjoint(this);
    }


    public void applyValueForFunctionElements(ANumber x)
    {
        getElements().forAll(element -> element.applyValueToFunctionElements(x));
    }


    public MatrixOfFunction1x1 applyValueForFunctionElementsGET(ANumber x)
    {
        MatrixOfFunction1x1 copy = getCopy();
        copy.applyValueForFunctionElements(x);
        return copy;
    }


    public Matrix applyValueForFunctionElementsAndGetAsMatrix(ANumber x)
    {
        List<Vector> vectors = getElements().mapToList(element -> element.applyValueToFunctionElementsAndGetAsVector(x));
        return Matrix.of(vectors);
    }


    public Function1x1<ANumber, ANumber> getTrace()
    {
        return MatrixOfFunction1x1Service.getTrace(this);
    }


    public Function1x1<ANumber, ANumber> getNorm2()
    {
        return MatrixOfFunction1x1Service.getNorm2(this);
    }


    public MatrixOfFunction1x1 getCumulativeSumForColumns()
    {
        return MatrixOfFunction1x1Service.getCumulativeSumForColumns(this);
    }


    public MatrixOfFunction1x1 getCumulativeProductForColumns()
    {
        return MatrixOfFunction1x1Service.getCumulativeProductForColumns(this);
    }


    public MatrixOfFunction1x1 getCumulativeSumForRows()
    {
        return MatrixOfFunction1x1Service.getCumulativeSumForRows(this);
    }


    public MatrixOfFunction1x1 getCumulativeProductForRows()
    {
        return MatrixOfFunction1x1Service.getCumulativeProductForRows(this);
    }


    public MatrixOfFunction1x1 getReverseCumulativeSumForColumns()
    {
        return MatrixOfFunction1x1Service.getReverseCumulativeSumForColumns(this);
    }


    public MatrixOfFunction1x1 getReverseCumulativeProductForColumns()
    {
        return MatrixOfFunction1x1Service.getReverseCumulativeProductForColumns(this);
    }


    public MatrixOfFunction1x1 getReverseCumulativeSumForRows()
    {
        return MatrixOfFunction1x1Service.getReverseCumulativeSumForRows(this);
    }


    public MatrixOfFunction1x1 getReverseCumulativeProductForRows()
    {
        return MatrixOfFunction1x1Service.getReverseCumulativeProductForRows(this);
    }


    public MatrixOfFunction1x1 getDifferencesBetweenSuccessiveRowElements()
    {
        return MatrixOfFunction1x1Service.getDifferencesBetweenSuccessiveRowElements(this);
    }


    public MatrixOfFunction1x1 getDifferencesBetweenSuccessiveColumnElements()
    {
        return MatrixOfFunction1x1Service.getDifferencesBetweenSuccessiveColumnElements(this);
    }


    public boolean isSquareMatrix()
    {
        return MatrixOfFunction1x1Service.isSquareMatrix(this);
    }


    public boolean isRectangularMatrix()
    {
        return MatrixOfFunction1x1Service.isRectangularMatrix(this);
    }


    public boolean isTriangularMatrix()
    {
        return MatrixOfFunction1x1Service.isTriangularMatrix(this);
    }


    public MatrixOfFunction1x1 normalise()
    {
        return MatrixOfFunction1x1Service.normalise(this);
    }


    public Function1x1<ANumber, ANumber> getArithmeticAverageOfColumn(int columnIndex)
    {
        return getColumn(columnIndex).getArithmeticAverage();
    }


    public Function1x1<ANumber, ANumber> getArithmeticAverageOfRow(int rowIndex)
    {
        return getRow(rowIndex).getArithmeticAverage();
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


    public GenericMatrix getAsGenericMatrix()
    {
        return GenericMatrix.of(OrionArrayList.<GenericVector>of(getElements().mapToList(e -> e.getAsGenericVector())));
    }


    public Function1x1<ANumber, ANumber>[][] getAsArrayOfArrays()
    {
        return MatrixOfFunction1x1Service.getAsArrayOfArrays(this);
    }


    public List<Function1x1<ANumber, ANumber>> getAsList()
    {
        return getElements().stream().flatMap(vector -> vector.getStream()).collect(Collectors.toList());
    }


    public OrionList<Function1x1<ANumber, ANumber>> getAsOrionList()
    {
        return OrionArrayList.of(getAsList());
    }


    public VectorOfFunction1x1 getAsVector()
    {
        return VectorOfFunction1x1.of(getAsList());
    }


    public Stream<Function1x1<ANumber, ANumber>> filterRow(int rowIndex, Predicate<Function1x1<ANumber, ANumber>> filterToApply)
    {
        return getRow(rowIndex).filter(filterToApply);
    }


    public Stream<Function1x1<ANumber, ANumber>> filterColumn(int columnIndex, Predicate<Function1x1<ANumber, ANumber>> filterToApply)
    {
        return getColumn(columnIndex).filter(filterToApply);
    }


    public Stream<Function1x1<ANumber, ANumber>> filterAll(Predicate<Function1x1<ANumber, ANumber>> filterToApply)
    {
        return getAsVector().filter(filterToApply);
    }


    @SuppressWarnings("unchecked")
    public Stream<Function1x1<ANumber, ANumber>> filterAll(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Function1x1<ANumber, ANumber>> filteredElements = new ArrayList<>();

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

        return Stream.<Function1x1<ANumber, ANumber>>of(filteredElements.toArray(new Function1x1[0]));
    }


    public boolean findAny(Predicate<Function1x1<ANumber, ANumber>> filterToApply)
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


    public void forAllInRow(int rowIndex, Consumer<Function1x1<ANumber, ANumber>> action)
    {
        getRow(rowIndex).forAll(action);
    }


    public void forAllInRow(int rowIndex, IntConsumer action)
    {
        getRow(rowIndex).forAllIndices(action);
    }


    public void forAllInColumn(int columnIndex, Consumer<Function1x1<ANumber, ANumber>> action)
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


    public void forAll(Stream<Function1x1<ANumber, ANumber>> stream, Consumer<Function1x1<ANumber, ANumber>> action)
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
        MatrixOfFunction1x1Rules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

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
        MatrixOfFunction1x1Rules.isValidRowsInterval(this, fromRow, toRow);

        for(int i = fromRow; i <= toRow; i++)
        {
            action.accept(i);
        }

    }


    public void forColumnIndices(int fromColumn, int toColumn, IntConsumer action)
    {
        MatrixOfFunction1x1Rules.isValidColumnsInterval(this, fromColumn, toColumn);

        for(int j = fromColumn; j <= toColumn; j++)
        {
            action.accept(j);
        }

    }


    public void forRowAndColumnIndices(int fromRow, int toRow, int fromColumn, int toColumn, BiConsumer<Integer, Integer> action)
    {
        MatrixOfFunction1x1Rules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

        for(int i = fromRow; i <= toRow; i++)
        {

            for(int j = fromColumn; j <= toColumn; j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void filterAndLoop(Predicate<Function1x1<ANumber, ANumber>> filterToApply, Consumer<Function1x1<ANumber, ANumber>> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterAndLoop(BiPredicate<Integer, Integer> filterToApply, Consumer<Function1x1<ANumber, ANumber>> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterRowAndLoop(int rowIndex, Predicate<Function1x1<ANumber, ANumber>> filterToApply, Consumer<Function1x1<ANumber, ANumber>> action)
    {
        forAll(filterRow(rowIndex, filterToApply), action);
    }


    public void filterColumnAndLoop(int columnIndex, Predicate<Function1x1<ANumber, ANumber>> filterToApply, Consumer<Function1x1<ANumber, ANumber>> action)
    {
        forAll(filterColumn(columnIndex, filterToApply), action);
    }


    public void setElementsAsArrayOfrrays(Function1x1<ANumber, ANumber>[][] elements)
    {
        this.elements = MatrixOfFunction1x1Service.convertFunctionsToListOfVectors(elements);
    }


    @Override
    public MatrixOfFunction1x1 clone() throws CloneNotSupportedException
    {
        return (MatrixOfFunction1x1)CloningService.clone(this);
    }


    public MatrixOfFunction1x1 getCopy()
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


    public OrionList<VectorOfFunction1x1> getElements()
    {
        return this.elements;
    }
}