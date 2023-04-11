package com.orion.math.number.interval.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class GetIntersectionBetweenIntervalsTask extends Orion
{
    public static Interval run(Interval... intervals)
    {
        IntervalRules.areValid(intervals);
        Interval newInterval = intervals[0];

        if(intervals.length == 1)
        {
            return intervals[0].getCopy();
        }
        else
        {

            for(int i = 1; i < intervals.length; i++)
            {
                newInterval = newInterval.getIntersection(intervals[i]);
            }

        }

        return newInterval;
    }
}