package com.orion.math.geometry.vector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;

public class ConvertVectorToMatrixTask extends Orion
{
    public static Matrix run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber[][] yTemp = new ANumber[x.getSize()][1];
        NumberArrayStream.setValues(yTemp, x, 0);
        return Matrix.of(yTemp);
    }
}