package com.orion.math.set.relation.binary.tasks.oneset.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSetRules;

public class DoesPairSatisfyConditionOfBinaryRelationOnOneSetTask extends Orion
{
    public static boolean run(BinaryRelationOnOneSet x, Pair<Object, Object> pair)
    {
        BinaryRelationOnOneSetRules.isValid(x.getConditionPairsMustSatisfy());

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