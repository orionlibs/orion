package com.orion.math.number.interval;

import com.orion.math.MathObject;
import com.orion.math.number.interval.tasks.IntervalCompareToTask;
import com.orion.math.number.interval.tasks.IntervalEqualsTask;
import com.orion.math.number.interval.tasks.IntervalHashCodeTask;

class IntervalInternalService implements MathObject
{
    static boolean equals(Interval x, Object y)
    {
        return IntervalEqualsTask.run(x, y);
    }


    static int hashCode(Interval x)
    {
        return IntervalHashCodeTask.run(x);
    }


    static int compareTo(Interval x, Interval y)
    {
        return IntervalCompareToTask.run(x, y);
    }
}