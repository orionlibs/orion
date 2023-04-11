package com.orion.math.set.relation.nary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.nary.NAryRelation;
import com.orion.math.set.relation.nary.NAryRelationRules;

public class RelationEqualsTask extends Orion
{
    public static boolean run(NAryRelation x, Object object)
    {
        NAryRelationRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            NAryRelation other = (NAryRelation)object;
            return x.getElements().equals(other.getElements()) && x.getSets().equals(other.getSets());
        }

    }
}