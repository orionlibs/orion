package com.orion.math.set.relation.binary.tasks.oneset.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import java.util.List;

public class IsBinaryRelationOnOneSetTransitiveTask extends Orion
{
    public static boolean run(BinaryRelationOnOneSet x)
    {
        List<List<Object>> combinationsOf3 = CombinatoricsService.getCombinationsWithoutElementRepetition(x.getSet().getAsOrionList(), 3);

        for(List<Object> combinationOf3 : combinationsOf3)
        {

            if(x.doesPairBelongToRelation(Pair.<Object, Object>of(combinationOf3.get(0), combinationOf3.get(1)))
                            && x.doesPairBelongToRelation(Pair.<Object, Object>of(combinationOf3.get(0), combinationOf3.get(1))))
            {

                if(x.doesPairNotBelongToRelation(Pair.<Object, Object>of(combinationOf3.get(0), combinationOf3.get(2))))
                {
                    return false;
                }

            }

        }

        return true;
    }
}