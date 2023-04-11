package com.orion.math.set.relation.binary.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.BinaryRelationRules;

public class Compose2BinaryRelationsTask extends Orion
{
    public static BinaryRelation run(BinaryRelation x, BinaryRelation other)
    {
        BinaryRelationRules.isValidForComposition(x, other);
        OrionSet<Pair<Object, Object>> newPairs = OrionHashSet.of();

        for(Pair<Object, Object> pairOfBinaryRelation1 : x.getElements())
        {

            for(Pair<Object, Object> pairOfBinaryRelation2 : other.getElements())
            {

                if(pairOfBinaryRelation1.getSecond().equals(pairOfBinaryRelation2.getFirst()))
                {
                    newPairs.add(Pair.<Object, Object>of(pairOfBinaryRelation1.getFirst(), pairOfBinaryRelation2.getSecond()));
                }

            }

        }

        return BinaryRelation.of(newPairs, x.getSetA(), other.getSetB(), x.getConditionPairsMustSatisfy());
    }
}