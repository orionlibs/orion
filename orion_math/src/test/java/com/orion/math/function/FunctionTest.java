package com.orion.math.function;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class FunctionTest
{
    @Test
    public void testFunction()
    {
        Function1x1IF<ANumber, ANumber> temp = (ANumber x) -> (ANumber.of(4).multiplyGET(x));
        Function1x1<ANumber, ANumber> func = new Function1x1<ANumber, ANumber>(temp);
        ANumber expected = ANumber.of(8);
        assertTrue(expected.equal(func.run(ANumber.of(2))));
    }


    @Test
    public void testFunction2x1With1Constant()
    {
        Function2x1IF<ANumber, ANumber, ANumber> temp = (ANumber x, ANumber y) -> (ANumber.of(4).multiplyGET(x).addGET(y.doubleGET()));
        Function2x1<ANumber, ANumber, ANumber> func = new Function2x1<ANumber, ANumber, ANumber>(temp);
        ANumber expected = ANumber.of(14);
        assertTrue(expected.equal(func.run(ANumber.of(2), ANumber.of(3))));
    }


    @Test
    public void testSineFunction()
    {
        ANumber expected = ANumber.of(Math.sin(1));
        assertTrue(expected.equal(Functions.sin.run(ANumber.of(1))));
    }


    @Test
    public void testAverageFunction()
    {
        List<ANumber> numbers = new ArrayList<ANumber>();
        numbers.add(ANumber.of(1));
        numbers.add(ANumber.of(2));
        numbers.add(ANumber.of(3));
        numbers.add(ANumber.of(4));
        numbers.add(ANumber.of(5));
        ANumber expected = ANumber.of(3);
        assertTrue(expected.equal(Functions.avg.run(numbers)));
    }


    @Test
    public void testGreatestCommonDivisorFunction()
    {
        ANumber expected = ANumber.of(3);
        assertTrue(expected.equal(Functions.gcd.run(ANumber.of(6), ANumber.of(9))));
    }


    @Test
    public void testMinimumFunction()
    {
        List<ANumber> numbers = new ArrayList<ANumber>();
        numbers.add(ANumber.of(8));
        numbers.add(ANumber.of(2));
        numbers.add(ANumber.of(3));
        numbers.add(ANumber.of(4));
        numbers.add(ANumber.of(5));
        ANumber expected = ANumber.of(2);
        assertTrue(expected.equal(Functions.min.run(numbers)));
    }


    @Test
    public void testGetAsPolynomial()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ANumber.of(4).multiplyGET(x));
        Function1x1<ANumber, ANumber> f = new Function1x1<ANumber, ANumber>(func);
        ANumber expected = ANumber.of(8);
        Polynomial result = f.getAsPolynomial(Interval.of(-5, 5), 6);
        assertTrue(expected.equal(result.getValueFor(ANumber.of(2))));
    }


    @Test
    public void test_getRunMethodOfFunction()
    {
        Function1x1IF<List<ANumber>, ANumber> func1 = (List<ANumber> x) -> (ArithmeticService.add(x));
        Function1x1<List<ANumber>, ANumber> f1 = Function1x1.of(func1);
        Method result = Functions.getRunMethod(f1.getFunction());
        assertTrue("run".equals(result.getName()));
    }


    @Test
    public void getInverse1()
    {
        FunctionDomain1x1 domain = FunctionDomain1x1.of(Interval.of(-5, 5));
        FunctionCodomain codomain = FunctionCodomain.of(Interval.of(-5, 5));
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (x);
        Function1x1<ANumber, ANumber> f = new Function1x1<ANumber, ANumber>(func, domain, codomain);
        Function1x1<ANumber, ANumber> result = f.getInverse();
        assertTrue(ANumber.of(-3).equal(result.run(ANumber.of(-3))));
        assertTrue(ANumber.of(-1).equal(result.run(ANumber.of(-1))));
        assertTrue(ANumber.of(0).equal(result.run(ANumber.of(0))));
        assertTrue(ANumber.of(1).equal(result.run(ANumber.of(1))));
        assertTrue(ANumber.of(2).equal(result.run(ANumber.of(2))));
        assertTrue(ANumber.of(5).equal(result.run(ANumber.of(5))));
    }


    @Test
    public void getInverse2()
    {
        FunctionDomain1x1 domain = FunctionDomain1x1.of(Interval.of(-5, 5));
        FunctionCodomain codomain = FunctionCodomain.of(Interval.of(-5, 5));
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (x.doubleGET());
        Function1x1<ANumber, ANumber> f = new Function1x1<ANumber, ANumber>(func, domain, codomain);
        Function1x1<ANumber, ANumber> result = f.getInverse();
        assertTrue(ANumber.of(-1.5).equal(result.run(ANumber.of(-3))));
        assertTrue(ANumber.of(-0.5).equal(result.run(ANumber.of(-1))));
        assertTrue(ANumber.of(0).equal(result.run(ANumber.of(0))));
        assertTrue(ANumber.of(0.5).equal(result.run(ANumber.of(1))));
        assertTrue(ANumber.of(1).equal(result.run(ANumber.of(2))));
        assertTrue(ANumber.of(2.5).equal(result.run(ANumber.of(5))));
    }


    @Test
    public void compose1()
    {
        Function1x1IF<ANumber, ANumber> func1 = (ANumber x) -> (x.doubleGET().addGET(3));
        Function1x1<ANumber, ANumber> f1 = new Function1x1<ANumber, ANumber>(func1);
        Function1x1IF<ANumber, ANumber> func2 = (ANumber x) -> (x.multiplyGET(3).addGET(2));
        Function1x1<ANumber, ANumber> f2 = new Function1x1<ANumber, ANumber>(func2);
        Function1x1<ANumber, ANumber> result = f1.compose(f2);
        assertTrue(ANumber.of(7).equal(result.run(ANumber.of(0))));
        assertTrue(ANumber.of(13).equal(result.run(ANumber.of(1))));
        assertTrue(ANumber.of(19).equal(result.run(ANumber.of(2))));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void compose2()
    {
        Function1x1IF<ANumber, ANumber> func1 = (ANumber x) -> (x.doubleGET().addGET(3));
        Function1x1<ANumber, ANumber> f1 = new Function1x1<ANumber, ANumber>(func1);
        Function1x1IF<ANumber, ANumber> func2 = (ANumber x) -> (x.multiplyGET(3).addGET(2));
        Function1x1<ANumber, ANumber> f2 = new Function1x1<ANumber, ANumber>(func2);
        Function1x1IF<ANumber, ANumber> func3 = (ANumber x) -> (x.addGET(2));
        Function1x1<ANumber, ANumber> f3 = new Function1x1<ANumber, ANumber>(func3);
        Function1x1<ANumber, ANumber> result = f1.compose(new Function1x1[]
        {f2, f3});
        assertTrue(ANumber.of(19).equal(result.run(ANumber.of(0))));
        assertTrue(ANumber.of(25).equal(result.run(ANumber.of(1))));
        assertTrue(ANumber.of(31).equal(result.run(ANumber.of(2))));
        assertTrue(ANumber.of(22).equal(result.integrate(Interval.of(0, 1))));
    }


    @Test
    public void testFunction_getSquareRoot()
    {
        Function1x1IF<ANumber, ANumber> temp = (ANumber x) -> (x);
        Function1x1<ANumber, ANumber> func = new Function1x1<ANumber, ANumber>(temp);
        Function1x1<ANumber, ANumber> result = func.getSquareRoot();
        assertTrue(ANumber.of(1).equal(result.run(ANumber.of(1))));
        assertTrue(ANumber.of("1.4142135623730951").equal(result.run(ANumber.of(2))));
        assertTrue(ANumber.of(2).equal(result.run(ANumber.of(4))));
    }
}