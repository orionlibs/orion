package com.orion.math.function.threevariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;

public class SubtractFunctions3x1Task extends Orion
{
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber> g)
    {
        FunctionRules.areValid(f, g);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (x, y, z) ->
        {
            return f.run(x, y, z).subtractGET(g.run(x, y, z));
        };
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
    }
}