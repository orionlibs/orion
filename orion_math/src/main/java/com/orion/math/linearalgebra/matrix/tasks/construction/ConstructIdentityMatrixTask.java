package com.orion.math.linearalgebra.matrix.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class ConstructIdentityMatrixTask extends Orion
{
    public static Matrix run(int numberOfRowsAndColumns)
    {
        OrionList<Vector> elements = OrionArrayList.of(numberOfRowsAndColumns);

        for(int i = 0; i < numberOfRowsAndColumns; i++)
        {
            Vector temp = Vector.of(numberOfRowsAndColumns);

            for(int j = 0; j < numberOfRowsAndColumns; j++)
            {

                if(i == j)
                {
                    temp.set(j, ANumber.of(1));
                }
                else
                {
                    temp.set(j, ANumber.of(0));
                }

            }

            elements.add(temp);
        }

        return Matrix.of(elements);
    }
}