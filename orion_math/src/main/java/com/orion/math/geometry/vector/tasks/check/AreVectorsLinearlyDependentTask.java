package com.orion.math.geometry.vector.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;
import java.util.Arrays;
import java.util.List;

public class AreVectorsLinearlyDependentTask extends Orion
{
    public static boolean run(List<Vector> vectors)
    {
        VectorRules.areValid(vectors);
        VectorRules.isValidNumberOfVectors(vectors, 2);
        VectorRules.doVectorSizesMatch(vectors);

        if(vectors.stream().anyMatch(vector -> vector.isZeroVector())
                        || vectors.size() > vectors.get(0).getDimensions())
        {
            return true;
        }
        else
        {
            ANumber[][] elements = new ANumber[vectors.get(0).getDimensions()][vectors.size()];
            NumberArrayStream.setValues(elements, vectors);
            return Matrix.of(elements).getDeterminant().isZero();
        }

    }


    public static boolean run(Vector... vectors)
    {
        return run(Arrays.asList(vectors));
    }
}