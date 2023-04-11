package com.orion.math.series.partialsums;

import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.series.Series;
import java.util.List;

public class NSumSeriesWithPartialSums extends Series
{
    public NSumSeriesWithPartialSums(FunctionNx1IF<ANumber, ANumber> expression)
    {
        SeriesWithPartialSumsRules.isValid(expression);
        setNSumExpression(expression);
    }


    public static NSumSeriesWithPartialSums of(FunctionNx1IF<ANumber, ANumber> expression)
    {
        return new NSumSeriesWithPartialSums(expression);
    }


    public ANumber getSum(List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        return NSumSeriesWithPartialSumsInternalService.getSum(getNSumExpression(), pairsOfStartAndEndIndices);
    }
}