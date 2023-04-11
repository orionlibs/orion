package com.orion.core.comparator;

import com.orion.core.abstraction.Orion;
import com.orion.core.comparator.tasks.ReverseCompareToTask;

public class ReverseCompareToService<T> extends Orion
{
    public int compareTo(T x, T y)
    {
        return ReverseCompareToTask.run(x, y);
    }
}