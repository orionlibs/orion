package com.orion.math.linearalgebra.matrix.generic.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.geometry.vector.generic.GenericVectorRules;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;

public class GenericMatrixOfDiagonalTask extends Orion
{
    public static GenericMatrix run(GenericVector diagonalElements)
    {
        GenericVectorRules.isValid(diagonalElements);
        OrionList<GenericVector> elements = OrionArrayList.of(diagonalElements.getDimensions());

        for(int i = 0; i < diagonalElements.getDimensions(); i++)
        {
            GenericVector temp = GenericVector.of(diagonalElements.getDimensions());

            for(int j = 0; j < diagonalElements.getDimensions(); j++)
            {

                if(i == j)
                {
                    temp.add(CloningService.clone(diagonalElements.get(i)));
                }

            }

            elements.add(temp);
        }

        return GenericMatrix.of(elements);
    }
}