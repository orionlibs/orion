package com.orion.math.set.generic;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;

public class GenericMultiSets extends MathRule
{
    public static boolean isNotEmpty(GenericMultiSet elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isEmpty(GenericMultiSet elements)
    {
        return !isNotEmpty(elements);
    }


    public static boolean isNotEmpty(OrionSet<Object> elements, GenericMultiSet elementsOfSets)
    {
        return (elements != null && elements.isEmpty()) || (elementsOfSets != null && elementsOfSets.isEmpty());
    }
}