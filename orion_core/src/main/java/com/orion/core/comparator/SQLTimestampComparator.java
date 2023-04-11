package com.orion.core.comparator;

import com.orion.core.abstraction.Orion;
import java.sql.Timestamp;
import java.util.Comparator;

public class SQLTimestampComparator extends Orion implements Comparator<Timestamp>
{
    @Override
    public int compare(Timestamp x, Timestamp y)
    {
        return x.compareTo(y);
    }
}