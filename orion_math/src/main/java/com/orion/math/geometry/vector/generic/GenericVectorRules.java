package com.orion.math.geometry.vector.generic;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import java.util.Arrays;
import java.util.List;

public class GenericVectorRules extends MathRule
{
    public static void doVectorSizesMatch(GenericVector vector1, GenericVector vector2, int dimensionsToHave)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.getSize(), vector2.getSize(), "GenericVector sizes do not match.");
        Assert.areEqual(vector1.getSize(), dimensionsToHave, "GenericVector sizes do not match.");
        Assert.areEqual(vector2.getSize(), dimensionsToHave, "GenericVector sizes do not match.");
    }


    public static void doVectorSizesMatch(List<GenericVector> genericVectors)
    {
        areValid(genericVectors);
        int dimensions = genericVectors.get(0).getDimensions();

        for(GenericVector genericVector : genericVectors)
        {
            Assert.areEqual(genericVector.getDimensions(), dimensions, "GenericVector sizes do not match.");
        }

    }


    public static void doVectorSizesMatch(GenericVector... vectors)
    {
        areValid(vectors);
        doVectorSizesMatch(Arrays.asList(vectors));
    }


    public static void doVectorSizesMatch(GenericVector vector1, GenericVector vector2)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.getSize(), vector2.getSize(), "GenericVector sizes do not match.");
    }


    public static void isValid(OrionList<Object> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isValidDimensions(int dimensions)
    {
        Assert.isPositive(dimensions, "GenericVector dimensions are invalid.");
    }


    public static void isValid(int dimensions)
    {
        Assert.isPositive(dimensions, "GenericVector dimensions are invalid.");
    }


    public static void isValid(Object[] elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isValid(List<Object> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isValid(GenericVector genericVector)
    {
        Assert.notNull(genericVector, "The genericVector input cannot be null.");
        isValid(genericVector.getElements());
    }


    public static void areValid(GenericVector... vectors)
    {
        Assert.notEmpty(vectors, "The vectors input cannot be null/empty.");
        Arrays.stream(vectors).forEach(vector -> isValid(vector));
    }


    public static void areValid(List<GenericVector> genericVectors)
    {
        Assert.notEmpty(genericVectors, "The genericVectors input cannot be null/empty.");
        genericVectors.forEach(vector -> isValid(vector));
    }
}