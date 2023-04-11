package com.orion.machine_learning.hypothesis;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

public class HypothesisTest
{
    @Test
    public void testHypothesisClass()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> x.multiplyGET(4);
        Hypothesis<ANumber> hypothesis = Hypothesis.of(func);
        assertTrue(hypothesis.run(new Object[]
        {ANumber.of(2)}).equal(ANumber.of(8)));
    }


    @Test
    public void testHypothesisClass2()
    {
        Function1x1<ANumber, ANumber> func = Function1x1.of((ANumber x) -> x.multiplyGET(4));
        Hypothesis<ANumber> hypothesis = Hypothesis.of(func);
        assertTrue(hypothesis.run(new Object[]
        {ANumber.of(2)}).equal(ANumber.of(8)));
    }


    @Test
    public void testHypothesisClass3()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> x.multiplyGET(4);
        Hypothesis<ANumber> hypothesis = Hypothesis.of(func);
        assertTrue(hypothesis.run(new Object[]
        {ANumber.of(2)}).equal(ANumber.of(8)));
    }


    @Test
    public void testHypothesisClass4()
    {
        Function2x1IF<ANumber, ANumber, String> func = (ANumber x, ANumber y) -> x.multiplyGET(y).toString();
        Hypothesis<String> hypothesis = Hypothesis.of(func);
        assertTrue(hypothesis.run(new Object[]
        {ANumber.of(2), ANumber.of(4)}).equals("8"));
    }


    @Test
    public void testHypothesisClass5()
    {
        FunctionNx1IF<ANumber, String> func = (ANumber[] x) -> x[0].toString() + " + " + x[1].toString();
        Hypothesis<String> hypothesis = Hypothesis.of(func);
        assertTrue(hypothesis.run(new Object[]
        {new ANumber[]
                        {ANumber.of(2), ANumber.of(4)}}).equals("2 + 4"));
    }
}