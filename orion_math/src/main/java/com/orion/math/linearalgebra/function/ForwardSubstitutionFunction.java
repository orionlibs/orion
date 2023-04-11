package com.orion.math.linearalgebra.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.LinearAlgebraService;
import com.orion.math.linearalgebra.matrix.Matrix;

public class ForwardSubstitutionFunction extends Orion
{
    private static Function2x1<Matrix, Vector, Vector> formula;
    static
    {
        formula = Function2x1.of((Matrix matrix, Vector vector) -> LinearAlgebraService.doForwardSubstitution(matrix, vector));
    }


    public static Vector run(Matrix matrix, Vector vector)
    {
        return formula.run(matrix, vector);
    }
}