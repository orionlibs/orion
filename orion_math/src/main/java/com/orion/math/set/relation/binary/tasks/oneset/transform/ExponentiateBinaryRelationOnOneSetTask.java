package com.orion.math.set.relation.binary.tasks.oneset.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.NumberRules;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;

public class ExponentiateBinaryRelationOnOneSetTask extends Orion
{
    public static BinaryRelationOnOneSet run(BinaryRelationOnOneSet x, int n)
    {
        NumberRules.isGreaterThanOrEqual(n, 1);

        if(n == 1)
        {
            return x.getCopy();
        }
        else
        {
            BinaryRelation thisRelationAsBinary = BinaryRelation.of(x.getElements(), x.getSet(), x.getSet(), x.getConditionPairsMustSatisfy());
            BinaryRelation newRelationAsBinary = thisRelationAsBinary;

            for(int i = 2; i <= n; i++)
            {
                newRelationAsBinary = newRelationAsBinary.compose(thisRelationAsBinary);
            }

            return BinaryRelationOnOneSet.of(newRelationAsBinary.getElements(), x.getSet(), x.getConditionPairsMustSatisfy());
        }

    }
}