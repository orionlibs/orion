package com.orion.math.geometry.vector;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VectorRules extends MathRule
{
    public static void hasNaturalNumbers(Vector vector)
    {
        isValid(vector);
        vector.forAll(x -> NumberRules.hasNaturalNumberValue(x));
    }


    public static void contains(Vector vector, ANumber x)
    {
        isValid(vector);
        Assert.isFalse(vector.notContains(x), "Vector does not contain given number.");
    }


    public static void isDimensionsAPowerOf2(Vector vector)
    {
        isValid(vector);
        Assert.isFalse(ANumber.of(vector.getDimensions()).isPowerOf2(), "Vector size is not a power of 2.");
    }


    public static void doVectorSizesMatch(Vector vector1, Vector vector2, int dimensionsToHave)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.getSize(), vector2.getSize(), "Vector sizes do not match.");
        Assert.areEqual(vector1.getSize(), dimensionsToHave, "Vector sizes do not match.");
        Assert.areEqual(vector2.getSize(), dimensionsToHave, "Vector sizes do not match.");
    }


    public static void isValidNumberOfVectors(List<Vector> vectors, int requiredNumberOfVectors)
    {
        areValid(vectors);
        Assert.isGreaterOrEqualTo(vectors.size(), requiredNumberOfVectors, String.format("You need at least {} vectors to check for linear (in)dependence.", requiredNumberOfVectors));
    }


    public static void doVectorSizesMatch(List<Vector> vectors)
    {
        areValid(vectors);
        int dimensions = vectors.get(0).getDimensions();

        for(Vector vector : vectors)
        {
            Assert.areEqual(vector.getDimensions(), dimensions, "Vector sizes do not match.");
        }

    }


    public static void doVectorSizesMatch(Vector... vectors)
    {
        areValid(vectors);
        doVectorSizesMatch(Arrays.asList(vectors));
    }


    public static void doVectorSizesMatch(Vector vector1, Vector vector2)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.getSize(), vector2.getSize(), "Vector sizes do not match.");
    }


    public static void doVectorSizesMatch(ANumber[] vector1, ANumber[] vector2)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.length, vector2.length, "Vector sizes do not match.");
    }


    public static void isValid(OrionList<ANumber> elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValidDimensions(int dimensions)
    {
        Assert.isPositive(dimensions, "Vector dimensions are invalid.");
    }


    public static void isValidDimensions(int dimensions, int expectedDimensions)
    {
        Assert.areEqual(dimensions, expectedDimensions, "Vector dimensions are invalid.");
    }


    public static void isDimensionsAtLeast(int dimensions, int expectedDimensions)
    {
        Assert.isGreaterOrEqualTo(dimensions, expectedDimensions, "Vector dimensions are invalid.");
    }


    public static void isValid(int dimensions)
    {
        Assert.isPositive(dimensions, "Vector dimensions are invalid.");
    }


    public static void isValid(Point startPoint, Point endPoint)
    {
        Assert.notNull(startPoint, "The startPoint input cannot be null.");
        Assert.notEmpty(startPoint.getCoordinates(), "The startPoint coordinates cannot be null/empty.");
        Assert.notNull(endPoint, "The endPoint input cannot be null.");
        Assert.notEmpty(endPoint.getCoordinates(), "The endPoint coordinates cannot be null/empty.");
        Assert.areEqual(startPoint.getCoordinates().length, endPoint.getCoordinates().length, "Vector points sizes do not match.");
    }


    public static void isValid(OrionList<ANumber> elements, Point startPoint, Point endPoint)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        Assert.notNull(startPoint, "The startPoint input cannot be null.");
        Assert.notEmpty(startPoint.getCoordinates(), "The startPoint coordinates cannot be null/empty.");
        Assert.notNull(endPoint, "The endPoint input cannot be null.");
        Assert.notEmpty(endPoint.getCoordinates(), "The endPoint coordinates cannot be null/empty.");
        Assert.areEqual(startPoint.getCoordinates().length, endPoint.getCoordinates().length, "Vector points sizes do not match.");
    }


    public static void isValid(ANumber[] elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValid(Number[] elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValid(String[] elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValid(List<ANumber> elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValid(Set<ANumber> elements)
    {
        Assert.notEmpty(elements, "Vector element(s) is/are empty.");
    }


    public static void isValid(Vector vector)
    {
        Assert.notNull(vector, "The vector input cannot be null.");
        isValid(vector.getElements(), vector.getStartPoint(), vector.getEndPoint());
    }


    public static void areValid(Vector... vectors)
    {
        Assert.notEmpty(vectors, "The vectors input cannot be null/empty.");
        Arrays.stream(vectors).forEach(vector -> isValid(vector));
    }


    public static void areValid(List<Vector> vectors)
    {
        Assert.notEmpty(vectors, "The vectors input cannot be null/empty.");
        vectors.forEach(vector -> isValid(vector));
    }


    public static void isNotZeroVector(Vector vector)
    {
        isValid(vector);
        Assert.isFalse(vector.isZeroVector(), "Vector cannot be a zero vector.");
    }
}