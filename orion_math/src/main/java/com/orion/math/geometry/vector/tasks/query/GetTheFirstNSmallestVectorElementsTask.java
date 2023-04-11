package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.List;

public class GetTheFirstNSmallestVectorElementsTask extends Orion
{
    public static List<ANumber> run(Vector x, int n)
    {
        VectorRules.isValid(x);
        NumberRules.isPositive(n);
        OrionList<ANumber> minimumNumbers = OrionArrayList.of();
        Vector xCopy = x.getCopy();

        for(int i = 0; i < n; i++)
        {
            ANumber minimum = xCopy.getMinimum();
            minimumNumbers.add(minimum);
            xCopy.deleteAllOccurencesOf(minimum);
        }

        minimumNumbers.sort();
        return minimumNumbers.getAsList();
    }
}