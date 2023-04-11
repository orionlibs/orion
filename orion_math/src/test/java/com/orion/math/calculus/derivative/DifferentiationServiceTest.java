package com.orion.math.calculus.derivative;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class DifferentiationServiceTest
{
    @Test
    public void differentiateUsingNumericalDifferentiation1()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ANumber.of(2).multiplyGET(x));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of(2);
        ANumber result = DifferentiationService.differentiate(f, ANumber.of(5));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation2()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ANumber.of(2).multiplyGET(x.squareGET()));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("20.00000000000001");
        ANumber result = DifferentiationService.differentiate(f, ANumber.of(5));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation3()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ArithmeticService.getEToThePowerOf(x));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("7.389052");
        ANumber result = DifferentiationService.differentiate(f, ANumber.of(2), 20);
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation4()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ArithmeticService.getEToThePowerOf(x.squareGET().halfGET()));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("14.77811219798");
        ANumber result = DifferentiationService.differentiate(f, ANumber.of(2));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation5()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (x.exponentiateGET(4).doubleGET());
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("96.00000000000036");
        ANumber result = DifferentiationService.differentiate(f, 3, ANumber.of(2));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation6()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ANumber.of(3).multiplyGET(x.exponentiateGET(7)));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("20160.000000000302400000000001618800000000003118");
        ANumber result = DifferentiationService.differentiate(f, 4, ANumber.of(2));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiateUsingNumericalDifferentiation7()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (x.getSine());
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of(1);
        ANumber result = DifferentiationService.differentiate(f, ANumber.of(0));
        assertTrue(expected.equal(result));
    }


    @Test
    public void differentiate()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (x.getSine());
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of(1);
        ANumber result = DifferentiationService.differentiate(f).run(ANumber.of(0));
        assertTrue(expected.equal(result));
    }


    @Test
    public void testGetPartialDerivativeOnX_Function2x1With1Constant()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (ANumber.of(4).multiplyGET(x).addGET(y.doubleGET()));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of(4);
        Function2x1<ANumber, ANumber, ANumber> result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(1));
        assertTrue(expected.equal(result.run(ANumber.of(6), ANumber.of(3))));
        assertTrue(expected.equal(result.run(ANumber.of(-2), ANumber.of(3))));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (ANumber.of(4).multiplyGET(x).addGET(y.doubleGET()));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of(4);
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(1)).run(ANumber.of(2), ANumber.of(1));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnY_Function2x1With1Constant2()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (ANumber.of(4).multiplyGET(x).addGET(y.doubleGET()));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(0);
        ANumber expected = ANumber.of(2);
        ANumber result = DifferentiationService.getPartialDerivativeOnY(f, ANumber.of(1)).run(ANumber.of(2), ANumber.of(1));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant2()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (x.multiplyGET(y.squareGET()));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of(16);
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(4)).run(ANumber.of(2), ANumber.of(3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant3()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (y.squareGET());
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of(0);
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(1)).run(ANumber.of(2), ANumber.of(3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant4()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (x.squareGET().multiplyGET(y.exponentiateGET(3)));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of("32.00000000000004");
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(2)).run(ANumber.of(2), ANumber.of(3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant5()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (x.exponentiateGET(3).multiplyGET(y.exponentiateGET(4)));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of("12.00000000000003");
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(1), 15, 2).run(ANumber.of(2), ANumber.of(3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_Function2x1With1Constant6()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (x.addGET(y));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(temp);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of(1);
        ANumber result = DifferentiationService.getPartialDerivativeOnX(f, ANumber.of(1)).run(ANumber.of(2), ANumber.of(3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void getPartialDerivativeOnX_FunctionNx1_1()
    {
        FunctionNx1IF<ANumber, ANumber> temp = (ANumber[] variables) -> (variables[0].squareGET());
        FunctionNx1 f = FunctionNx1.of(temp, 1);
        ANumber expected = ANumber.of("60.000000000000006");
        FunctionNx1 result = DifferentiationService.getPartialDerivative(f, new ANumber[0]);
        assertTrue(expected.equal(result.run(new ANumber[]
        {ANumber.of(30)})));
    }


    @Test
    public void getPartialDerivativeOnX_FunctionNx1_2()
    {
        FunctionNx1IF<ANumber, ANumber> temp = (ANumber[] variables) -> (variables[0].squareGET().addGET(variables[1]));
        FunctionNx1 f = FunctionNx1.of(temp, 2);
        f.setIndexOfVariableAsConstant(1);
        ANumber expected = ANumber.of("60.000000000000006");
        FunctionNx1 result = DifferentiationService.getPartialDerivative(f, new ANumber[]
        {ANumber.ofNaN(), ANumber.of(0)});
        assertTrue(expected.equal(result.run(new ANumber[]
        {ANumber.of(30), ANumber.of(20)})));
    }
}