package com.orion.math.combinatorics.permutations.tasks;

import com.orion.core.abstraction.Orion;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GetCyclicPermutationsOfObjectsTask extends Orion
{
    public static List<List<Object>> run(List<?> elements)
    {
        List<List<Object>> permutations = new ArrayList<List<Object>>();

        if(elements == null)
        {
            return permutations;
        }

        for(AtomicInteger i = new AtomicInteger(0); i.intValue() < elements.size(); i.incrementAndGet())
        {
            List<Object> temp = new ArrayList<Object>();
            IntStream.range(i.intValue(), elements.size() + i.intValue())
                            .forEach(j -> temp.add(elements.get(j % elements.size())));
            permutations.add(temp);
        }

        return permutations;
    }
}