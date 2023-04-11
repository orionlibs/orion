package com.orion.math.set.cartesianproduct.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.cartesianproduct.CartesianProduct;
import com.orion.math.set.cartesianproduct.CartesianProductRules;

public class CartesianProductEqualsTask extends Orion
{
    public static boolean run(CartesianProduct x, Object object)
    {
        CartesianProductRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            CartesianProduct other = (CartesianProduct)object;
            return x.getElements().equals(other.getElements());
        }

    }
}