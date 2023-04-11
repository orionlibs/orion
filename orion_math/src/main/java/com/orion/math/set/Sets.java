package com.orion.math.set;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;

public class Sets extends MathRule
{
    public static boolean isNotEmpty(OrionSet<ANumber> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isNotEmpty(Set elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isEmpty(Set elements)
    {
        return !isNotEmpty(elements);
    }


    public static boolean isNotEmpty(OrionSet<ANumber> elements, Set elementsOfSets)
    {
        return (elements != null && elements.isEmpty()) || (elementsOfSets != null && elementsOfSets.isEmpty());
    }
}