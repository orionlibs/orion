package com.orion.math.number.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class SubtractNumbersGETTask extends Orion
{
    public ANumber run(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        ANumber newNumber = x.getCopy();
        newNumber.setRealValue(x.get().subtract(y.get()));
        newNumber.setImaginaryValue(x.getImaginaryValue().subtract(y.getImaginaryValue()));
        newNumber.trimZeros();
        return newNumber;
    }


    public ANumber run(ANumber x, Number y)
    {
        NumberRules.areNotNull(x, y);
        return run(x, ANumber.of(y));
    }
}