package com.orion.math.set.relation.binary.tasks.oneset.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSetRules;

public class GetReflexiveClosureOfBinaryRelationOnOneSetTask extends Orion
{
    public static BinaryRelationOnOneSet run(BinaryRelationOnOneSet x)
    {
        BinaryRelationOnOneSetRules.isValid(x);
        OrionSet<Pair<Object, Object>> pairs = x.getElements().getCopy();

        for(Object element : x.getSet())
        {
            Pair<Object, Object> newPair = Pair.<Object, Object>of(element, element);

            if(x.doesPairNotBelongToRelation(newPair))
            {
                pairs.add(newPair);
            }

        }

        return BinaryRelationOnOneSet.of(pairs, x.getSet().getCopy(), x.getConditionPairsMustSatisfy());
    }
}