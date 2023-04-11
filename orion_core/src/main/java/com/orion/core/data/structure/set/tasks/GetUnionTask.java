package com.orion.core.data.structure.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import java.util.Arrays;
import java.util.List;

public class GetUnionTask<T> extends Orion
{
    @SafeVarargs
    public static <T> OrionSet<T> run(OrionSet<T>... sets)
    {

        if(sets != null)
        {
            return run(Arrays.asList(sets));
        }

        return null;
    }


    public static <T> OrionSet<T> run(List<OrionSet<T>> sets)
    {

        if(sets != null)
        {

            if(sets.size() == 1)
            {
                return OrionHashSet.<T>of(sets.get(0));
            }
            else
            {
                int totalSize = sets.stream().mapToInt(set -> set.size()).sum();
                OrionSet<T> result = OrionHashSet.<T>of(totalSize);
                sets.stream().forEach(set -> result.addAll(set));
                return result;
            }

        }

        return null;
    }
}