package com.orion.core.comparator;

import com.orion.core.abstraction.Orion;
import java.util.Comparator;

public class ElementComparator<T> extends Orion implements Comparator<T>
{
    @Override
    public int compare(T x, T y)
    {
        return CompareToService.<T>compareTo(x, y);
    }
}