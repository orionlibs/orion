package com.orion.math.set.relation.binary.tasks.oneset.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSetRules;

public class DoExistingPairsSatisfyConditionOfBinaryRelationOnOneSetTask extends Orion
{
    public static boolean run(BinaryRelationOnOneSet x)
    {
        BinaryRelationOnOneSetRules.isValid(x.getConditionPairsMustSatisfy());

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