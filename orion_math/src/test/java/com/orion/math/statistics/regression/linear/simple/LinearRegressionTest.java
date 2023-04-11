package com.orion.math.statistics.regression.linear.simple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class LinearRegressionTest
{
    @Test
    public void testLinearRegression()
    {
        Pair<ANumber, ANumber> p1 = Pair.of(ANumber.of(1), ANumber.of(1));
        Pair<ANumber, ANumber> p2 = Pair.of(ANumber.of(2), ANumber.of(2));
        Pair<ANumber, ANumber> p3 = Pair.of(ANumber.of(3), ANumber.of(1.3));
        Pair<ANumber, ANumber> p4 = Pair.of(ANumber.of(4), ANumber.of(3.75));
        Pair<ANumber, ANumber> p5 = Pair.of(ANumber.of(5), ANumber.of(2.25));
        SimpleLinearRegression simpleLinearRegression = SimpleLinearRegression.of(UnifeatureTrainingSet.of(Arrays.asList(p1, p2, p3, p4, p5)));
        ANumber expected1 = ANumber.of(1.21);
        ANumber result1 = simpleLinearRegression.getY(1);
        assertTrue(expected1.equal(result1));
        ANumber expected2 = ANumber.of(1.635);
        ANumber result2 = simpleLinearRegression.getY(2);
        assertTrue(expected2.equal(result2));
    }


    @Test
    public void testGetStandardErrorOfIntercept()
    {
        Pair<ANumber, ANumber> p1 = Pair.of(ANumber.of(1), ANumber.of(1));
        Pair<ANumber, ANumber> p2 = Pair.of(ANumber.of(2), ANumber.of(2));
        Pair<ANumber, ANumber> p3 = Pair.of(ANumber.of(3), ANumber.of(1.3));
        Pair<ANumber, ANumber> p4 = Pair.of(ANumber.of(4), ANumber.of(3.75));
        Pair<ANumber, ANumber> p5 = Pair.of(ANumber.of(5), ANumber.of(2.25));
        SimpleLinearRegression simpleLinearRegression = SimpleLinearRegression.of(UnifeatureTrainingSet.of(Arrays.asList(p1, p2, p3, p4, p5)));
        ANumber expected = ANumber.of("1.4832396974191326");
        ANumber result = simpleLinearRegression.getStandardErrorOfIntercept();
        assertTrue(expected.equal(result));
    }
}