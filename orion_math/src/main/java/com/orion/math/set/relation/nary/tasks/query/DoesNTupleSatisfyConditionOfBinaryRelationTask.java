package com.orion.math.set.relation.nary.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.tuple.NTuple;
import com.orion.math.set.relation.nary.NAryRelation;
import com.orion.math.set.relation.nary.NAryRelationRules;

public class DoesNTupleSatisfyConditionOfBinaryRelationTask extends Orion
{
    public static boolean run(NAryRelation x, NTuple nTuple)
    {
        NAryRelationRules.isValid(x.getConditionNTuplesMustSatisfy());

        if(x.doesNTupleBelongToRelation(nTuple))
        {
            return x.getConditionNTuplesMustSatisfy().apply(nTuple);
        }
        else
        {
            throw new InvalidArgumentException("The given nTuple input does not belong to the relation.");
        }

    }
}