package com.orion.math.primenumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class PrimeNumberServiceTest
{
    @Test
    public void testIsPrimeNumber_1()
    {
        ANumber x = ANumber.of(101);
        PrimeNumberService.isPrimeNumber(x);
        assertTrue(PrimeNumberService.isPrimeNumber(x));
    }


    @Test
    public void testIsPrimeNumber_2()
    {
        ANumber x = ANumber.of(102);
        PrimeNumberService.isPrimeNumber(x);
        assertFalse(PrimeNumberService.isPrimeNumber(x));
    }


    @Test
    public void testAreRelativePrimeNumbers_1()
    {
        ANumber x = ANumber.of(10);
        ANumber y = ANumber.of(17);
        assertTrue(PrimeNumberService.areRelativePrimeNumbers(x, y));
    }


    @Test
    public void testAreRelativePrimeNumbers_2()
    {
        ANumber x = ANumber.of(10);
        ANumber y = ANumber.of(20);
        assertFalse(PrimeNumberService.areRelativePrimeNumbers(x, y));
    }


    @Test
    public void testGetPrimeNumbersBelow()
    {
        ANumber x = ANumber.of(20);
        List<ANumber> primes = PrimeNumberService.getPrimeNumbersBelow(x);
        List<ANumber> expected = new ArrayList<ANumber>();
        expected.add(ANumber.of(2));
        expected.add(ANumber.of(3));
        expected.add(ANumber.of(5));
        expected.add(ANumber.of(7));
        expected.add(ANumber.of(11));
        expected.add(ANumber.of(13));
        expected.add(ANumber.of(17));
        expected.add(ANumber.of(19));
        assertTrue(expected.equals(primes));
    }
}