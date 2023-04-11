package com.orion.math.linearalgebra.matrix.generic.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrixRules;
import java.util.stream.IntStream;

public class ConvertElementsOfGenericMatrixToListOfVectorsTask extends Orion
{
    public static OrionList<GenericVector> run(Object[][] elements)
    {
        GenericMatrixRules.isValid(elements);
        OrionList<GenericVector> newElements = OrionArrayList.of(elements.length);
        IntStream.range(0, elements.length).forEach(i -> newElements.add(GenericVector.of(elements[i])));
        return newElements;
    }
}