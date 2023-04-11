package com.orion.math.calculus.integral.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntegrateUsingTrapezoidalRuleForFunction2x1Task extends Orion
{
    private int n;
    private ANumber h;
    private ANumber a;
    private ANumber b;


    private void runChecks(Function2x1<ANumber, ANumber, ANumber> f, Interval interval, int iterations)
    {
        FunctionRules.isValid(f);
        IntervalRules.isValid(interval);
        NumberRules.hasNaturalNumberValue(iterations);
    }


    private void initialise(Interval interval, int iterations)
    {
        this.n = iterations;
        this.h = interval.getLength().divideGET(n);
        this.a = interval.getLeftEndpoint();
        this.b = interval.getRightEndpoint();
    }


    public ANumber run(Function2x1<ANumber, ANumber, ANumber> f, Interval intervalForX, ANumber y, int iterations)
    {
        runChecks(f, intervalForX, iterations);
        initialise(intervalForX, iterations);
        ANumber sum = f.run(a, y).addGET(f.run(b, y)).multiplyGET(h).halfGET();

        for(int i = 1; i < n; i++)
        {
            ANumber x = h.multiplyGET(i).addGET(a);
            sum.add(f.run(x, y).multiplyGET(h));
        }

        return sum;
    }


    public ANumber run(Function2x1<ANumber, ANumber, ANumber> f, ANumber x, Interval intervalForY, int iterations)
    {
        runChecks(f, intervalForY, iterations);
        initialise(intervalForY, iterations);
        ANumber sum = f.run(x, a).addGET(f.run(x, b)).multiplyGET(h).halfGET();

        for(int i = 1; i < n; i++)
        {
            ANumber c = h.multiplyGET(i).addGET(a);
            sum.add(f.run(x, c).multiplyGET(h));
        }

        return sum;
    }
}