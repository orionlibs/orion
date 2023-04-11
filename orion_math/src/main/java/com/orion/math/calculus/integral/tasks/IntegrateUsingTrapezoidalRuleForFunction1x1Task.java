package com.orion.math.calculus.integral.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntegrateUsingTrapezoidalRuleForFunction1x1Task extends Orion
{
    public static ANumber run(Function1x1<ANumber, ANumber> f, Interval interval, int iterations)
    {
        FunctionRules.isValid(f);
        IntervalRules.isValid(interval);
        NumberRules.hasNaturalNumberValue(iterations);
        int n = iterations;
        ANumber h = interval.getLength().divideGET(n);
        ANumber a = interval.getLeftEndpoint();
        ANumber b = interval.getRightEndpoint();
        ANumber sum = f.run(a).addGET(f.run(b)).multiplyGET(h).halfGET();

        for(int i = 1; i < n; i++)
        {
            ANumber x = h.multiplyGET(i).addGET(a);
            sum.add(f.run(x).multiplyGET(h));
        }

        return sum;
    }
}