package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetDiagonalOfMatrixTask extends Orion
{
    public static Vector run(Matrix x)
    {
        MatrixRules.isValid(x);
        List<ANumber> elements = new ArrayList<ANumber>();
        x.filterAndLoop((i, j) -> i == j, element -> elements.add(element));
        return Vector.of(elements);
    }
}