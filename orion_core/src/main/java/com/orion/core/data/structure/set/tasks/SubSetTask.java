package com.orion.core.data.structure.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SubSetTask<T> extends Orion
{
    public static <T> OrionSet<T> run(OrionSet<T> set, Predicate<T> filterToApply)
    {

        if(set != null)
        {
            Set<T> subset = set.filter(filterToApply).collect(Collectors.toSet());
            return OrionHashSet.<T>of(subset);
        }

        return null;
    }
}