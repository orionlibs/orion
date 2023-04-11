package com.orion.math.set.relation.nary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.NTuple;
import com.orion.math.set.relation.nary.NAryRelation;
import java.util.ArrayList;
import java.util.List;

public class UseRecursiveLoopToCreateAllNTuplesForNAryRelationTask extends Orion
{
    public static void run(NAryRelation x, int indexOfNextSet, List<Object> set, List<Object> elementsOfNTuple, OrionList<NTuple> newNTuples)
    {

        if(indexOfNextSet - 1 == 0)
        {
            elementsOfNTuple = new ArrayList<>();
        }

        for(int i = 0; i < set.size(); i++)
        {
            int previousSizeOfElementsOfNtuple = elementsOfNTuple.size();

            for(int j = indexOfNextSet - 1; j < previousSizeOfElementsOfNtuple; j++)
            {
                elementsOfNTuple.remove(elementsOfNTuple.size() - 1);
            }

            elementsOfNTuple.add(set.get(i));

            if(indexOfNextSet == x.getSets().getSize())
            {
                NTuple nTuple = NTuple.of(elementsOfNTuple);

                if(x.getConditionNTuplesMustSatisfy().apply(nTuple))
                {
                    newNTuples.add(nTuple);
                }
                else
                {
                    elementsOfNTuple.remove(indexOfNextSet - 1);
                }

            }
            else
            {
                run(x, (indexOfNextSet + 1), x.getSets().get(indexOfNextSet).getAsList(), elementsOfNTuple, newNTuples);
            }

        }

    }
}