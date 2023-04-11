package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import java.util.stream.IntStream;

public class RotateMatrix90DegreesClockwiseTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        OrionList<Vector> elementsAsVectors = OrionArrayList.<Vector>of();
        IntStream.range(0, x.getNumberOfRows())
                        .forEach(i -> elementsAsVectors.append(x.getColumn(i).reverseOrderOfElements()));
        return Matrix.of(elementsAsVectors);
    }
}