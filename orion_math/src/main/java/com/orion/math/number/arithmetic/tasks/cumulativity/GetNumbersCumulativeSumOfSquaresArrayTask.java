package com.orion.math.number.arithmetic.tasks.cumulativity;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.List;

public class GetNumbersCumulativeSumOfSquaresArrayTask extends Orion
{
    public static ANumber[] run(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        ANumber[] sum = new ANumber[numbers.size()];

        for(int i = 0; i < numbers.size(); i++)
        {

            if(i == 0)
            {
                sum[i] = numbers.get(i).squareGET();
            }
            else
            {
                sum[i] = sum[i - 1].addGET(numbers.get(i).squareGET());
            }

        }

        return sum;
    }
}