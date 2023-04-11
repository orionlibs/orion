package com.orion.math.product.partialproducts;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.function.Functions;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import java.util.List;

public class ProductWithPartialProductsRules extends MathRule
{
    public static void isValid(Function1x1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Product partial products function is empty.");
    }


    public static void isValid(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Double product partial products function is empty.");
    }


    public static void isValid(FunctionNx1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "N-product product partial productss function is empty.");
    }


    public static void isValid(ProductWithPartialProducts productWithPartialProducts)
    {
        Assert.notNull(productWithPartialProducts, "The productWithPartialProducts input cannot be null.");
        isValid(productWithPartialProducts.getExpression());
    }


    public static void isValid(DoubleProductWithPartialProducts productWithPartialProducts)
    {
        Assert.notNull(productWithPartialProducts, "The productWithPartialProducts input cannot be null.");
        isValid(productWithPartialProducts.getDoubleProductExpression());
    }


    public static void isValid(NProductProductWithPartialProducts productWithPartialProducts)
    {
        Assert.notNull(productWithPartialProducts, "The productWithPartialProducts input cannot be null.");
        isValid(productWithPartialProducts.getNProductExpression());
    }


    public static void isValid(List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        Assert.hasLengthAtLeast(pairsOfStartAndEndIndices, 1, "The pairsOfStartAndEndIndices input has to have at least 1 pair of start/end indices.");
        pairsOfStartAndEndIndices.forEach(pair -> Assert.notNull(pair, "There is at least one pair of start/end indices that is null"));
    }
}