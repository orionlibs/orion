package com.orion.math.calculus.integral;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.constant.Constants;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.interval.Interval;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class IntegrationServiceTest
{
    @Test
    public void testIntegrate1()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ANumber.of(2).multiplyGET(x));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of(8);
        ANumber result = IntegrationService.integrate(f, Interval.of(1, 3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void testIntegrate2()
    {
        Function1x1IF<ANumber, ANumber> func = (ANumber x) -> (ArithmeticService.getEToThePowerOf(x.squareGET().halfGET().negateGET()).divideGET(Constants.twoPI.getSquareRoot()));
        Function1x1<ANumber, ANumber> f = Function1x1.of(func);
        ANumber expected = ANumber.of("0.99729820978444057172995109310733916594250079209903");
        ANumber result = IntegrationService.integrate(f, Interval.of(-3, 3));
        assertTrue(expected.equal(result));
    }


    @Test
    public void testIntegrate3()
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = (ANumber x, ANumber y) -> (ANumber.of(2).multiplyGET(x).multiplyGET(y));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(func);
        Interval intervalForX = Interval.of(1, 3);
        ANumber expected = ANumber.of(32);
        ANumber result = IntegrationService.integrate(f, intervalForX, ANumber.of(4));
        assertTrue(expected.equal(result));
    }


    @Test
    public void testIntegrate4()
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = (ANumber x, ANumber y) -> (ANumber.of(2).multiplyGET(x).multiplyGET(y));
        Function2x1<ANumber, ANumber, ANumber> f = Function2x1.of(func);
        Interval intervalForY = Interval.of(1, 3);
        ANumber expected = ANumber.of(32);
        ANumber result = IntegrationService.integrate(f, ANumber.of(4), intervalForY);
        assertTrue(expected.equal(result));
    }
}