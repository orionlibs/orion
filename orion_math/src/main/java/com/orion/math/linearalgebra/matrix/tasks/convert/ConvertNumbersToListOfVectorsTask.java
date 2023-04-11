package com.orion.math.linearalgebra.matrix.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class ConvertNumbersToListOfVectorsTask extends Orion
{
    public static OrionList<Vector> run(ANumber[][] elements)
    {
        MatrixRules.isValid(elements);
        OrionList<Vector> newElements = OrionArrayList.of(elements.length);
        IntStream.range(0, elements.length).forEach(i -> newElements.add(Vector.of(elements[i])));
        return newElements;
    }
}