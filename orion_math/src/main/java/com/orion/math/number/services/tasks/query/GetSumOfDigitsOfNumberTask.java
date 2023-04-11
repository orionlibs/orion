package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.stream.IntStream;

public class GetSumOfDigitsOfNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);
        ANumber sum = ANumber.of(0);
        char[] digits = x.toString().toCharArray();
        IntStream.range((x.isNegative()) ? 1 : 0, digits.length)
                        .forEach(i -> sum.add(Integer.parseInt(Character.toString(digits[i]))));
        return sum;
    }
}