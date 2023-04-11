package com.orion.math.number.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class NumberServiceTest
{
    @Test
    public void testGetDivisors_1()
    {
        ANumber x = ANumber.of(100);
        List<ANumber> divisors = NumberService.getDivisors(x);
        List<ANumber> expected = new ArrayList<ANumber>();
        expected.add(ANumber.of(1));
        expected.add(ANumber.of(2));
        expected.add(ANumber.of(4));
        expected.add(ANumber.of(5));
        expected.add(ANumber.of(10));
        expected.add(ANumber.of(20));
        expected.add(ANumber.of(25));
        expected.add(ANumber.of(50));
        expected.add(ANumber.of(100));
        assertTrue(expected.equals(divisors));
    }


    @Test
    public void testGetDivisors_2()
    {
        ANumber x = ANumber.of(100.5);

        try
        {
            NumberService.getDivisors(x);
        }
        catch(Exception e)
        {
            assertTrue(true);
        }

    }


    @Test
    public void testPrimeDivisors()
    {
        ANumber x = ANumber.of(100);
        List<ANumber> divisors = NumberService.getPrimeDivisors(x);
        List<ANumber> expected = new ArrayList<ANumber>();
        expected.add(ANumber.of(2));
        expected.add(ANumber.of(5));
        assertTrue(expected.equals(divisors));
    }


    @Test
    public void testGreatestCommonDivisor()
    {
        ANumber x = ANumber.of(100);
        ANumber y = ANumber.of(300);
        ANumber gcd = NumberService.getGreatestCommonDivisor(x, y);
        ANumber expected = ANumber.of(100);
        assertTrue(expected.equals(gcd));
    }
}