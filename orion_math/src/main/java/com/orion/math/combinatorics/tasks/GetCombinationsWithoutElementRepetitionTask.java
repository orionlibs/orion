package com.orion.math.combinatorics.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.Lists;
import com.orion.core.exception.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GetCombinationsWithoutElementRepetitionTask<T> extends Orion
{
    private List<List<T>> combinations;


    public List<List<T>> run(List<T> elements, int combinationSize)
    {
        Assert.notNull(combinationSize, "The elements inpupt cannot be null.");
        int n = elements.size();
        Assert.isLessThanOrEqualTo(combinationSize, n, "combinationSize must be <= n.");
        combinations = new ArrayList<List<T>>();

        if(Lists.isEmpty(elements))
        {
            return combinations;
        }

        boolean[] used = new boolean[n];
        process(elements, combinationSize, 0, used);
        return combinations;
    }


    private void process(List<T> elements, int r, int at, boolean[] used)
    {
        int n = elements.size();
        int elementsLeftToPick = n - at;

        if(elementsLeftToPick < r)
        {
            return;
        }

        if(r == 0)
        {
            List<T> temp = new ArrayList<T>();
            IntStream.range(0, n).filter(i -> used[i]).forEach(i -> temp.add(elements.get(i)));
            combinations.add(temp);
        }
        else
        {

            for(int i = at; i < n; i++)
            {
                used[i] = true;
                process(elements, r - 1, i + 1, used);
                used[i] = false;
            }

        }

    }
}