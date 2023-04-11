package com.orion.math.function.fourvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class MultiplyValuesOfFunctions4x1Task extends Orion
{
    public static ANumber run(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        NumberRules.areNotNull(x, y, z, w);
        FunctionRules.areValid(functions);
        final ANumber result = ANumber.of(1);
        Arrays.stream(functions).forEach(f -> result.multiply(f.run(x, y, z, w)));
        return result;
    }
}