package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;
import java.math.BigDecimal;

public class GetNumberOfDecimalDigitsOfNumberTask extends Orion
{
    public static int run(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        return x.stripTrailingZeros().scale();
    }


    public static int run(BigDecimal x, int precision)
    {
        NumberRules.isNotNull(x);
        String valueTemp = x.stripTrailingZeros().toPlainString();

        if(Numbers.hasDecimalPoint(valueTemp))
        {
            return Math.min(valueTemp.substring(valueTemp.indexOf(".") + 1).length(), Precision.getValidPrecision(precision));
        }

        return 0;
    }


    public static int run(String x)
    {
        NumberRules.isNotNull(x);

        if(Numbers.hasDecimalPoint(x))
        {
            return x.substring(x.indexOf(".") + 1).length();
        }

        return 0;
    }
}