package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetDiagonalOfMatrixOfFunction1x1Task extends Orion
{
    public static VectorOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        List<Function1x1<ANumber, ANumber>> elements = new ArrayList<Function1x1<ANumber, ANumber>>();
        x.filterAndLoop((i, j) -> i == j, element -> elements.add(element));
        return VectorOfFunction1x1.of(elements);
    }
}