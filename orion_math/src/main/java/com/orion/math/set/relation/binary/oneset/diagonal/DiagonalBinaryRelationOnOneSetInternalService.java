package com.orion.math.set.relation.binary.oneset.diagonal;

import com.orion.math.MathObject;
import com.orion.math.set.relation.binary.tasks.oneset.diagonal.DiagonalBinaryRelationOnOneSetEqualsTask;
import com.orion.math.set.relation.binary.tasks.oneset.diagonal.DiagonalBinaryRelationOnOneSetHashCodeTask;

class DiagonalBinaryRelationOnOneSetInternalService implements MathObject
{
    static boolean equals(DiagonalBinaryRelationOnOneSet x, Object y)
    {
        return DiagonalBinaryRelationOnOneSetEqualsTask.run(x, y);
    }


    static int hashCode(DiagonalBinaryRelationOnOneSet x)
    {
        return DiagonalBinaryRelationOnOneSetHashCodeTask.run(x);
    }
}