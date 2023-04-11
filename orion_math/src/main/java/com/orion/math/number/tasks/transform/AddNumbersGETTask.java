package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;

public class AddNumbersGETTask extends Orion
{
    public ANumber run(ANumber x, List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.isNotNull(x);

        if(checkForNullNumbers)
        {
            NumberRules.areNotNull(numbers);
        }

        ANumber temp = x.getCopy();
        List<ANumber> numbersTemp = NumberService.getAsNumberList(numbers);

        for(ANumber y : numbersTemp)
        {
            temp = run(temp, y);
        }

        return temp;
    }


    public ANumber run(ANumber x, List<?> numbers, int precision, boolean checkForNullNumbers)
    {
        ANumber temp = run(x, numbers, checkForNullNumbers);
        temp.applyPrecision(precision);
        return temp;
    }


    public ANumber run(ANumber x, ANumber y)
    {
        ANumber newNumber = x.getCopy();
        newNumber.setRealValue(x.get().add(y.get()));
        newNumber.setImaginaryValue(x.getImaginaryValue().add(y.getImaginaryValue()));
        newNumber.trimZeros();
        return newNumber;
    }


    public ANumber run(ANumber x, ANumber y, int precision)
    {
        ANumber newNumber = run(x, y);
        newNumber.applyPrecision(precision);
        return newNumber;
    }


    public ANumber run(ANumber x, Number y)
    {
        return run(x, ANumber.of(y));
    }


    public ANumber run(ANumber x, Number y, int precision)
    {
        return run(x, ANumber.of(y), precision);
    }
}