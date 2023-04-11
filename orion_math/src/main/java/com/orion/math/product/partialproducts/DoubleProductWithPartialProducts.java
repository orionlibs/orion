package com.orion.math.product.partialproducts;

import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.product.Product;
import java.util.stream.IntStream;

public class DoubleProductWithPartialProducts extends Product
{
    public DoubleProductWithPartialProducts(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        ProductWithPartialProductsRules.isValid(expression);
        setDoubleProductExpression(expression);
    }


    public static DoubleProductWithPartialProducts of(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        return new DoubleProductWithPartialProducts(expression);
    }


    public ANumber getProduct(int startOfProduct1, int endOfProduct1, int startOfProduct2, int endOfProduct2)
    {
        NumberRules.isLessThan(startOfProduct1, endOfProduct1);
        NumberRules.isLessThan(startOfProduct2, endOfProduct2);
        ANumber sum = ANumber.of(0);
        IntStream.range(startOfProduct1, endOfProduct1 + 1).forEach(i ->
        {
            IntStream.range(startOfProduct2, endOfProduct2 + 1).forEach(j -> sum.add(getDoubleProductExpression().run(ANumber.of(i), ANumber.of(j))));
        });
        return sum;
    }
}