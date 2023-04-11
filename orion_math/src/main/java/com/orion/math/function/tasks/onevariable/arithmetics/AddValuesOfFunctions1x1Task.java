package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class AddValuesOfFunctions1x1Task extends Orion
{
    public static ANumber run(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        NumberRules.isNotNull(x);
        FunctionRules.areValid(functions);
        ANumber result = ANumber.of(0);
        Arrays.stream(functions).forEach(f -> result.add(f.run(x)));
        return result;
    }
}