package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import java.util.stream.IntStream;

public class RotateMatrixOfFunction1x190DegreesClockwiseTask extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);
        OrionList<VectorOfFunction1x1> elementsAsVectors = OrionArrayList.of();
        IntStream.range(0, x.getNumberOfRows())
                        .forEach(i -> elementsAsVectors.append(x.getColumn(i).reverseOrderOfElements()));
        return MatrixOfFunction1x1.of(elementsAsVectors);
    }
}