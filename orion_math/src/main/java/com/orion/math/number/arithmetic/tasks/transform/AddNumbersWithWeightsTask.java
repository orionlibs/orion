package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;
import java.util.stream.IntStream;

public class AddNumbersWithWeightsTask extends Orion
{
    public static ANumber run(List<?> numbers, List<?> weights, boolean checkForNullNumbers)
    {
        NumberRules.isNotNull(numbers);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        NumberRules.doSizesMatch(numbers, weights);
        ANumber sum = ANumber.of(0, 0);
        List<ANumber> numbersTemp = NumberService.getAsNumberList(numbers);
        List<ANumber> weightsTemp = NumberService.getAsNumberList(weights);
        NumberRules.doSizesMatch(numbersTemp, weightsTemp);
        IntStream.range(0, numbers.size()).forEach(i -> sum.add((numbersTemp.get(i)).multiplyGET(weightsTemp.get(i))));
        return sum;
    }


    public static ANumber run(List<?> numbers, List<?> weights, boolean checkForNullNumbers, int precision)
    {
        ANumber result = run(numbers, weights, checkForNullNumbers);
        result.applyPrecision(precision);
        return result;
    }
}