package com.orion.math.set.relation.nary.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.tuple.NTuple;
import com.orion.math.set.relation.nary.NAryRelation;
import com.orion.math.set.relation.nary.NAryRelationRules;
import java.util.List;
import java.util.stream.IntStream;

public class Join2BinaryRelationsTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static NAryRelation run(NAryRelation x, NAryRelation other, int numberOfNTupleElementsThatHaveToAgree)
    {
        NAryRelationRules.isValid(other);
        NAryRelationRules.isValid(x.getConditionNTuplesMustSatisfy());
        NAryRelationRules.isValid(other.getConditionNTuplesMustSatisfy());
        NAryRelationRules.isValidForJoin(x.getDegree(), other.getDegree(), numberOfNTupleElementsThatHaveToAgree);
        OrionSet<NTuple> newNTuples = OrionHashSet.of();

        for(NTuple nTupleOfRelation1 : x.getElements())
        {
            List<Object> secondPartOfNTuple1 = nTupleOfRelation1.getAsList().subList(numberOfNTupleElementsThatHaveToAgree, nTupleOfRelation1.getSize());

            for(NTuple nTupleOfRelation2 : other.getElements())
            {
                List<Object> firstPartOfNTuple2 = nTupleOfRelation2.getAsList().subList(0, numberOfNTupleElementsThatHaveToAgree);

                if(secondPartOfNTuple1.equals(firstPartOfNTuple2))
                {
                    List<Object> newNTupleElements = nTupleOfRelation1.getAsList();
                    newNTupleElements.addAll(nTupleOfRelation2.getAsList().subList(numberOfNTupleElementsThatHaveToAgree, nTupleOfRelation2.getSize()));
                    newNTuples.add(NTuple.of(newNTupleElements));
                }

            }

        }

        OrionList<OrionSet<Object>> newSets = OrionArrayList.of();
        IntStream.range(0, x.getSets().getSize() - numberOfNTupleElementsThatHaveToAgree)
                        .forEach(i -> newSets.add(x.getSets().get(i)));
        IntStream.range(numberOfNTupleElementsThatHaveToAgree, x.getSets().getSize())
                        .forEach(i -> newSets.add(x.getSets().get(i).getUnion(other.getSets().get(i - numberOfNTupleElementsThatHaveToAgree))));
        IntStream.range(numberOfNTupleElementsThatHaveToAgree, other.getSets().getSize())
                        .forEach(i -> newSets.add(other.getSets().get(i)));
        return NAryRelation.of(newNTuples, newSets, null);
    }
}