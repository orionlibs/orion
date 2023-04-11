package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.util.List;

public class GetMinimumNumberTask extends Orion
{
    public static ANumber run(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotEmpty(numbers);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber minimum = ANumber.of(0);

        if(Numbers.isNumber(numbers.get(0)))
        {
            minimum = ANumber.of((Number)numbers.get(0));
        }
        else if(Numbers.isAbstractNumber(numbers.get(0)))
        {
            minimum = ((ANumber)numbers.get(0)).getCopy();
        }

        if(numbers.size() > 1)
        {

            for(int i = 1; i < numbers.size(); i++)
            {

                if(Numbers.isNumber(numbers.get(i)) && Numbers.isLessThan((Number)numbers.get(i), minimum))
                {
                    minimum = ANumber.of((Number)numbers.get(i));
                }
                else if(Numbers.isAbstractNumber(numbers.get(i)) && Numbers.isLessThan((ANumber)numbers.get(i), minimum))
                {
                    minimum = ((ANumber)numbers.get(i)).getCopy();
                }

            }

        }

        return minimum;
    }
}