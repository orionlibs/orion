package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;

public class MultiplyNumbersTask extends Orion
{
    public ANumber run(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotNull(numbers);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber product = ANumber.of(1, 0);
        NumberService.getAsNumberList(numbers).forEach(x -> product.multiply(x));
        return product;
    }


    public ANumber run(List<?> numbers, boolean checkForNullNumbers, int precision)
    {
        ANumber result = run(numbers, checkForNullNumbers);
        result.applyPrecision(precision);
        return result;
    }
}