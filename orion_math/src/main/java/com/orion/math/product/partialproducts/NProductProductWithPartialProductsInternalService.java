package com.orion.math.product.partialproducts;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.product.partialproducts.tasks.GetProductOfNProductProductWithPartialProductsTask;
import java.util.List;

class NProductProductWithPartialProductsInternalService extends OrionService
{
    static ANumber getProduct(FunctionNx1IF<ANumber, ANumber> expression, List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        return new GetProductOfNProductProductWithPartialProductsTask().run(expression, pairsOfStartAndEndIndices);
    }
}