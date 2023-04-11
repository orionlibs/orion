package com.orion.math.number.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.math.BigDecimal;

public class IsNumberBetween2OthersTask extends Orion
{
    public static boolean run(Object x, Object minimum, Object maximum)
    {
        NumberRules.isNotNull(x);
        NumberRules.isNotNull(minimum);
        NumberRules.isNotNull(maximum);
        BigDecimal xTemp = null;
        BigDecimal minimumTemp = null;
        BigDecimal maximumTemp = null;

        if(Numbers.isNumber(x))
        {
            xTemp = new BigDecimal(((Number)x).toString());
        }
        else if(Numbers.isAbstractNumber(x))
        {
            xTemp = ((ANumber)x).get();
        }

        if(Numbers.isNumber(minimum))
        {
            minimumTemp = new BigDecimal(((Number)minimum).toString());
        }
        else if(Numbers.isAbstractNumber(minimum))
        {
            minimumTemp = ((ANumber)minimum).get();
        }

        if(Numbers.isNumber(maximum))
        {
            maximumTemp = new BigDecimal(((Number)maximum).toString());
        }
        else if(Numbers.isAbstractNumber(maximum))
        {
            maximumTemp = ((ANumber)maximum).get();
        }

        minimumTemp = ArithmeticService.getMinimum(minimumTemp, maximumTemp).get();
        maximumTemp = ArithmeticService.getMaximum(minimumTemp, maximumTemp).get();
        return xTemp.compareTo(minimumTemp) >= 0 && xTemp.compareTo(maximumTemp) <= 0;
    }
}