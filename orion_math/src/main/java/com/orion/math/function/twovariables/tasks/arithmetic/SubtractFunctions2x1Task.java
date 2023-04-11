package com.orion.math.function.twovariables.tasks.arithmetic;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;

public class SubtractFunctions2x1Task extends Orion
{
    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber> g)
    {
        FunctionRules.areValid(f, g);
        Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y) ->
        {
            return f.run(x, y).subtractGET(g.run(x, y));
        };
        return Function2x1.<ANumber, ANumber, ANumber>of(function);
    }
}