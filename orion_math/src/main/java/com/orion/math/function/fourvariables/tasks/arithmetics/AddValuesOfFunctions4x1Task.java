package com.orion.math.function.fourvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class AddValuesOfFunctions4x1Task extends Orion
{
    public static ANumber run(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        NumberRules.areNotNull(x, y, z, w);
        FunctionRules.areValid(functions);
        ANumber result = ANumber.of(0);
        Arrays.stream(functions).forEach(f -> result.add(f.run(x, y, z, w)));
        return result;
    }
}