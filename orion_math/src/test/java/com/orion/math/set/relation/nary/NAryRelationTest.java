package com.orion.math.set.relation.nary;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.NTuple;
import com.orion.math.number.ANumber;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class NAryRelationTest
{
    @Test
    public void testNAryRelation_buildRelationsBasedOnCondition()
    {
        OrionList<OrionSet<Object>> sets = OrionArrayList.of();
        OrionSet<Object> set1 = OrionHashSet.of();
        set1.append(Arrays.asList(ANumber.of(1), ANumber.of(2), ANumber.of(3)));
        sets.append(set1);
        OrionSet<Object> set2 = OrionHashSet.of();
        set2.append(Arrays.asList(ANumber.of(2), ANumber.of(3), ANumber.of(4)));
        sets.append(set2);
        OrionSet<Object> set3 = OrionHashSet.of();
        set3.append(Arrays.asList(ANumber.of(3), ANumber.of(4), ANumber.of(5)));
        sets.append(set3);
        Condition<NTuple> conditionNTuplesMustSatisfy = Condition.of(nTuple -> ((ANumber)nTuple.get(0)).isLessThan(((ANumber)nTuple.get(1))) && ((ANumber)nTuple.get(1)).isLessThan(((ANumber)nTuple.get(2))));
        NAryRelation relation = NAryRelation.of(sets, conditionNTuplesMustSatisfy);
        OrionSet<NTuple> nTuples = OrionHashSet.of();
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(3)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(4)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(2), ANumber.of(5)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(3), ANumber.of(4)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(3), ANumber.of(5)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(1), ANumber.of(4), ANumber.of(5)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(2), ANumber.of(3), ANumber.of(4)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(2), ANumber.of(3), ANumber.of(5)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(2), ANumber.of(4), ANumber.of(5)}));
        nTuples.add(NTuple.of(new Object[]
        {ANumber.of(3), ANumber.of(4), ANumber.of(5)}));
        assertTrue(relation.getElements().size() == 10);
        assertTrue(nTuples.equals(relation.getElements()));
    }
}