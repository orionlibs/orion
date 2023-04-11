package com.orion.core.math.tasks;

import com.orion.core.abstraction.Orion;
import org.apache.commons.lang3.StringUtils;

public class FormatNumberWithRightTrailingZerosTask extends Orion
{
    public static String run(long number, int numberOfTrailingZeros)
    {
        String numberString = Long.toString(number);

        if(numberString.length() < numberOfTrailingZeros)
        {
            return StringUtils.rightPad(numberString, numberOfTrailingZeros, "0");
        }
        else
        {
            return numberString;
        }

    }
}