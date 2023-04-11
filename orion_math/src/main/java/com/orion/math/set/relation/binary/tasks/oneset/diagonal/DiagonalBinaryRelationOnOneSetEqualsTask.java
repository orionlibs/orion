package com.orion.math.set.relation.binary.tasks.oneset.diagonal;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.diagonal.DiagonalBinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.diagonal.DiagonalBinaryRelationOnOneSetRules;

public class DiagonalBinaryRelationOnOneSetEqualsTask extends Orion
{
    public static boolean run(DiagonalBinaryRelationOnOneSet x, Object object)
    {
        DiagonalBinaryRelationOnOneSetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            DiagonalBinaryRelationOnOneSet other = (DiagonalBinaryRelationOnOneSet)object;
            return x.getElements().equals(other.getElements()) && x.getSet().equals(other.getSet());
        }

    }
}