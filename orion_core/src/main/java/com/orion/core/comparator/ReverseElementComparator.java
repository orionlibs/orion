package com.orion.core.comparator;

import com.orion.core.abstraction.Orion;
import java.util.Comparator;

public class ReverseElementComparator<T> extends Orion implements Comparator<T>
{
    @Override
    public int compare(T x, T y)
    {
        return new ReverseCompareToService<T>().compareTo(x, y);
    }
}