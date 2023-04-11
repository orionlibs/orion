package com.orion.math.function.fourvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;

public class SubtractFunctions4x1Task extends Orion
{
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> g)
    {
        FunctionRules.areValid(f, g);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> function = (x, y, z, w) ->
        {
            return f.run(x, y, z, w).subtractGET(g.run(x, y, z, w));
        };
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(function);
    }
}