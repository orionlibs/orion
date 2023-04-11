package com.orion.math.set;

import com.orion.math.MathRule;

public class MultiSets extends MathRule
{
    public static boolean isEmpty(MultiSet elements)
    {
        return elements != null && elements.isEmpty();
    }
}