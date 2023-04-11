package com.orion.math.set.generic;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import java.util.Arrays;
import java.util.List;

public class GenericSetRules extends MathRule
{
    public static void isNotEmpty(GenericSet genericSet)
    {
        Assert.notNull(genericSet, "The genericSet input cannot be null/empty.");
        isValid(genericSet.getElements());
    }


    public static void isNotEmpty(GenericMultiSet genericSet)
    {
        Assert.notNull(genericSet, "The GenericMultiSet input cannot be null/empty.");
        isValid(genericSet.getElements());
    }


    public static void isNotEmpty(OrionSet<Object> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isNotEmpty(List<Object> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isValid(OrionSet<Object> elements)
    {
        isNotEmpty(elements);
    }


    public static void isValid(List<Object> elements)
    {
        isNotEmpty(elements);
    }


    public static void isValid(GenericSet genericSet)
    {
        Assert.notNull(genericSet, "The genericSet input cannot be null/empty.");
        isValid(genericSet.getElements());
    }


    public static void isValid(GenericMultiSet genericSet)
    {
        Assert.notNull(genericSet, "The GenericMultiSet input cannot be null/empty.");
        isValid(genericSet.getElements());
    }


    public static <T> void isValid(GenericSet... sets)
    {
        Assert.notNull(sets, "The sets input cannot be null/empty.");
        Arrays.stream(sets).forEach(set -> isValid(set.getElements()));
    }


    public static <T> void isValid(GenericMultiSet... sets)
    {
        Assert.notNull(sets, "The sets input cannot be null/empty.");
        Arrays.stream(sets).forEach(set -> isValid(set.getElements()));
    }
}