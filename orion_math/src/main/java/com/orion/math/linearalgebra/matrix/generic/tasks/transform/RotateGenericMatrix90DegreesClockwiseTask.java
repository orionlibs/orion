package com.orion.math.linearalgebra.matrix.generic.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import java.util.stream.IntStream;

public class RotateGenericMatrix90DegreesClockwiseTask extends Orion
{
    public static GenericMatrix run(GenericMatrix x)
    {
        GenericMatrixRules.isValidSquareMatrix(x);
        OrionList<GenericVector> elementsAsVectors = OrionArrayList.<GenericVector>of();
        IntStream.range(0, x.getNumberOfRows())
                        .forEach(i -> elementsAsVectors.append(x.getColumn(i).reverseOrderOfElements()));
        return GenericMatrix.of(elementsAsVectors);
    }
}