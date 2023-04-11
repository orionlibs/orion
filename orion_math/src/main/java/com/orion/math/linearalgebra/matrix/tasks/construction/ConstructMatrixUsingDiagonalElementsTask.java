package com.orion.math.linearalgebra.matrix.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class ConstructMatrixUsingDiagonalElementsTask extends Orion
{
    public static Matrix run(Vector diagonalElements)
    {
        VectorRules.isValid(diagonalElements);
        OrionList<Vector> elements = OrionArrayList.of(diagonalElements.getDimensions());

        for(int i = 0; i < diagonalElements.getDimensions(); i++)
        {
            Vector temp = Vector.of(diagonalElements.getDimensions());

            for(int j = 0; j < diagonalElements.getDimensions(); j++)
            {

                if(i == j)
                {
                    temp.set(j, diagonalElements.get(i).getCopy());
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