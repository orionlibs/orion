package com.orion.math.linearalgebra.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.function.BackwardSubstitutionFunction;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.decomposition.QRDecomposition;
import com.orion.math.number.ANumber;

public class SolveSystemOfLinearEquationsUsingQRDecompositionTask extends Orion
{
    public static Vector run(Matrix coefficients, ANumber[] constants)
    {
        MatrixRules.isValid(coefficients);
        QRDecomposition qrDecomposition = coefficients.getQRDecomposition();
        Matrix newConstants = qrDecomposition.getQ().transpose().multiply(Vector.of(constants));
        return BackwardSubstitutionFunction.run(qrDecomposition.getR(), newConstants.getColumn(0));
    }


    public static Vector run(Matrix coefficients, Vector constants)
    {
        VectorRules.isValid(constants);
        return run(coefficients, constants.getAsArray());
    }
}