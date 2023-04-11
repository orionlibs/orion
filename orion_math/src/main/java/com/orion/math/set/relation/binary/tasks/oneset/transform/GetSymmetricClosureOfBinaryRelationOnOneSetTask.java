package com.orion.math.set.relation.binary.tasks.oneset.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.tuple.Pair;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSet;
import com.orion.math.set.relation.binary.oneset.BinaryRelationOnOneSetRules;
import java.util.List;
import java.util.stream.Collectors;

public class GetSymmetricClosureOfBinaryRelationOnOneSetTask extends Orion
{
    public static BinaryRelationOnOneSet run(BinaryRelationOnOneSet x)
    {
        BinaryRelationOnOneSetRules.isValid(x);
        OrionSet<Pair<Object, Object>> pairs = x.getElements().getCopy();
        OrionList<Object> elements = x.getSet().getAsOrionList();
        List<Pair<Object, Object>> pairsToAdd = elements.forAllPairsCountedOnceFilter((Integer i, Integer j) -> x.doesPairNotBelongToRelation(Pair.<Object, Object>of(elements.get(i), elements.get(j))))
                        .collect(Collectors.toList());
        pairsToAdd.forEach(pair -> pairs.add(pair));
        return BinaryRelationOnOneSet.of(pairs, x.getSet().getCopy(), x.getConditionPairsMustSatisfy());
    }
}