package com.orion.core.numerical_base.hexadecimal.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class ConvertToHexadecimalBaseTask extends Orion
{
    public static final char[] HEXADECIMAL_DIGITS =
    {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    public static String convertToHexadecimalCode(String data)
    {
        Assert.notNull(data, "data input cannot be null.");
        return run(data.getBytes());
    }


    public static String run(byte[] data)
    {
        Assert.notNull(data, "data input cannot be null.");
        StringBuilder result = new StringBuilder();

        for(int idx = 0; idx < data.length; ++idx)
        {
            byte b = data[idx];
            result.append(HEXADECIMAL_DIGITS[(b & 0xf0) >> 4]);
            result.append(HEXADECIMAL_DIGITS[b & 0x0f]);
        }

        return result.toString();
    }
}