package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntervalEqualsTask extends Orion
{
    public static boolean run(Interval x, Object y)
    {
        IntervalRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Interval other = (Interval)y;
            return x.getLeftEndpoint().equal(other.getLeftEndpoint())
                            && x.getRightEndpoint().equal(other.getRightEndpoint());
        }

    }
}