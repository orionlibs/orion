package com.orion.core.data.structure.list.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.ListRules;
import com.orion.core.data.structure.list.OrionList;
import java.lang.reflect.Array;
import java.util.stream.IntStream;

public class GetListAsArrayTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> T[] run(OrionList<T> list)
    {
        ListRules.notEmpty(list);
        T[] array = (T[])Array.newInstance(list.getDataType(), list.size());

        if(list.isNotEmpty())
        {
            IntStream.range(0, list.size()).forEach(i -> array[i] = list.get(i));
        }

        return array;
    }
}