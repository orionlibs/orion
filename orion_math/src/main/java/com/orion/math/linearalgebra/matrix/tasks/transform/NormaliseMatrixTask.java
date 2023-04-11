package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;

public class NormaliseMatrixTask extends Orion
{
    public static Matrix run(Matrix x)
    {
        MatrixRules.isValid(x);
        Matrix y = x.getCopy();

        for(int i = 0; i < y.getNumberOfColumns(); i++)
        {
            Vector columnI = y.getColumn(i);
            columnI = columnI.normalise();
            y.setColumn(i, columnI);
        }

        return y;
    }
}