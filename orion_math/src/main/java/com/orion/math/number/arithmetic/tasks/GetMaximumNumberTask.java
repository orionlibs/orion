package com.orion.math.number.arithmetic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import java.util.List;

public class GetMaximumNumberTask extends Orion
{
    public static ANumber run(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotEmpty(numbers);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber maximum = ANumber.of(0);

        if(Numbers.isNumber(numbers.get(0)))
        {
            maximum = ANumber.of((Number)numbers.get(0));
        }
        else if(Numbers.isAbstractNumber(numbers.get(0)))
        {
            maximum = ((ANumber)numbers.get(0)).getCopy();
        }

        if(numbers.size() > 1)
        {

            for(int i = 1; i < numbers.size(); i++)
            {

                if(Numbers.isNumber(numbers.get(i)) && Numbers.isGreaterThan((Number)numbers.get(i), maximum))
                {
                    maximum = ANumber.of((Number)numbers.get(i));
                }
                else if(Numbers.isAbstractNumber(numbers.get(i)) && Numbers.isGreaterThan((ANumber)numbers.get(i), maximum))
                {
                    maximum = ((ANumber)numbers.get(i)).getCopy();
                }

            }

        }

        return maximum;
    }
}