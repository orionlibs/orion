package com.orion.core.math.tasks;

import com.orion.core.abstraction.Orion;

public class FormatNumberWithLeftTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        return String.format("%0" + numberOfTrailingZeros + "d", number);
    }
}