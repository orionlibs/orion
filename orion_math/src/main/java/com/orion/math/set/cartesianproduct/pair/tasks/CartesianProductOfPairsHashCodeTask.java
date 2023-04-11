package com.orion.math.set.cartesianproduct.pair.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.cartesianproduct.pair.CartesianProductOfPairs;

public class CartesianProductOfPairsHashCodeTask extends Orion
{
    public static int run(CartesianProductOfPairs cartesianProductOfPairs)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + cartesianProductOfPairs.getElements().hashCode();
    }
}