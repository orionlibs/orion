package com.orion.math.set.cartesianproduct;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.tuple.NTuple;
import com.orion.math.MathRule;

public class CartesianProductRules extends MathRule
{
    public static void isValid(OrionSet<NTuple> elements)
    {
        Assert.notEmpty(elements, "The Cartesian product elements input cannot be null/empty.");
        int nTupleSize = 0;
        int i = 0;

        for(NTuple nTuple : elements)
        {

            if(i == 0)
            {
                nTupleSize = nTuple.getSize();
            }
            else
            {
                Assert.hasLength(nTuple.getElements(), nTupleSize, "The given NTuples do not have the same size.");
            }

            i++;
        }

    }


    public static void isValid(CartesianProduct cartesianProduct)
    {
        Assert.notNull(cartesianProduct, "The cartesianProduct input cannot be null.");
        isValid(cartesianProduct.getElements());
    }
}