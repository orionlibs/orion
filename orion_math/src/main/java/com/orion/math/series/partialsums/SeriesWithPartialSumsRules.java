package com.orion.math.series.partialsums;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.function.Functions;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import java.util.List;

public class SeriesWithPartialSumsRules extends MathRule
{
    public static void isValid(Function1x1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Series partial sums function is empty.");
    }


    public static void isValid(Function2x1IF<ANumber, ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Double series partial sums function is empty.");
    }


    public static void isValid(FunctionNx1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "N-sum series partial sums function is empty.");
    }


    public static void isValid(SeriesWithPartialSums seriesWithPartialSums)
    {
        Assert.notNull(seriesWithPartialSums, "The seriesWithPartialSums input cannot be null.");
        isValid(seriesWithPartialSums.getExpression());
    }


    public static void isValid(DoubleSeriesWithPartialSums seriesWithPartialSums)
    {
        Assert.notNull(seriesWithPartialSums, "The seriesWithPartialSums input cannot be null.");
        isValid(seriesWithPartialSums.getDoubleSumExpression());
    }


    public static void isValid(NSumSeriesWithPartialSums seriesWithPartialSums)
    {
        Assert.notNull(seriesWithPartialSums, "The seriesWithPartialSums input cannot be null.");
        isValid(seriesWithPartialSums.getNSumExpression());
    }


    public static void isValid(List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        Assert.hasLengthAtLeast(pairsOfStartAndEndIndices, 1, "The pairsOfStartAndEndIndices input has to have at least 1 pair of start/end indices.");
        pairsOfStartAndEndIndices.forEach(pair -> Assert.notNull(pair, "There is at least one pair of start/end indices that is null"));
    }
}