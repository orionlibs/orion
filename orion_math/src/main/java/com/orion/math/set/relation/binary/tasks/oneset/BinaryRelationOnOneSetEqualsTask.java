package com.orion.math.set.relation.binary.tasks.oneset;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSetRules;

public class BinaryRelationOnOneSetEqualsTask extends Orion
{
    public static boolean run(BinaryRelationOnOneSet x, Object object)
    {
        BinaryRelationOnOneSetRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            BinaryRelationOnOneSet other = (BinaryRelationOnOneSet)object;
            return x.getElements().equals(other.getElements()) && x.getSet().equals(other.getSet());
        }

    }
}