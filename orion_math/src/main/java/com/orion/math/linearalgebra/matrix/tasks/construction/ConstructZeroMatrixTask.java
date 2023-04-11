package com.orion.math.linearalgebra.matrix.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class ConstructZeroMatrixTask extends Orion
{
    public static Matrix run(int numberOfRows, int numberOfColumns)
    {
        MatrixRules.isValid(numberOfRows, numberOfColumns);
        OrionList<Vector> elements = OrionArrayList.of(numberOfRows);

        for(int i = 0; i < numberOfRows; i++)
        {
            Vector temp = Vector.of(numberOfColumns);

            for(int j = 0; j < numberOfColumns; j++)
            {
                temp.set(j, ANumber.of(0));
            }

            elements.set(i, temp);
        }

        return Matrix.of(elements);
    }
}