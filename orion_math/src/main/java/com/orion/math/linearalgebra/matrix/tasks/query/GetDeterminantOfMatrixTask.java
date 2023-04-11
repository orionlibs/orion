package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDeterminantOfMatrixTask extends Orion
{
    public static ANumber run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        if(x.getNumberOfRows() == 1)
        {
            return x.get(0, 0).getCopy();
        }
        else if(x.getNumberOfRows() == 2)
        {
            return (x.get(0, 0).multiplyGET(x.get(1, 1))).subtractGET(x.get(0, 1).multiplyGET(x.get(1, 0)));
        }
        else
        {
            ANumber result = ANumber.of(0);
            x.forAllColumnIndices(j ->
            {
                ANumber[][] temp = x.getMinor(0, j).getAsArrayOfArrays();
                OrionList<Vector> elements = OrionArrayList.of(temp.length);
                IntStream.range(0, temp.length).forEach(i -> elements.add(Vector.of(temp[i])));
                result.add(x.get(0, j).multiplyGET(ANumber.of(Math.pow(-1, (double)j))).multiplyGET(run(Matrix.of(elements))));
            });
            return result;
        }

    }
}