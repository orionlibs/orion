package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorService;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class MatrixMultiplyTask extends Orion
{
    public static Matrix run(Matrix x, ANumber y)
    {
        MatrixRules.isValid(x);
        NumberRules.isNotNull(y);
        ANumber[][] elements = new ANumber[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).multiplyGET(y));
        return Matrix.of(elements);
    }


    public static Matrix run(Matrix x, Matrix y)
    {
        MatrixRules.areValid(x, y);
        MatrixRules.areMatrixSizesValidForMultiplication(x, y);
        Matrix temp = Matrix.of(x.getAsArrayOfArraysCopy());
        temp.multiplyInPlace(y);
        return temp;
    }


    public static Matrix run(Matrix x, Vector y)
    {
        return run(x, VectorService.convertToMatrix(y));
    }
}