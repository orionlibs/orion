package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class GetSubmatrixTask extends Orion
{
    public static Matrix run(Matrix x, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        MatrixRules.areValidDimensionIntervals(x, fromRow, toRow, fromColumn, toColumn);
        OrionList<Vector> elements = OrionArrayList.of();
        ANumber[][] elementsArray = x.getAsArrayOfArrays();
        x.forRowIndices(fromRow, toRow, i ->
        {
            ANumber[] temp = new ANumber[toColumn - fromColumn + 1];
            x.forColumnIndices(fromColumn, toColumn, j -> temp[j - fromColumn] = elementsArray[i][j].getCopy());
            elements.append(Vector.of(temp));
        });
        return Matrix.of(elements);
    }
}