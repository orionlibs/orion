package com.orion.math.linearalgebra.matrix.functional.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class ConstructZeroMatrixOfFunction1x1Task extends Orion
{
    public static MatrixOfFunction1x1 run(int numberOfRows, int numberOfColumns)
    {
        MatrixOfFunction1x1Rules.isValid(numberOfRows, numberOfColumns);
        OrionList<VectorOfFunction1x1> elements = OrionArrayList.of(numberOfRows);

        for(int i = 0; i < numberOfRows; i++)
        {
            VectorOfFunction1x1 temp = VectorOfFunction1x1.of(numberOfColumns);

            for(int j = 0; j < numberOfColumns; j++)
            {
                temp.set(j, Function1x1.Zero);
            }

            elements.set(i, temp);
        }

        return MatrixOfFunction1x1.of(elements);
    }
}