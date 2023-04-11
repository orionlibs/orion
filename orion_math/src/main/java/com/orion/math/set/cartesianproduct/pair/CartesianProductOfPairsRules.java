package com.orion.math.set.cartesianproduct.pair;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;

public class CartesianProductOfPairsRules extends MathRule
{
    public static void isValid(OrionSet<Pair<ANumber, ANumber>> elements)
    {
        Assert.notEmpty(elements, "The Cartesian product elements input cannot be null/empty.");
    }


    public static void isValid(CartesianProductOfPairs cartesianProductOfPairs)
    {
        Assert.notNull(cartesianProductOfPairs, "The cartesianProduct input cannot be null.");
        isValid(cartesianProductOfPairs.getElements());
    }
}