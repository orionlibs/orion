package com.orion.math.set.relation.binary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.BinaryRelationRules;

public class BinaryRelationEqualsTask extends Orion
{
    public static boolean run(BinaryRelation x, Object object)
    {
        BinaryRelationRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            BinaryRelation other = (BinaryRelation)object;
            return x.getElements().equals(other.getElements()) && x.getSetA().equals(other.getSetA())
                            && x.getSetB().equals(other.getSetB());
        }

    }
}