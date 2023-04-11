package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.permutations.PermutationService;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import java.util.List;

public class IsCirculantMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        List<List<Object>> cyclicPermutations = PermutationService.getCyclicPermutations(x.getRow(0).getAsList());
        x.forAllRowIndices(i ->
        {
            List<ANumber> rowAsList = x.getRow(i).getAsList();

            if(cyclicPermutations.contains(rowAsList))
            {
                cyclicPermutations.remove(rowAsList);
            }

        });
        return cyclicPermutations.isEmpty();
    }
}