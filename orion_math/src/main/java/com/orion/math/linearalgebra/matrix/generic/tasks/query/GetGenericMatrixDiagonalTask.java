package com.orion.math.linearalgebra.matrix.generic.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import java.util.ArrayList;
import java.util.List;

public class GetGenericMatrixDiagonalTask extends Orion
{
    public static GenericVector run(GenericMatrix x)
    {
        GenericMatrixRules.isValid(x);
        List<Object> elements = new ArrayList<Object>();
        x.filterAndLoop((i, j) -> i == j, element -> elements.add(element));
        return GenericVector.of(elements);
    }
}