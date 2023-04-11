package com.orion.math.set.cartesianproduct.pair.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.cartesianproduct.pair.CartesianProductOfPairs;
import com.orion.math.set.cartesianproduct.pair.CartesianProductOfPairsRules;

public class CartesianProductOfPairsEqualsTask extends Orion
{
    public static boolean run(CartesianProductOfPairs x, Object object)
    {
        CartesianProductOfPairsRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            CartesianProductOfPairs other = (CartesianProductOfPairs)object;
            return x.getElements().equals(other.getElements());
        }

    }
}