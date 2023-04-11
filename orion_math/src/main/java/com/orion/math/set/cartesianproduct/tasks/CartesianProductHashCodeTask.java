package com.orion.math.set.cartesianproduct.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.cartesianproduct.CartesianProduct;

public class CartesianProductHashCodeTask extends Orion
{
    public static int run(CartesianProduct cartesianProduct)
    {
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + cartesianProduct.getElements().hashCode();
    }
}