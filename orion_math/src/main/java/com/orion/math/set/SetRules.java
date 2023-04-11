package com.orion.math.set;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;

public class SetRules extends MathRule
{
    public static void isNotEmpty(Set set)
    {
        Assert.notNull(set, "The set input cannot be null.");
        isValid(set.getElements());
    }


    public static void isNotEmpty(MultiSet set)
    {
        Assert.notNull(set, "The MultiSet input cannot be null.");
        isValid(set.getElements());
    }


    public static void isNotEmpty(OrionSet<ANumber> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isNotEmpty(List<ANumber> elements)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
    }


    public static void isValid(OrionSet<ANumber> elements)
    {
        isNotEmpty(elements);
    }


    public static void isValid(List<ANumber> elements)
    {
        isNotEmpty(elements);
    }


    public static void isValid(Set set)
    {
        Assert.notNull(set, "The set input cannot be null.");
        isValid(set.getElements());
    }


    public static void isValid(MultiSet set)
    {
        Assert.notNull(set, "The MultiSet input cannot be null.");
        isValid(set.getElements());
    }


    public static <T> void isValid(Set... sets)
    {
        Assert.notNull(sets, "The set input cannot be null.");
        Arrays.stream(sets).forEach(set -> isValid(set.getElements()));
    }


    public static <T> void isValid(MultiSet... sets)
    {
        Assert.notNull(sets, "The MultiSet input cannot be null.");
        Arrays.stream(sets).forEach(multiset -> isValid(multiset.getElements()));
    }
}