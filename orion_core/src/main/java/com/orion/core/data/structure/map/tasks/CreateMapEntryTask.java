package com.orion.core.data.structure.map.tasks;

import com.orion.core.abstraction.Orion;
import java.util.Map;

public class CreateMapEntryTask<T1, T2> extends Orion
{
    public static <T1, T2> Map.Entry<T1, T2> run(T1 key, T2 value)
    {
        return Map.entry(key, value);
    }


    public static <T1, T2> Map.Entry<T1, T2> run(Map.Entry<?, ?> entry)
    {
        return new Map.Entry<T1, T2>()
        {
            @SuppressWarnings("unchecked")
            @Override
            public T1 getKey()
            {
                return (T1)entry.getKey();
            }


            @SuppressWarnings("unchecked")
            @Override
            public T2 getValue()
            {
                return (T2)entry.getValue();
            }


            @Override
            public T2 setValue(T2 value)
            {
                return value;
            }
        };
    }
}