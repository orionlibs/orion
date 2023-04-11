package com.orion.math.number.interval.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class SplitIntervalInNTask extends Orion
{
    public static Interval[] run(Interval interval, int n)
    {
        IntervalRules.isValid(interval);
        Interval[] subintervals = new Interval[n];
        ANumber increment = interval.getLength().divideGET(n);
        ANumber newLeftEndPoint = interval.getLeftEndpointCopy();
        ANumber newRightEndPoint = interval.getRightEndpointCopy();

        for(int i = 0; i < n; i++)
        {
            newRightEndPoint = newLeftEndPoint.addGET(increment);

            if(i == 0)
            {
                subintervals[i] = Interval.of(newLeftEndPoint, newRightEndPoint, interval.isLeftClosed(), true);
            }
            else if(i == n - 1)
            {
                subintervals[i] = Interval.of(newLeftEndPoint, newRightEndPoint, true, interval.isRightClosed());
            }
            else
            {
                subintervals[i] = Interval.of(newLeftEndPoint, newRightEndPoint);
            }

            newLeftEndPoint = newRightEndPoint;
        }

        return subintervals;
    }
}