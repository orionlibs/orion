package com.orion.math.set.relation.nary.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.NTuple;
import com.orion.math.set.relation.nary.NAryRelation;
import com.orion.math.set.relation.nary.NAryRelationRules;

public class DoExistingNTuplesSatisfyConditionOfBinaryRelationTask extends Orion
{
    public static boolean run(NAryRelation x)
    {
        NAryRelationRules.isValid(x.getConditionNTuplesMustSatisfy());

        for(NTuple nTuple : x.getElements())
        {

            if(x.doesNTupleNotSatisfyCondition(nTuple))
            {
                return false;
            }

        }

        return true;
    }
}