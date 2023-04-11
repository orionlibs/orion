package com.orion.math.set.cartesianproduct.pair;

import com.orion.math.MathObject;
import com.orion.math.set.cartesianproduct.pair.tasks.CartesianProductOfPairsEqualsTask;
import com.orion.math.set.cartesianproduct.pair.tasks.CartesianProductOfPairsHashCodeTask;

class CartesianProductOfPairsInternalService implements MathObject
{
    static boolean equals(CartesianProductOfPairs x, Object y)
    {
        return CartesianProductOfPairsEqualsTask.run(x, y);
    }


    static int hashCode(CartesianProductOfPairs x)
    {
        return CartesianProductOfPairsHashCodeTask.run(x);
    }
}