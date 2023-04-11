package com.orion.math.set.cartesianproduct;

import com.orion.math.MathObject;
import com.orion.math.set.cartesianproduct.tasks.CartesianProductEqualsTask;
import com.orion.math.set.cartesianproduct.tasks.CartesianProductHashCodeTask;

class CartesianProductInternalService implements MathObject
{
    static boolean equals(CartesianProduct x, Object y)
    {
        return CartesianProductEqualsTask.run(x, y);
    }


    static int hashCode(CartesianProduct x)
    {
        return CartesianProductHashCodeTask.run(x);
    }
}