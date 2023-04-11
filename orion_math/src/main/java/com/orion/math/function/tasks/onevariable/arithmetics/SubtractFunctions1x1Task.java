package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class SubtractFunctions1x1Task extends Orion
{
    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> g)
    {
        FunctionRules.areValid(f, g);
        Function1x1IF<ANumber, ANumber> function = (ANumber x) ->
        {
            return f.run(x).subtractGET(g.run(x));
        };
        return Function1x1.<ANumber, ANumber>of(function);
    }
}