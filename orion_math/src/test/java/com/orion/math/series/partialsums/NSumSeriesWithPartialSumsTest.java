package com.orion.math.series.partialsums;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class NSumSeriesWithPartialSumsTest
{
    @Test
    public void nSumSeriesWithPartialSums1()
    {
        FunctionNx1IF<ANumber, ANumber> formula = (ANumber[] x) -> (x[0].multiplyGET(x[1]));
        NSumSeriesWithPartialSums sum = NSumSeriesWithPartialSums.of(formula);
        List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices = new ArrayList<Pair<ANumber, ANumber>>();
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(1), ANumber.of(4)));
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(1), ANumber.of(3)));
        ANumber result = sum.getSum(pairsOfStartAndEndIndices);
        assertTrue(ANumber.of(60).equal(result));
    }


    @Test
    public void nSumSeriesWithPartialSums2()
    {
        FunctionNx1IF<ANumber, ANumber> formula = (ANumber[] x) -> (x[0].squareGET());
        NSumSeriesWithPartialSums sum = NSumSeriesWithPartialSums.of(formula);
        List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices = new ArrayList<Pair<ANumber, ANumber>>();
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(50), ANumber.of(100)));
        ANumber result = sum.getSum(pairsOfStartAndEndIndices);
        assertTrue(ANumber.of(297925).equal(result));
    }


    @Test
    public void nSumSeriesWithPartialSums3()
    {
        FunctionNx1IF<ANumber, ANumber> formula = (ANumber[] x) -> (x[0].multiplyGET(x[1]).multiplyGET(x[2]));
        NSumSeriesWithPartialSums sum = NSumSeriesWithPartialSums.of(formula);
        List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices = new ArrayList<Pair<ANumber, ANumber>>();
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(1), ANumber.of(4)));
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(1), ANumber.of(3)));
        pairsOfStartAndEndIndices.add(Pair.of(ANumber.of(1), ANumber.of(1)));
        ANumber result = sum.getSum(pairsOfStartAndEndIndices);
        assertTrue(ANumber.of(60).equal(result));
    }
}