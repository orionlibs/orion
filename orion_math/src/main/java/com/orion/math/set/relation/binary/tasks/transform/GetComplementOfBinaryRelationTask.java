package com.orion.math.set.relation.binary.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.BinaryRelation;
import java.util.List;

public class GetComplementOfBinaryRelationTask extends Orion
{
    public static BinaryRelation run(BinaryRelation x)
    {
        OrionSet<Pair<Object, Object>> newPairs = OrionHashSet.of();
        List<Object> setAList = x.getSetA().getAsList();
        List<Object> setBList = x.getSetB().getAsList();

        for(int i = 0; i < setAList.size(); i++)
        {

            for(int j = 0; j < setBList.size(); j++)
            {
                Pair<Object, Object> pair = Pair.<Object, Object>of(setAList.get(i), setBList.get(j));

                if(x.doesPairNotBelongToRelation(pair))
                {
                    newPairs.add(pair);
                }

            }

        }

        return BinaryRelation.of(newPairs, x.getSetA(), x.getSetB(), x.getConditionPairsMustSatisfy());
    }
}