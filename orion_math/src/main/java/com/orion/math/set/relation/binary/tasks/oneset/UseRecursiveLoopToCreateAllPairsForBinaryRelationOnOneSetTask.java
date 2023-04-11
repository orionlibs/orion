package com.orion.math.set.relation.binary.tasks.oneset;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import java.util.ArrayList;
import java.util.List;

public class UseRecursiveLoopToCreateAllPairsForBinaryRelationOnOneSetTask extends Orion
{
    public static void run(BinaryRelationOnOneSet x, int indexOfNextSet, List<Object> set, List<Object> elementsOfPair, OrionList<Pair<Object, Object>> newPairs)
    {

        if(indexOfNextSet - 1 == 0)
        {
            elementsOfPair = new ArrayList<>();
        }

        for(int i = 0; i < set.size(); i++)
        {
            int previousSizeOfElementsOfPair = elementsOfPair.size();

            for(int j = indexOfNextSet - 1; j < previousSizeOfElementsOfPair; j++)
            {
                elementsOfPair.remove(elementsOfPair.size() - 1);
            }

            elementsOfPair.add(set.get(i));

            if(indexOfNextSet == 2)
            {
                Pair<Object, Object> pair = Pair.of(elementsOfPair.get(0), elementsOfPair.get(1));

                if(x.getConditionPairsMustSatisfy().apply(pair))
                {
                    newPairs.add(pair);
                }
                else
                {
                    elementsOfPair.remove(indexOfNextSet - 1);
                }

            }
            else
            {
                run(x, (indexOfNextSet + 1), set, elementsOfPair, newPairs);
            }

        }

    }
}