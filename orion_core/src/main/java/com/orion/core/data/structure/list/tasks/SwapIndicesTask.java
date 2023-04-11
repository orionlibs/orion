package com.orion.core.data.structure.list.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;

public class SwapIndicesTask<T> extends Orion
{
    public void run(OrionList<T> list, int index1, int index2)
    {

        if(list != null)
        {
            T element1 = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, element1);
        }

    }
}