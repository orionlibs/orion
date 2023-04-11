package com.orion.math.number.interval.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class DivideIntervalsTask extends Orion
{
    public static Interval run(Interval x, Interval other)
    {
        IntervalRules.areValid(x, other);

        if(other.getRightEndpoint().isZero())
        {
            Interval temp = Interval.ofLeftInfinite(other.getLeftEndpoint().reciprocateGET());
            return x.multiply(temp);
        }
        else if(other.getLeftEndpoint().isZero())
        {
            Interval temp = Interval.ofRightInfinite(other.getRightEndpoint().reciprocateGET());
            return x.multiply(temp);
        }
        else if(x.isPointOutsideInterval(0))
        {
            return x.multiply(other.reciprocate());
        }
        else
        {
            return Interval.ofInfinite();
        }

    }
}