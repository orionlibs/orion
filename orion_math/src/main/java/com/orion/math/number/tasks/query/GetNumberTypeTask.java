package com.orion.math.number.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.NumberType;
import com.orion.math.number.Numbers;

public class GetNumberTypeTask extends Orion
{
    public static NumberType run(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(Numbers.hasImaginaryValue(x))
        {
            return NumberType.ComplexNumber;
        }
        else if(Numbers.hasIntegerValue(x))
        {

            if(Numbers.isGreaterThan(x, 0))
            {
                return NumberType.NaturalNumber;
            }
            else
            {
                return NumberType.IntegerNumber;
            }

        }
        else if(Numbers.hasDecimalValue(x))
        {
            return NumberType.RealNumber;
        }

        return NumberType.RealNumber;
    }
}