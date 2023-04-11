package com.orion.math.combinatorics.permutations.tasks;

import com.orion.core.abstraction.Orion;
import java.util.ArrayList;
import java.util.List;

public class PermuteObjectsTask extends Orion
{
    private List<List<?>> permutations;


    public List<List<?>> run(List<?> elements)
    {
        this.permutations = new ArrayList<List<?>>();

        if(elements == null)
        {
            return permutations;
        }

        boolean[] used = new boolean[elements.size()];
        int[] picked = new int[elements.size()];
        process(0, used, picked, elements);
        return permutations;
    }


    private void process(int at, boolean[] used, int[] picked, List<?> sequence)
    {
        final int n = sequence.size();

        if(at == n)
        {
            List<Object> temp = new ArrayList<Object>();

            for(int i = 0; i < n; i++)
            {
                temp.add(sequence.get(picked[i]));
            }

            permutations.add(temp);
        }
        else
        {

            for(int i = 0; i < n; i++)
            {

                if(!used[i])
                {
                    used[i] = true;
                    picked[at] = i;
                    process(at + 1, used, picked, sequence);
                    used[i] = false;
                }

            }

        }

    }
}