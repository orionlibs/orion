package com.orion.math.function.threevariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class AddValuesOfFunctions3x1Task extends Orion
{
    public static ANumber run(ANumber x, ANumber y, ANumber z, Function3x1<ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        NumberRules.areNotNull(x, y, z);
        FunctionRules.areValid(functions);
        ANumber result = ANumber.of(0);
        Arrays.stream(functions).forEach(f -> result.add(f.run(x, y, z)));
        return result;
    }
}