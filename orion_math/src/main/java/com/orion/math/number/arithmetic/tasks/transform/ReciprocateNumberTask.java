package com.orion.math.number.arithmetic.tasks.transform;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class ReciprocateNumberTask extends OrionService
{
    public static void run(ANumber x)
    {
        NumberRules.isNonZero(x);

        if(x.isComplexNumber())
        {
            ANumber modulusSquared = x.getModulus().squareGET();
            ANumber newRealValue = x.getAsANumber().divideGET(modulusSquared);
            ANumber newImaginaryValue = x.getImaginaryValueAsANumber().negateGET().divideGET(modulusSquared);
            x.setNewValues(newRealValue, newImaginaryValue);
        }
        else
        {
            x.setNewValues(ANumber.of(1).divideGET(x), ANumber.of(0));
        }

    }
}