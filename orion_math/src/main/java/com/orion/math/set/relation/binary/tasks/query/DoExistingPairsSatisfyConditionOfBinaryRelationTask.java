package com.orion.math.set.relation.binary.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.BinaryRelationRules;

public class DoExistingPairsSatisfyConditionOfBinaryRelationTask extends Orion
{
    public static boolean run(BinaryRelation x)
    {
        BinaryRelationRules.isValid(x.getConditionPairsMustSatisfy());

        for(Pair<Object, Object> pair : x.getElements())
        {

            if(x.doesPairNotSatisfyCondition(pair))
            {
                return false;
            }

        }

        return true;
    }
}