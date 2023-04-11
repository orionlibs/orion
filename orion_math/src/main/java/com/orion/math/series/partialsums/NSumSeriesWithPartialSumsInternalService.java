package com.orion.math.series.partialsums;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.series.partialsums.tasks.GetSumOfNSumSeriesWithPartialSumsTask;
import java.util.List;

class NSumSeriesWithPartialSumsInternalService extends OrionService
{
    static ANumber getSum(FunctionNx1IF<ANumber, ANumber> expression, List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        return new GetSumOfNSumSeriesWithPartialSumsTask().run(expression, pairsOfStartAndEndIndices);
    }
}