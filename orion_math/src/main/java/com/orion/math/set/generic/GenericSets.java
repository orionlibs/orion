package com.orion.math.set.generic;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathRule;

public class GenericSets extends MathRule
{
    public static boolean isNotEmpty(OrionSet<Object> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isNotEmpty(GenericSet elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isEmpty(GenericSet elements)
    {
        return !isNotEmpty(elements);
    }


    public static boolean isNotEmpty(OrionSet<Object> elements, GenericSet elementsOfSets)
    {
        return (elements != null && elements.isEmpty()) || (elementsOfSets != null && elementsOfSets.isEmpty());
    }
}