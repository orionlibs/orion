package com.orion.math.series;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.series.analytic.SeriesWithAnalyticForm;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class SeriesTest
{
    @Test
    public void testFunction()
    {
        Function1x1IF<ANumber, ANumber> formula = (ANumber x) -> (x.multiplyGET(x.addOneGET().halfGET()));
        SeriesWithAnalyticForm seriesWithAnalyticForm = SeriesWithAnalyticForm.of(formula);
        ANumber expected = seriesWithAnalyticForm.getSum(ANumber.of(5));
        assertTrue(expected.equal(ANumber.of(15)));
    }
}