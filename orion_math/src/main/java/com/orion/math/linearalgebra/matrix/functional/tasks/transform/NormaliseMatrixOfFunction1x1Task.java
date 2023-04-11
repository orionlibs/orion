package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;

public class NormaliseMatrixOfFunction1x1Task extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        MatrixOfFunction1x1 y = x.getCopy();

        for(int i = 0; i < y.getNumberOfColumns(); i++)
        {
            VectorOfFunction1x1 columnI = y.getColumn(i);
            columnI = columnI.normalise();
            y.setColumn(i, columnI);
        }

        return y;
    }
}