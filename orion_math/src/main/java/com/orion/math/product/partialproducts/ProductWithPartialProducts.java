package com.orion.math.product.partialproducts;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.product.Product;
import java.util.stream.IntStream;

public class ProductWithPartialProducts extends Product
{
    public ProductWithPartialProducts(Function1x1IF<ANumber, ANumber> expression)
    {
        ProductWithPartialProductsRules.isValid(expression);
        setExpression(expression);
    }


    public static ProductWithPartialProducts of(Function1x1IF<ANumber, ANumber> expression)
    {
        return new ProductWithPartialProducts(expression);
    }


    public ANumber getProduct(int start, int end)
    {
        NumberRules.isLessThan(start, end);
        ANumber product = ANumber.of(1);
        IntStream.range(start, end + 1).forEach(i -> product.multiply(getExpression().run(ANumber.of(i))));
        return product;
    }


    public ANumber getProduct(ANumber start, ANumber end)
    {
        NumberRules.areNotNull(start, end);
        return getProduct(start.getAsInt(), end.getAsInt());
    }
}