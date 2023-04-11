package com.orion.math.linearalgebra.matrix.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorRules;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericMatrix implements MathObject, Cloneable
{
    private OrionList<GenericVector> elements;


    public GenericMatrix()
    {
        this(OrionArrayList.<GenericVector>of());
    }


    public GenericMatrix(Object[][] elements)
    {
        GenericMatrixRules.isValid(elements);
        this.elements = GenericMatrixService.convertElementsToListOfVectors(elements);
    }


    public GenericMatrix(int numberOfRows, int numberOfColumns)
    {
        GenericMatrixRules.isValid(numberOfRows, numberOfColumns);
        Object[][] newElements = new Object[numberOfRows][numberOfColumns];
        this.elements = GenericMatrixService.convertElementsToListOfVectors(newElements);
    }


    public GenericMatrix(OrionList<GenericVector> elements)
    {
        GenericMatrixRules.isValid(elements);
        this.elements = elements;
    }


    public static GenericMatrix of()
    {
        return new GenericMatrix();
    }


    public static GenericMatrix of(OrionList<GenericVector> elements)
    {
        return new GenericMatrix(elements);
    }


    public static GenericMatrix of(Object[][] elements)
    {
        return new GenericMatrix(elements);
    }


    public static GenericMatrix of(int numberOfRows, int numberOfColumns)
    {
        return new GenericMatrix(numberOfRows, numberOfColumns);
    }


    public static GenericMatrix ofDiagonal(GenericVector diagonalElements)
    {
        return GenericMatrixInternalService.ofDiagonal(diagonalElements);
    }


    public static GenericMatrix ofSkewDiagonal(GenericVector skewDiagonalElements)
    {
        GenericVectorRules.isValid(skewDiagonalElements);
        return GenericMatrix.of(GenericMatrix.ofDiagonal(skewDiagonalElements).rotate90DegreesClockwise().getElements());
    }


    public boolean isNullMatrix()
    {
        return GenericMatrixService.isNullMatrix(this);
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


    public GenericVector getDiagonal()
    {
        return GenericMatrixService.getDiagonal(this);
    }


    public Object[][] getAsArrayOfArrays()
    {
        return GenericMatrixService.getAsArrayOfArrays(this);
    }


    public Object[][] getAsArrayOfArraysCopy()
    {
        return getCopy().getAsArrayOfArrays();
    }


    public GenericMatrix getSubmatrix(int fromRow, int toRow, int fromColumn, int toColumn)
    {
        return GenericMatrixService.getSubmatrix(this, fromRow, toRow, fromColumn, toColumn);
    }


    public void set(int rowIndex, int columnIndex, Object element)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        GenericMatrixRules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).set(columnIndex, element);
    }


    public GenericMatrix setGET(int rowIndex, int columnIndex, Object element)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.set(rowIndex, columnIndex, element);
        return newMatrix;
    }


    public void setRow(int rowIndex, GenericVector elements)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        getElements().set(rowIndex, elements);
    }


    public GenericMatrix setRowGET(int rowIndex, GenericVector elements)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.setRow(rowIndex, elements);
        return newMatrix;
    }


    public void setColumn(int columnIndex, GenericVector elements)
    {
        GenericMatrixService.setColumn(this, columnIndex, elements);
    }


    public GenericMatrix setColumnGET(int columnIndex, GenericVector elements)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.setColumn(columnIndex, elements);
        return newMatrix;
    }


    public void delete(int rowIndex, int columnIndex)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        GenericMatrixRules.isValidColumnIndex(this, columnIndex);
        getElements().get(rowIndex).delete(columnIndex);
    }


    public GenericMatrix deleteGET(int rowIndex, int columnIndex)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.delete(rowIndex, columnIndex);
        return newMatrix;
    }


    public void deleteRow(int rowIndex)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        getElements().delete(rowIndex);
    }


    public GenericMatrix deleteRowGET(int rowIndex)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.deleteRow(rowIndex);
        return newMatrix;
    }


    public void deleteColumn(int columnIndex)
    {
        GenericMatrixRules.isValidColumnIndex(this, columnIndex);
        IntStream.range(0, getNumberOfRows()).forEach(i -> delete(i, columnIndex));
    }


    public GenericMatrix deleteColumnGET(int columnIndex)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.deleteColumn(columnIndex);
        return newMatrix;
    }


    public void deleteRowAndColumn(int rowIndex, int columnIndex)
    {
        deleteRow(rowIndex);
        deleteColumn(columnIndex);
    }


    public GenericMatrix deleteRowAndColumnGET(int rowIndex, int columnIndex)
    {
        GenericMatrix newMatrix = getCopy();
        newMatrix.deleteRowAndColumn(rowIndex, columnIndex);
        return newMatrix;
    }


    public GenericVector getSubrow(int rowIndex, int fromColumn, int toColumn)
    {
        return GenericMatrixService.getSubrow(this, rowIndex, fromColumn, toColumn);
    }


    public GenericVector getRow(int rowIndex)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        return getElements().get(rowIndex);
    }


    public GenericVector getRowExceptDiagonalElement(int rowIndex)
    {
        return GenericMatrixService.getRowExceptDiagonalElement(this, rowIndex);
    }


    public GenericVector getRowCopyExceptDiagonalElement(int rowIndex)
    {
        return GenericMatrixService.getRowCopyExceptDiagonalElement(this, rowIndex);
    }


    public GenericVector getRowCopy(int rowIndex)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        return getElements().get(rowIndex).getCopy();
    }


    public Object get(int rowIndex, int columnIndex)
    {
        GenericMatrixRules.isValidRowIndex(this, rowIndex);
        GenericMatrixRules.isValidColumnIndex(this, columnIndex);
        return getElements().get(rowIndex).get(columnIndex);
    }


    public GenericVector getColumn(int columnIndex)
    {
        return GenericMatrixService.getColumn(this, columnIndex);
    }


    public Object[] getColumnAsArray(int columnIndex)
    {
        return GenericMatrixService.getColumn(this, columnIndex).getAsArray();
    }


    public GenericVector getColumnExceptDiagonalElement(int columnIndex)
    {
        return GenericMatrixService.getColumnExceptDiagonalElement(this, columnIndex);
    }


    public GenericVector getColumnCopyExceptDiagonalElement(int columnIndex)
    {
        return GenericMatrixService.getColumnCopyExceptDiagonalElement(this, columnIndex);
    }


    public GenericVector getColumnCopy(int columnIndex)
    {
        return GenericMatrixService.getColumnCopy(this, columnIndex);
    }


    public Object[] getColumnCopyAsArray(int columnIndex)
    {
        return GenericMatrixService.getColumnCopy(this, columnIndex).getAsArray();
    }


    public GenericVector getSubcolumn(int fromRow, int toRow, int columnIndex)
    {
        return GenericMatrixService.getSubcolumn(this, fromRow, toRow, columnIndex);
    }


    public boolean contains(Object x)
    {
        return GenericMatrixService.contains(this, x);
    }


    public boolean containsExceptInPosition(Object x, int rowIndex, int columnIndex)
    {
        return GenericMatrixService.containsExceptInPosition(this, x, rowIndex, columnIndex);
    }


    public Pair<Integer, Integer>[] getPositionsOfElement(Object x)
    {
        return GenericMatrixService.getPositionsOfElement(this, x);
    }


    public GenericMatrix transpose()
    {
        return GenericMatrixService.transpose(this);
    }


    public GenericMatrix getUpperTriangularPart()
    {
        return GenericMatrixService.getUpperTriangularPart(this);
    }


    public GenericMatrix getLowerTriangularPart()
    {
        return GenericMatrixService.getLowerTriangularPart(this);
    }


    public GenericMatrix swapRows(int row1, int row2)
    {
        return GenericMatrixService.swapRows(this, row1, row2);
    }


    public GenericMatrix swapColumns(int column1, int column2)
    {
        return GenericMatrixService.swapColumns(this, column1, column2);
    }


    public boolean isLowerTriangular()
    {
        return GenericMatrixService.isLowerTriangular(this);
    }


    public boolean isStrictlyLowerTriangular()
    {
        return GenericMatrixService.isStrictlyLowerTriangular(this);
    }


    public boolean isUpperTriangular()
    {
        return GenericMatrixService.isUpperTriangular(this);
    }


    public boolean isStrictlyUpperTriangular()
    {
        return GenericMatrixService.isStrictlyUpperTriangular(this);
    }


    public boolean isDiagonal()
    {
        return GenericMatrixService.isDiagonal(this);
    }


    public GenericMatrix augmentWith(GenericVector other)
    {
        return GenericMatrixService.augmentWith(this, other);
    }


    public GenericMatrix augmentWith(GenericMatrix other)
    {
        return GenericMatrixService.augmentWith(this, other);
    }


    public boolean isSymmetric()
    {
        return GenericMatrixService.isSymmetric(this);
    }


    public GenericMatrix rotate90DegreesClockwise()
    {
        return GenericMatrixService.rotate90DegreesClockwise(this);
    }


    public GenericMatrix getMinor(int rowToExclude, int columnToExclude)
    {
        return GenericMatrixService.getMinor(this, rowToExclude, columnToExclude);
    }


    public boolean isCirculantMatrix()
    {
        return GenericMatrixService.isCirculantMatrix(this);
    }


    public boolean isSquareMatrix()
    {
        return GenericMatrixService.isSquareMatrix(this);
    }


    public boolean isRectangularMatrix()
    {
        return GenericMatrixService.isRectangularMatrix(this);
    }


    public boolean isTriangularMatrix()
    {
        return GenericMatrixService.isTriangularMatrix(this);
    }


    public List<Object> getAsList()
    {
        List<Object> allRowsElements = new ArrayList<Object>();
        IntStream.range(0, getNumberOfRows()).forEach(i -> allRowsElements.addAll(getRow(i).getAsList()));
        return allRowsElements;
    }


    public GenericVector getAsVector()
    {
        List<Object> allRowsElements = new ArrayList<Object>();
        IntStream.range(0, getNumberOfRows()).forEach(i -> allRowsElements.addAll(getRow(i).getAsList()));
        return GenericVector.of(allRowsElements);
    }


    public Stream<Object> filterRow(int rowIndex, Predicate<Object> filterToApply)
    {
        return getRow(rowIndex).filter(filterToApply);
    }


    public Stream<Object> filterColumn(int columnIndex, Predicate<Object> filterToApply)
    {
        return getColumn(columnIndex).filter(filterToApply);
    }


    public Stream<Object> filterAll(Predicate<Object> filterToApply)
    {
        return getAsVector().filter(filterToApply);
    }


    public Stream<Object> filterAll(BiPredicate<Integer, Integer> filterToApply)
    {
        List<Object> filteredElements = new ArrayList<>();

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

        return Stream.<Object>of(filteredElements.toArray(new Object[0]));
    }


    public boolean findAny(Predicate<Object> filterToApply)
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


    public void forAllInRow(int rowIndex, Consumer<Object> action)
    {
        getRow(rowIndex).forAll(action);
    }


    public void forAllInRow(int rowIndex, IntConsumer action)
    {
        getRow(rowIndex).forAllIndices(action);
    }


    public void forAllInColumn(int columnIndex, Consumer<Object> action)
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


    public void forAll(Stream<Object> stream, Consumer<Object> action)
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
        IntStream.range(0, getNumberOfRows()).forEach(i ->
        {
            IntStream.range(0, getNumberOfColumns()).forEach(j -> action.accept(i, j));
        });
    }


    public void forAllColumnAndRowIndices(BiConsumer<Integer, Integer> action)
    {
        IntStream.range(0, getNumberOfColumns()).forEach(j ->
        {
            IntStream.range(0, getNumberOfRows()).forEach(i -> action.accept(i, j));
        });
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
        GenericMatrixRules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

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
        GenericMatrixRules.isValidRowsInterval(this, fromRow, toRow);

        for(int i = fromRow; i <= toRow; i++)
        {
            action.accept(i);
        }

    }


    public void forColumnIndices(int fromColumn, int toColumn, IntConsumer action)
    {
        GenericMatrixRules.isValidColumnsInterval(this, fromColumn, toColumn);

        for(int j = fromColumn; j <= toColumn; j++)
        {
            action.accept(j);
        }

    }


    public void forRowAndColumnIndices(int fromRow, int toRow, int fromColumn, int toColumn, BiConsumer<Integer, Integer> action)
    {
        GenericMatrixRules.areValidDimensionIntervals(this, fromRow, toRow, fromColumn, toColumn);

        for(int i = fromRow; i <= toRow; i++)
        {

            for(int j = fromColumn; j <= toColumn; j++)
            {
                action.accept(i, j);
            }

        }

    }


    public void filterAndLoop(Predicate<Object> filterToApply, Consumer<Object> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterAndLoop(BiPredicate<Integer, Integer> filterToApply, Consumer<Object> action)
    {
        forAll(filterAll(filterToApply), action);
    }


    public void filterRowAndLoop(int rowIndex, Predicate<Object> filterToApply, Consumer<Object> action)
    {
        forAll(filterRow(rowIndex, filterToApply), action);
    }


    public void filterColumnAndLoop(int columnIndex, Predicate<Object> filterToApply, Consumer<Object> action)
    {
        forAll(filterColumn(columnIndex, filterToApply), action);
    }


    public void setElementsAsArrayOfrrays(Object[][] elements)
    {
        this.elements = GenericMatrixService.convertElementsToListOfVectors(elements);
    }


    @Override
    public GenericMatrix clone() throws CloneNotSupportedException
    {
        return (GenericMatrix)CloningService.clone(this);
    }


    public GenericMatrix getCopy()
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
        return GenericMatrixInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return GenericMatrixInternalService.equals(this, object);
    }


    public OrionList<GenericVector> getElements()
    {
        return this.elements;
    }
}