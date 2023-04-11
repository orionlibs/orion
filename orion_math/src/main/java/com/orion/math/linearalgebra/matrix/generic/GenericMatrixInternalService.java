package com.orion.math.linearalgebra.matrix.generic;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.generic.GenericVector;
import com.orion.math.linearalgebra.matrix.generic.tasks.GenericMatrixEqualsTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.GenericMatrixHashCodeTask;
import com.orion.math.linearalgebra.matrix.generic.tasks.GenericMatrixOfDiagonalTask;

class GenericMatrixInternalService implements MathObject
{
    static boolean equals(GenericMatrix x, Object y)
    {
        return GenericMatrixEqualsTask.run(x, y);
    }


    static int hashCode(GenericMatrix x)
    {
        return GenericMatrixHashCodeTask.run(x);
    }


    static GenericMatrix ofDiagonal(GenericVector diagonalElements)
    {
        return GenericMatrixOfDiagonalTask.run(diagonalElements);
    }
}