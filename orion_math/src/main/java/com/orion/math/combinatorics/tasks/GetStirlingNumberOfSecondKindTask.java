package com.orion.math.combinatorics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.function.Functions;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetStirlingNumberOfSecondKindTask<T> extends Orion
{
    public static ANumber run(ANumber n, ANumber j)
    {
        NumberRules.haveNaturalNumberValue(n, j);
        NumberRules.isLessThanOrEqual(j, n);
        ANumber a = ANumber.of(1).divideGET(Functions.factorial.run(j));
        ANumber sum = ANumber.of(0);

        for(int i = 0; i < j.getAsInt(); i++)
        {
            ANumber b = ANumber.of(-1).exponentiateGET(i);
            ANumber c = CombinatoricsService.getNumberOfCombinations(j, ANumber.of(i));
            ANumber d = j.subtractGET(i).exponentiateGET(n);
            sum.add(b.multiplyGET(c).multiplyGET(d));
        }

        return a.multiplyGET(sum);
    }
}