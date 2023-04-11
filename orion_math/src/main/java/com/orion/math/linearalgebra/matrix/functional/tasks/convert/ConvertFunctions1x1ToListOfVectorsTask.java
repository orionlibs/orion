package com.orion.math.linearalgebra.matrix.functional.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class ConvertFunctions1x1ToListOfVectorsTask extends Orion
{
    public static OrionList<VectorOfFunction1x1> run(Function1x1<ANumber, ANumber>[][] elements)
    {
        MatrixOfFunction1x1Rules.isValid(elements);
        OrionList<VectorOfFunction1x1> newElements = OrionArrayList.of(elements.length);
        IntStream.range(0, elements.length).forEach(i -> newElements.add(VectorOfFunction1x1.of(elements[i])));
        return newElements;
    }
}