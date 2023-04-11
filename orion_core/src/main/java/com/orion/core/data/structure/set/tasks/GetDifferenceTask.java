package com.orion.core.data.structure.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;

public class GetDifferenceTask<T> extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> OrionSet<T> run(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionList<T> result = OrionArrayList.of(set1);
        OrionList<T> intersection = new OrionArrayList<>(GetIntersectionTask.run(set1, set2));
        result.removeAll(intersection);
        return new OrionHashSet<T>(result);
    }
}