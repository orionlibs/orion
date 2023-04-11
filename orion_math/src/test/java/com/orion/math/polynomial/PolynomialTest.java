package com.orion.math.polynomial;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class PolynomialTest
{
    @Test
    public void testGetPolynomialAsFunction()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(6), ANumber.of(-5), ANumber.of(1)};
        Polynomial polynomial = Polynomial.of(coefficients);
        ANumber result = polynomial.getAsFunction().run(ANumber.of(1.9));
        assertTrue(ANumber.of(0.11).equal(result));
    }


    @Test
    public void testDifferentiate()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(3), ANumber.of(2), ANumber.of(-4), ANumber.of(-7)};
        Polynomial polynomial = Polynomial.of(coefficients);
        ANumber expected = ANumber.of(-563);
        ANumber result = PolynomialService.differentiate(polynomial, ANumber.of(5));
        assertTrue(expected.equal(result));
    }


    @Test
    public void testDivide()
    {
        ANumber[] coefficients1 = new ANumber[]
        {ANumber.of(1), ANumber.of(0), ANumber.of(1)};
        Polynomial polynomial1 = Polynomial.of(coefficients1);
        ANumber[] coefficients2 = new ANumber[]
        {ANumber.of(0), ANumber.of(1)};
        Polynomial polynomial2 = Polynomial.of(coefficients2);
        ANumber[] expectedQuotientCoefficients = new ANumber[]
        {ANumber.of(0), ANumber.of(1)};
        Polynomial expectedQuotient = Polynomial.of(expectedQuotientCoefficients);
        ANumber[] expectedRemainderCoefficients = new ANumber[]
        {ANumber.of(1)};
        Polynomial expectedRemainder = Polynomial.of(expectedRemainderCoefficients);
        Pair<Polynomial, Polynomial> result = PolynomialService.divide(polynomial1, polynomial2);
        assertTrue(expectedQuotient.equals(result.getFirst()));
        assertTrue(expectedRemainder.equals(result.getSecond()));
    }


    @Test
    public void testDivide2()
    {
        ANumber[] coefficients1 = new ANumber[]
        {ANumber.of(-4), ANumber.of(0), ANumber.of(-2), ANumber.of(1)};
        Polynomial polynomial1 = Polynomial.of(coefficients1);
        ANumber[] coefficients2 = new ANumber[]
        {ANumber.of(-3), ANumber.of(1)};
        Polynomial polynomial2 = Polynomial.of(coefficients2);
        ANumber[] expectedQuotientCoefficients = new ANumber[]
        {ANumber.of(3), ANumber.of(1), ANumber.of(1)};
        Polynomial expectedQuotient = Polynomial.of(expectedQuotientCoefficients);
        ANumber[] expectedRemainderCoefficients = new ANumber[]
        {ANumber.of(5)};
        Polynomial expectedRemainder = Polynomial.of(expectedRemainderCoefficients);
        Pair<Polynomial, Polynomial> result = PolynomialService.divide(polynomial1, polynomial2);
        assertTrue(expectedQuotient.equals(result.getFirst()));
        assertTrue(expectedRemainder.equals(result.getSecond()));
    }


    @Test
    public void testGetRootUsingNewtonRaphson5()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(0), ANumber.of(32), ANumber.of(0), ANumber.of(8), ANumber.of(0), ANumber.of(1)};
        Polynomial polynomial = Polynomial.of(coefficients);
        ANumber expected = ANumber.of(0);
        ANumber result = PolynomialService.getRootUsingNewtonRaphson(polynomial, ANumber.of(0.1), 15);
        result.applyPrecision(15);
        assertTrue(expected.equal(result));
    }


    @Test
    public void testGetRootUsingNewtonRaphson6()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(-4), ANumber.of(0), ANumber.of(1)};
        Polynomial polynomial = Polynomial.of(coefficients);
        ANumber expected = ANumber.of(-2);
        ANumber result = PolynomialService.getRootUsingNewtonRaphson(polynomial, ANumber.of(-1.9), 15);
        result.applyPrecision(15);
        assertTrue(expected.equal(result));
    }


    @Test
    public void testGetRootUsingNewtonRaphson7()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(-4), ANumber.of(0), ANumber.of(1)};
        Polynomial polynomial = Polynomial.of(coefficients);
        ANumber expected = ANumber.of(2);
        ANumber result = PolynomialService.getRootUsingNewtonRaphson(polynomial, ANumber.of(1.9), 15);
        result.applyPrecision(15);
        assertTrue(expected.equal(result));
    }


    @Test
    public void testGetRootsUsingNewtonRaphson3()
    {
        ANumber[] coefficients = new ANumber[]
        {ANumber.of(6), ANumber.of(-5), ANumber.of(1)};
        Polynomial polynomial = Polynomial.of(coefficients);
        Interval interval = Interval.of(1, 4);
        ANumber[] expected = new ANumber[]
        {ANumber.of("3.0000348884154425882561953639967092033476418746737870187276570354015"), ANumber.of("2.000005198346704364587093609648994433469157425931765111019736252177309202210448895172616842806623366724285661915070269852707498412210672830586602544310098161263509")};
        ANumber[] result = PolynomialService.getRootsUsingNewtonRaphson(polynomial, interval, 3);
        assertTrue(Arrays.equals(expected, result));
    }
}