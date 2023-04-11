package com.orion.core.comparator;

import com.orion.core.abstraction.Orion;
import com.orion.core.comparator.tasks.CompareToTask;

public class CompareToService<T> extends Orion
{
    public static <T> int compareTo(T x, T y)
    {
        return CompareToTask.run(x, y);
    }
}