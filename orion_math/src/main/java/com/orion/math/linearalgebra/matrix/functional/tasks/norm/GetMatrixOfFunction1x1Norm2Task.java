package com.orion.math.linearalgebra.matrix.functional.tasks.norm;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetMatrixOfFunction1x1Norm2Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        Function1x1<ANumber, ANumber>[] result = new Function1x1[1];
        result[0] = Function1x1.Zero;
        x.forAll((i, j) -> result[0] = result[0].add(x.get(i, j).getSquare()));
        return result[0].getSquareRoot();
    }
}