package com.orion.math.set.relation.binary.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.BinaryRelationRules;

public class DoesPairSatisfyConditionOfBinaryRelationTask extends Orion
{
    public static boolean run(BinaryRelation x, Pair<Object, Object> pair)
    {
        BinaryRelationRules.isValid(x.getConditionPairsMustSatisfy());

        if(x.doesPairBelongToRelation(pair))
        {
            return x.getConditionPairsMustSatisfy().apply(pair);
        }
        else
        {
            throw new InvalidArgumentException("The given pair input does not belong to the relation.");
        }

    }
}