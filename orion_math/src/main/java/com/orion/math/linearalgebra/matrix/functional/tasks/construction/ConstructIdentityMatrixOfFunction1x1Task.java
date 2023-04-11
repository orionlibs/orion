package com.orion.math.linearalgebra.matrix.functional.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;

public class ConstructIdentityMatrixOfFunction1x1Task extends Orion
{
    public static MatrixOfFunction1x1 run(int numberOfRowsAndColumns)
    {
        OrionList<VectorOfFunction1x1> elements = OrionArrayList.of(numberOfRowsAndColumns);

        for(int i = 0; i < numberOfRowsAndColumns; i++)
        {
            VectorOfFunction1x1 temp = VectorOfFunction1x1.of(numberOfRowsAndColumns);

            for(int j = 0; j < numberOfRowsAndColumns; j++)
            {

                if(i == j)
                {
                    temp.set(j, Function1x1.One);
                }
                else
                {
                    temp.set(j, Function1x1.Zero);
                }

            }

            elements.add(temp);
        }

        return MatrixOfFunction1x1.of(elements);
    }
}