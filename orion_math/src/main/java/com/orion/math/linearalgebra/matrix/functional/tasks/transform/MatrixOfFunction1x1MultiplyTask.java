package com.orion.math.linearalgebra.matrix.functional.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Service;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class MatrixOfFunction1x1MultiplyTask extends Orion
{
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, Number y)
    {
        NumberRules.isNotNull(y);
        return run(x, ANumber.of(y));
    }


    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, ANumber y)
    {
        return run(x, Function1x1.<ANumber, ANumber>of(x1 -> y));
    }


    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, Function1x1<ANumber, ANumber> y)
    {
        MatrixOfFunction1x1Rules.isValid(x);
        NumberRules.isNotNull(y);
        Function1x1<ANumber, ANumber>[][] elements = new Function1x1[x.getNumberOfRows()][x.getNumberOfColumns()];
        x.forAll((i, j) -> elements[i][j] = x.get(i, j).multiply(y));
        return MatrixOfFunction1x1.of(elements);
    }


    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, MatrixOfFunction1x1 y)
    {
        MatrixOfFunction1x1Rules.areValid(x, y);
        MatrixOfFunction1x1Rules.areMatrixSizesValidForMultiplication(x, y);
        MatrixOfFunction1x1 temp = MatrixOfFunction1x1.of(x.getAsArrayOfArrays());
        temp.multiplyInPlace(y);
        return temp;
    }


    public static MatrixOfFunction1x1 run(MatrixOfFunction1x1 x, VectorOfFunction1x1 y)
    {
        return run(x, VectorOfFunction1x1Service.convertToMatrix(y));
    }
}