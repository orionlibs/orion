package com.orion.math.product.partialproducts;

import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.product.Product;
import java.util.List;

public class NProductProductWithPartialProducts extends Product
{
    public NProductProductWithPartialProducts(FunctionNx1IF<ANumber, ANumber> expression)
    {
        ProductWithPartialProductsRules.isValid(expression);
        setNProductExpression(expression);
    }


    public static NProductProductWithPartialProducts of(FunctionNx1IF<ANumber, ANumber> expression)
    {
        return new NProductProductWithPartialProducts(expression);
    }


    public ANumber getProduct(List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        return NProductProductWithPartialProductsInternalService.getProduct(getNProductExpression(), pairsOfStartAndEndIndices);
    }
}