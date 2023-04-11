package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IntervalCompareToTask extends Orion
{
    public static int run(Interval x, Interval y)
    {
        IntervalRules.isValid(x);

        if(y == null)
        {
            return 0;
        }
        else
        {

            if(x.getLeftEndpoint().isLessThan(y.getLeftEndpoint()))
            {
                return -1;
            }
            else if(x.getLeftEndpoint().equal(y.getLeftEndpoint()))
            {
                return 0;
            }
            else
            {
                return 1;
            }

        }

    }
}