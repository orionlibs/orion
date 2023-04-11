package com.orion.math.geometry.vector;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class VectorServiceTest
{
    @Test
    public void negate()
    {
        Vector v = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector result = VectorService.negate(v);
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(-1), ANumber.of(-2), ANumber.of(-3)});
        assertTrue(expected.equals(result));
    }


    @Test
    public void getBasisVector()
    {
        Vector result = VectorService.getBasisVector(4, Axis.Y);
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        assertTrue(expected.equals(result));
    }


    @Test
    public void getVectorComponent()
    {
        Vector v = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector result = VectorService.getVectorComponent(v, Axis.Y);
        Vector expected = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(2), ANumber.of(0)});
        assertTrue(expected.equals(result));
    }


    @Test
    public void getVectorComponents()
    {
        Vector v = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector[] result = VectorService.getVectorComponents(v);
        Vector expected1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(0), ANumber.of(0)});
        Vector expected2 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(2), ANumber.of(0)});
        Vector expected3 = Vector.of(new ANumber[]
        {ANumber.of(0), ANumber.of(0), ANumber.of(3)});
        assertTrue(expected1.equals(result[0]));
        assertTrue(expected2.equals(result[1]));
        assertTrue(expected3.equals(result[2]));
    }


    @Test
    public void areVectorsLinearlyDependent()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(5), ANumber.of(3)});
        Vector v2 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(1)});
        Vector v3 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(-2), ANumber.of(0)});
        boolean result = VectorService.areVectorsLinearlyDependent(v1, v2, v3);
        assertFalse(result);
        v1 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(1), ANumber.of(-2)});
        v2 = Vector.of(new ANumber[]
        {ANumber.of(-3), ANumber.of(0), ANumber.of(1)});
        v3 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(-2), ANumber.of(1)});
        result = VectorService.areVectorsLinearlyDependent(v1, v2, v3);
        assertTrue(result);
    }


    @Test
    public void areVectorsLinearlyIndependent()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(5), ANumber.of(3)});
        Vector v2 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(1), ANumber.of(1)});
        Vector v3 = Vector.of(new ANumber[]
        {ANumber.of(4), ANumber.of(-2), ANumber.of(0)});
        boolean result = VectorService.areVectorsLinearlyIndependent(v1, v2, v3);
        assertTrue(result);
    }


    @Test
    public void isPointBetweenVectorEndPoints()
    {
        Vector v = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(2)});
        boolean result = VectorService.isPointBetweenVectorEndPoints(v, Point.of(1, 1));
        assertTrue(result);
        v = Vector.of(new ANumber[]
        {ANumber.of(2), ANumber.of(2), ANumber.of(2)});
        result = VectorService.isPointBetweenVectorEndPoints(v, Point.of(1, 1, 1));
        assertTrue(result);
    }


    @Test
    public void getLengthOfLongestIncreasingSubsequence()
    {
        Vector v = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(2.3), ANumber.of(2), ANumber.of(1), ANumber.of(2), ANumber.of(3), ANumber.of(4), ANumber.of(3.9)});
        int result = VectorService.getLengthOfLongestIncreasingSubsequence(v);
        assertTrue(result == 4);
        v = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(2.3), ANumber.of(2), ANumber.of(1), ANumber.of(2), ANumber.of(3), ANumber.of(4), ANumber.of(4)});
        result = VectorService.getLengthOfLongestIncreasingSubsequence(v);
        assertTrue(result == 5);
    }


    @Test
    public void sortAndMapTogether()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(2), ANumber.of(4), ANumber.of(1)});
        Vector v2 = Vector.of(new ANumber[]
        {ANumber.of(14), ANumber.of(12), ANumber.of(18), ANumber.of(16)});
        Pair<Vector, Vector> result = VectorService.sortAndMapTogether(v1, v2);
        Vector expected1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3), ANumber.of(4)});
        Vector expected2 = Vector.of(new ANumber[]
        {ANumber.of(16), ANumber.of(12), ANumber.of(14), ANumber.of(18)});
        assertTrue(expected1.equals(result.getFirst()));
        assertTrue(expected2.equals(result.getSecond()));
    }


    @Test
    public void flattenVectors()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(3), ANumber.of(2), ANumber.of(4), ANumber.of(1)});
        Vector v2 = Vector.of(new ANumber[]
        {ANumber.of(14), ANumber.of(12), ANumber.of(18), ANumber.of(16)});
        List<ANumber> result = VectorService.flattenVectors(Arrays.asList(v1, v2));
        List<ANumber> expected = Arrays.asList(ANumber.of(3), ANumber.of(2), ANumber.of(4), ANumber.of(1), ANumber.of(14), ANumber.of(12), ANumber.of(18), ANumber.of(16));
        assertTrue(expected.equals(result));
    }


    @Test
    public void normalise()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector result = VectorService.normalise(v1);
        assertTrue(Vector.of(ANumber.of("0.267261241912424391"), ANumber.of("0.534522483824848782"), ANumber.of("0.801783725737273172")).equals(result));
    }


    @Test
    public void normaliseFrom0To1()
    {
        Vector v1 = Vector.of(new ANumber[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)});
        Vector result = VectorService.normaliseFrom0To1(v1);
        assertTrue(Vector.of(0, 0.5, 1).equals(result));
    }
}