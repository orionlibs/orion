package com.orion.math.statistics.regression.linear.multiple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class MultipleLinearRegressionTest
{
    @Test
    public void testMultipleLinearRegression()
    {
        Pair<Vector, ANumber> p1 = Pair.of(Vector.of(ANumber.of(1), ANumber.of(1.1)), ANumber.of(1));
        Pair<Vector, ANumber> p2 = Pair.of(Vector.of(ANumber.of(2), ANumber.of(2.1)), ANumber.of(2));
        Pair<Vector, ANumber> p3 = Pair.of(Vector.of(ANumber.of(3), ANumber.of(3.1)), ANumber.of(1.3));
        Pair<Vector, ANumber> p4 = Pair.of(Vector.of(ANumber.of(4), ANumber.of(4.1)), ANumber.of(3.75));
        Pair<Vector, ANumber> p5 = Pair.of(Vector.of(ANumber.of(5), ANumber.of(5.1)), ANumber.of(2.25));
        MultipleLinearRegression multipleLinearRegression = MultipleLinearRegression.of(MultifeatureTrainingSet.of(Arrays.asList(p1, p2, p3, p4, p5)));
        ANumber expected1 = ANumber.of("1.20999999984212454666815109928978132854185483870968");
        ANumber result1 = multipleLinearRegression.getY(Vector.of(ANumber.of(1), ANumber.of(1.1)));
        assertTrue(expected1.equal(result1));
        ANumber expected2 = ANumber.of("4.11999997030282748395652760749245028068835483870968");
        ANumber result2 = multipleLinearRegression.getY(Vector.of(ANumber.of(5), ANumber.of(5.1)));
        assertTrue(expected2.equal(result2));
    }
}