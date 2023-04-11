package com.orion.math.series.partialsums;

import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.series.Series;
import java.util.stream.IntStream;

public class DoubleSeriesWithPartialSums extends Series
{
    public DoubleSeriesWithPartialSums(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        SeriesWithPartialSumsRules.isValid(expression);
        setDoubleSumExpression(expression);
    }


    public static DoubleSeriesWithPartialSums of(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        return new DoubleSeriesWithPartialSums(expression);
    }


    public ANumber getSum(int startOfSum1, int endOfSum1, int startOfSum2, int endOfSum2)
    {
        NumberRules.isLessThan(startOfSum1, endOfSum1);
        NumberRules.isLessThan(startOfSum2, endOfSum2);
        ANumber sum = ANumber.of(0);
        IntStream.range(startOfSum1, endOfSum1 + 1).forEach(i ->
        {
            IntStream.range(startOfSum2, endOfSum2 + 1).forEach(j -> sum.add(getDoubleSumExpression().run(ANumber.of(i), ANumber.of(j))));
        });
        return sum;
    }
}