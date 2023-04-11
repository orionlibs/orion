package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetSubmatrixOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, int fromRow, int toRow, int fromColumn, int toColumn)
    {
        MatrixOfFunction1x1Rules.areValidDimensionIntervals(x, fromRow, toRow, fromColumn, toColumn);
        OrionList<VectorOfFunction1x1> elements = OrionArrayList.of();
        Function1x1<ANumber, ANumber>[][] elementsArray = x.getAsArrayOfArrays();
        x.forRowIndices(fromRow, toRow, i ->
        {
            Function1x1<ANumber, ANumber>[] temp = new Function1x1[toColumn - fromColumn + 1];
            x.forColumnIndices(fromColumn, toColumn, j -> temp[j - fromColumn] = elementsArray[i][j]);
            elements.append(VectorOfFunction1x1.of(temp));
        });
        return MatrixOfFunction1x1.of(elements);
    }
}