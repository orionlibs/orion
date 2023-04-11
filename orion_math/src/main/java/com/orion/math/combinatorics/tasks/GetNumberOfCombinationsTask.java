package com.orion.math.combinatorics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.Functions;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetNumberOfCombinationsTask extends Orion
{
    public static ANumber run(ANumber n, ANumber r)
    {
        NumberRules.areNotNull(n, r);
        NumberRules.haveNaturalNumberValue(n, r);
        NumberRules.isGreaterThanOrEqual(n, r);
        ANumber nFactorial = Functions.factorial.run(n);
        ANumber rFactorial = Functions.factorial.run(r);
        ANumber nMinusRFactorial = Functions.factorial.run(n.subtractGET(r));
        return nFactorial.divideGET(rFactorial.multiplyGET(nMinusRFactorial));
    }
}