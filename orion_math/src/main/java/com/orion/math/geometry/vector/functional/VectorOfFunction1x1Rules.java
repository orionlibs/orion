package com.orion.math.geometry.vector.functional;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VectorOfFunction1x1Rules extends MathRule
{
    public static void isValid(Function1x1<ANumber, ANumber>[] elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        Arrays.stream(elements).forEach(f -> FunctionRules.isValid(f));
    }


    public static void isValid(List<Function1x1<ANumber, ANumber>> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        elements.forEach(f -> FunctionRules.isValid(f));
    }


    public static void doVectorSizesMatch(VectorOfFunction1x1 vector1, VectorOfFunction1x1 vector2)
    {
        isValid(vector1);
        isValid(vector2);
        Assert.areEqual(vector1.getSize(), vector2.getSize(), "Vector sizes do not match.");
    }


    public static void isValid(Set<Function1x1<ANumber, ANumber>> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        elements.forEach(f -> FunctionRules.isValid(f));
    }


    public static void areValid(VectorOfFunction1x1... vectors)
    {
        Assert.notEmpty(vectors, "The vectors input cannot be null/empty.");
        Arrays.stream(vectors).forEach(vector -> isValid(vector));
    }


    public static void areValid(List<VectorOfFunction1x1> vectors)
    {
        Assert.notEmpty(vectors, "The vectors input cannot be null/empty.");
        vectors.forEach(vector -> isValid(vector));
    }


    public static void isValid(VectorOfFunction1x1 vector)
    {
        Assert.notNull(vector, "The vector input cannot be null.");
        isValid(vector.getElements());
    }
}