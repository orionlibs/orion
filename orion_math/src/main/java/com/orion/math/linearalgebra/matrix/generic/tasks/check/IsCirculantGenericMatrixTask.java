package com.orion.math.linearalgebra.matrix.generic.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.permutations.PermutationService;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import java.util.List;

public class IsCirculantGenericMatrixTask extends Orion
{
    public static boolean run(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        List<List<Object>> cyclicPermutations = PermutationService.getCyclicPermutations(x.getRow(0).getAsList());
        x.forAllRowIndices(i ->
        {
            List<Object> rowAsList = x.getRow(i).getAsList();

            if(cyclicPermutations.contains(rowAsList))
            {
                cyclicPermutations.remove(rowAsList);
            }

        });
        return cyclicPermutations.isEmpty();
    }
}