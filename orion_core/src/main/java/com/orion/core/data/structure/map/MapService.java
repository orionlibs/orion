package com.orion.core.data.structure.map;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.map.tasks.CreateMapEntryTask;
import java.util.Map;

public class MapService<T1, T2> extends Orion
{
    public static <T1, T2> Map.Entry<T1, T2> createMapEntry(T1 key, T2 value)
    {
        return CreateMapEntryTask.run(key, value);
    }


    public static <T1, T2> Map.Entry<T1, T2> createMapEntry(Map.Entry<?, ?> entry)
    {
        return CreateMapEntryTask.run(entry);
    }
}