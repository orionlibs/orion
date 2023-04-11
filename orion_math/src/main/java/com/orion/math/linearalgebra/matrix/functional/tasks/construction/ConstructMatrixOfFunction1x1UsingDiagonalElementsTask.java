package com.orion.math.linearalgebra.matrix.functional.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;

public class ConstructMatrixOfFunction1x1UsingDiagonalElementsTask extends Orion
{
    public static MatrixOfFunction1x1 run(VectorOfFunction1x1 diagonalElements)
    {
        VectorOfFunction1x1Rules.isValid(diagonalElements);
        OrionList<VectorOfFunction1x1> elements = OrionArrayList.of(diagonalElements.getDimensions());

        for(int i = 0; i < diagonalElements.getDimensions(); i++)
        {
            VectorOfFunction1x1 temp = VectorOfFunction1x1.of(diagonalElements.getDimensions());

            for(int j = 0; j < diagonalElements.getDimensions(); j++)
            {

                if(i == j)
                {
                    temp.set(j, diagonalElements.get(i));
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