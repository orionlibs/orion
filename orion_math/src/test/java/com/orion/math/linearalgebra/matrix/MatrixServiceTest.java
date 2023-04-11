package com.orion.math.linearalgebra.matrix;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class MatrixServiceTest
{
    @Test
    public void applyPrecision()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of("1.64352"), ANumber.of("1.64352"), ANumber.of("1.64352")});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of("1.64352"), ANumber.of("1.64352"), ANumber.of("1.64352")});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of("1.64352"), ANumber.of("1.64352"), ANumber.of("1.64352")});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.applyPrecision(m, 3);
        assertTrue(m.findIfAll((i, j) -> m.get(i, j).equal(ANumber.of(1.644))));
    }


    @Test
    public void getDiagonal()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Vector result = MatrixService.getDiagonal(m);
        assertTrue(Vector.of(1, 5, 9).equals(result));
    }


    @Test
    public void getSubmatrix()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.getSubmatrix(m, 1, 2, 1, 2);
        ANumber[][] expectedElements =
        {
                        {ANumber.of(5), ANumber.of(6)},
                        {ANumber.of(8), ANumber.of(9)}};
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void isZeroMatrix1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        boolean result = MatrixService.isZeroMatrix(m);
        assertFalse(result);
    }


    @Test
    public void isZeroMatrix2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        boolean result = MatrixService.isZeroMatrix(m);
        assertTrue(result);
    }


    @Test
    public void isIdentityMatrix1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        boolean result = MatrixService.isIdentityMatrix(m);
        assertFalse(result);
    }


    @Test
    public void isIdentityMatrix2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1), ANumber.of(0)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(1)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        boolean result = MatrixService.isIdentityMatrix(m);
        assertTrue(result);
    }


    @Test
    public void getColumnExceptDiagonalElement()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Vector result = MatrixService.getColumnExceptDiagonalElement(m, 0);
        assertTrue(Vector.of(4, 7).equals(result));
        result = MatrixService.getColumnExceptDiagonalElement(m, 1);
        assertTrue(Vector.of(2, 8).equals(result));
        result = MatrixService.getColumnExceptDiagonalElement(m, 2);
        assertTrue(Vector.of(3, 6).equals(result));
    }


    @Test
    public void swapRows()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.swapRows(m, 0, 2);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        expectedElements.append(vector3);
        expectedElements.append(vector2);
        expectedElements.append(vector1);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void multiplyRow()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.multiplyRow(m, 1, ANumber.of(3));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(12), ANumber.of(15), ANumber.of(18)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void multiplyColumn()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.multiplyColumn(m, 1, ANumber.of(3));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(6), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(15), ANumber.of(6)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(24), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void addToColumn1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.addToColumn(m, 1, ANumber.of(3));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(5), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(8), ANumber.of(6)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(11), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void addToColumn2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.addToColumn(m, 1, Vector.of(3, 4, 5));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(5), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(9), ANumber.of(6)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(13), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void subtractFromColumn1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.subtractFromColumn(m, 1, ANumber.of(3));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(2), ANumber.of(6)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(5), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void subtractFromColumn2()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        MatrixService.subtractFromColumn(m, 1, Vector.of(3, 4, 5));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-1), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(1), ANumber.of(6)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(3), ANumber.of(9)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(m));
    }


    @Test
    public void augmentWith()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.augmentWith(m, Vector.of(10, 11, 12));
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3), ANumber.of(10)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6), ANumber.of(11)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9), ANumber.of(12)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void rotate90DegreesClockwise()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.rotate90DegreesClockwise(m);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(4), ANumber.of(1)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(8), ANumber.of(5), ANumber.of(2)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(9), ANumber.of(6), ANumber.of(3)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void getCumulativeSumForColumns()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.getCumulativeSumForColumns(m);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(5), ANumber.of(7), ANumber.of(9)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(12), ANumber.of(15), ANumber.of(18)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void getDifferencesBetweenSuccessiveRowElements()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.getDifferencesBetweenSuccessiveRowElements(m);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(3), ANumber.of(3)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(3), ANumber.of(3)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void getDifferencesBetweenSuccessiveColumnElements()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.getDifferencesBetweenSuccessiveColumnElements(m);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }


    @Test
    public void normaliseFrom0To1()
    {
        OrionList<Vector> elements = OrionArrayList.of();
        Vector vector1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector vector2 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(5), ANumber.of(6)});
        Vector vector3 = Vector.of(new ANumber[]
        {ANumber.of(7), ANumber.of(8), ANumber.of(9)});
        elements.append(vector1);
        elements.append(vector2);
        elements.append(vector3);
        Matrix m = Matrix.of(elements);
        Matrix result = MatrixService.normaliseFrom0To1(m);
        OrionList<Vector> expectedElements = OrionArrayList.of();
        Vector expectedVector1 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(0)});
        Vector expectedVector2 = Vector.of(new ANumber[]
        {ANumber.of(0.5), ANumber.of(0.5), ANumber.of(0.5)});
        Vector expectedVector3 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(1)});
        expectedElements.append(expectedVector1);
        expectedElements.append(expectedVector2);
        expectedElements.append(expectedVector3);
        Matrix expected = Matrix.of(expectedElements);
        assertTrue(expected.equals(result));
    }
}