package com.orion.math.number.type;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class ANumberTest
{
    @Test
    public void testSquareGET()
    {
        ANumber result = ANumber.of("0.0000000000000000000000000003").squareGET();
        assertTrue(ANumber.of("0.00000000000000000000000000000000000000000000000000000009").equals(result));
    }


    @Test
    public void testGetSquareRoot()
    {
        ANumber result = ANumber.of("2").getSquareRoot();
        assertTrue(ANumber.of("1.4142135623730951").equals(result));
        result = ANumber.of("2").getSquareRoot(30);
        assertTrue(ANumber.of("1.41421356237309504880168872421").equals(result));
    }
}