package com.orion.core.data.structure.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;

public class IsSubsetOfTask<T> extends Orion
{
    public static <T> boolean run(OrionSet<T> set1, OrionSet<T> set2)
    {
        OrionSet<T> set2Copy = set2.getCopy();
        set2Copy.retainAll(set1);
        return set2Copy.equals(set1);
    }
}