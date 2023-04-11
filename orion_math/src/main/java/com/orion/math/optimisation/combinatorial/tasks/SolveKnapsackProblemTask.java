package com.orion.math.optimisation.combinatorial.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SolveKnapsackProblemTask extends Orion
{
    public static Pair<ANumber, List<Integer>> run(int capacity, Vector weights, Vector values)
    {
        NumberRules.hasNaturalNumberValue(capacity);
        VectorRules.doVectorSizesMatch(weights, values);
        final int n = weights.getSize();
        ANumber[][] DP = new ANumber[n + 1][capacity + 1];

        for(int i = 1; i <= n; i++)
        {
            ANumber w = weights.get(i - 1).getCopy();
            ANumber v = values.get(i - 1).getCopy();

            for(int sz = 1; sz <= capacity; sz++)
            {
                DP[i][sz] = DP[i - 1][sz];
                int szMinusW = sz - w.getAsInt();

                if(w.isLessThanOrEqual(sz) && DP[i - 1][szMinusW].addGET(v).isGreaterThan(DP[i][sz]))
                {
                    DP[i][sz] = DP[i - 1][szMinusW].addGET(v);
                }

            }

        }

        int sz = capacity;
        List<Integer> itemsSelected = new ArrayList<Integer>();

        for(int i = n; i > 0; i--)
        {

            if(DP[i][sz].notEqual(DP[i - 1][sz]))
            {
                int itemIndex = i - 1;
                itemsSelected.add(itemIndex);
                sz -= weights.get(itemIndex).getAsInteger().intValue();
            }

        }

        Collections.reverse(itemsSelected);
        return Pair.of(DP[n][capacity], itemsSelected);
    }
}