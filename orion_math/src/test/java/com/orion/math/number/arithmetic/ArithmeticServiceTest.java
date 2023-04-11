package com.orion.math.number.arithmetic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class ArithmeticServiceTest
{
    @Test
    public void testUnlimitedPrecision1()
    {
        BigDecimal x = new BigDecimal("0.0000000000000000000000000000000000004", MathContext.UNLIMITED);
        BigDecimal y = new BigDecimal("0.2", MathContext.UNLIMITED);
        BigDecimal result = x.add(y);
        assertTrue(result.toPlainString().equals("0.2000000000000000000000000000000000004"));
    }


    @Test
    public void testUnlimitedPrecision2()
    {
        BigDecimal x = new BigDecimal("0.0000000000000000000000000000000000004");
        BigDecimal y = new BigDecimal("0.2");
        BigDecimal result = x.add(y);
        assertTrue(result.toPlainString().equals("0.2000000000000000000000000000000000004"));
    }


    @Test
    public void testAddition_AddGET()
    {
        ANumber result = ArithmeticService.addGET(ANumber.of(4), ANumber.of("0.000000000000000000000000000000000000001"));
        assertTrue(ANumber.of("4.000000000000000000000000000000000000001").equals(result));
    }


    @Test
    public void testAddition_AddGET2()
    {
        ANumber x = ANumber.of(4);
        List<ANumber> numbers = new ArrayList<ANumber>();
        numbers.add(ANumber.of("0.00000000000000000000000000001"));
        numbers.add(ANumber.of("0.00000000000000000000000000001"));
        numbers.add(ANumber.of("0.00000000000000000000000000001"));
        ANumber result = x.addGET(numbers, 30, true);
        assertTrue(ANumber.of("4.00000000000000000000000000003").equals(result));
    }


    @Test
    public void testDivision_DivideGET()
    {
        ANumber result = ArithmeticService.divideGET(ANumber.of(4), ANumber.of("0.000000000000000000000000001"));
        assertTrue(ANumber.of("4000000000000000000000000000").equals(result));
    }


    @Test
    public void testMultiplication_MultiplyGET()
    {
        ANumber result = ArithmeticService.multiplyGET(ANumber.of(4), ANumber.of("0.0000000000000000000000000000000000001"));
        assertTrue(ANumber.of("0.0000000000000000000000000000000000004").equals(result));
    }


    @Test
    public void testSubtraction_SubtractGET()
    {
        ANumber result = ArithmeticService.subtractGET(ANumber.of("4.0000000000000000000000000000000000001"), ANumber.of(4));
        assertTrue(ANumber.of("0.0000000000000000000000000000000000001").equals(result));
    }


    @Test
    public void testReciprocateGET()
    {
        ANumber result = ArithmeticService.reciprocateGET(ANumber.of("8888888888888888888888888888888"));
        assertTrue(ANumber.of("0.0000000000000000000000000000001125").equals(result));
    }


    @Test
    public void divideAndRemainder()
    {
        DivisionResult result = ArithmeticService.divideAndRemainder(ANumber.of(5), 2);
        assertTrue(result.getQuotient().equal(ANumber.of(2)));
        assertTrue(result.getRemainder().equal(ANumber.of(1)));
    }
}