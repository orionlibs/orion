package com.orion.math.linearalgebra.matrix.functional.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetDeterminantOfMatrixOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(MatrixOfFunction1x1 x)
    {
        MatrixOfFunction1x1Rules.isValidSquareMatrix(x);

        if(x.getNumberOfRows() == 1)
        {
            return x.get(0, 0);
        }
        else if(x.getNumberOfRows() == 2)
        {
            return (x.get(0, 0).multiply(x.get(1, 1))).subtract(x.get(0, 1).multiply(x.get(1, 0)));
        }
        else
        {
            Function1x1<ANumber, ANumber>[] result = new Function1x1[1];
            result[0] = Function1x1.Zero;
            x.forAllColumnIndices(j ->
            {
                Function1x1<ANumber, ANumber>[][] temp = x.getMinor(0, j).getAsArrayOfArrays();
                OrionList<VectorOfFunction1x1> elements = OrionArrayList.of(temp.length);
                IntStream.range(0, temp.length).forEach(i -> elements.add(VectorOfFunction1x1.of(temp[i])));
                result[0] = result[0].add(x.get(0, j).multiply(ANumber.of(Math.pow(-1, (double)j))).multiply(run(MatrixOfFunction1x1.of(elements))));
            });
            return result[0];
        }

    }
}