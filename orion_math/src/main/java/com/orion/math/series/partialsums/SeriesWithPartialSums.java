package com.orion.math.series.partialsums;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.series.Series;
import java.util.stream.IntStream;

public class SeriesWithPartialSums extends Series
{
    public SeriesWithPartialSums(Function1x1IF<ANumber, ANumber> expression)
    {
        SeriesWithPartialSumsRules.isValid(expression);
        setExpression(expression);
    }


    public static SeriesWithPartialSums of(Function1x1IF<ANumber, ANumber> expression)
    {
        return new SeriesWithPartialSums(expression);
    }


    public ANumber getSum(int start, int end)
    {
        NumberRules.isLessThan(start, end);
        ANumber sum = ANumber.of(0);
        IntStream.range(start, end + 1).forEach(i -> sum.add(getExpression().run(ANumber.of(i))));
        return sum;
    }


    public ANumber getSum(ANumber start, ANumber end)
    {
        NumberRules.areNotNull(start, end);
        return getSum(start.getAsInt(), end.getAsInt());
    }
}