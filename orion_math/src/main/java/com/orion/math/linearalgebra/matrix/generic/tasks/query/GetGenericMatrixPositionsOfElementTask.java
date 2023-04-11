package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import java.util.ArrayList;
import java.util.List;

public class GetGenericMatrixPositionsOfElementTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Pair<Integer, Integer>[] run(GenericMatrix x, Object y)
    {
        GenericMatrixRules.isValid(x);
        List<Pair<Integer, Integer>> positions = new ArrayList<Pair<Integer, Integer>>();
        x.forAllRowAndColumnIndices((i, j) -> x.get(i, j).equals(y), (i, j) -> positions.add(Pair.of(i, j)));
        return positions.toArray(new Pair[0]);
    }
}