package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;

public class AddNumbersTask extends Orion
{
    public static ANumber run(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotNull(numbers);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber sum = ANumber.of(0, 0);
        NumberService.getAsNumberList(numbers).forEach(x -> sum.add(x));
        return sum;
    }


    public static ANumber run(List<?> numbers, boolean checkForNullNumbers, int precision)
    {
        ANumber result = run(numbers, checkForNullNumbers);
        result.applyPrecision(precision);
        return result;
    }
}