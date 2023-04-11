package com.orion.math.statistics.classes.aclass;

import com.orion.core.comparator.CompareToService;
import java.util.Comparator;

public class StatisticalClassIntervalComparator<T> implements Comparator<T>
{
    @Override
    public int compare(T x, T y)
    {
        return CompareToService.<T>compareTo(x, y);
    }
}