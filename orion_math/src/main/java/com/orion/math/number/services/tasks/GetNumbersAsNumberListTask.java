package com.orion.math.number.services.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.InvalidNumberException;
import com.orion.math.number.Numbers;
import java.util.ArrayList;
import java.util.List;

public class GetNumbersAsNumberListTask extends Orion
{
    public static List<ANumber> run(List<?> numbers)
    {
        List<ANumber> numbersTemp = new ArrayList<ANumber>();

        for(Object x : numbers)
        {

            if(Numbers.isNumber(x))
            {
                numbersTemp.add(ANumber.of((Number)x, 0));
            }
            else if(Numbers.isAbstractNumber(x))
            {
                numbersTemp.add(((ANumber)x).getCopy());
            }
            else if(x instanceof String)
            {

                try
                {
                    numbersTemp.add(ANumber.of((String)x));
                }
                catch(InvalidNumberException e)
                {
                }

            }

        }

        return numbersTemp;
    }
}