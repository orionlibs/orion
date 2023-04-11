package com.orion.math.combinatorics.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;

public class NumberOfCombinationsFunction extends Orion
{
    private static Function2x1<ANumber, ANumber, ANumber> formula;
    static
    {
        Function2x1IF<ANumber, ANumber, ANumber> f = (ANumber n, ANumber r) -> (CombinatoricsService.getNumberOfCombinations(n, r));
        formula = Function2x1.of(f);
    }


    public static ANumber run(ANumber n, ANumber r)
    {
        return formula.run(n, r);
    }


    public static ANumber run(Number n, Number r)
    {
        return formula.run(ANumber.of(n), ANumber.of(r));
    }
}