package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.ArrayList;
import java.util.List;

public class GetPositionsOfElementInMatrixTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Pair<Integer, Integer>[] run(Matrix x, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        List<Pair<Integer, Integer>> positions = new ArrayList<Pair<Integer, Integer>>();
        x.forAllRowAndColumnIndices((i, j) -> x.get(i, j).equal(y), (i, j) -> positions.add(Pair.of(i, j)));
        return positions.toArray(new Pair[0]);
    }
}