package com.orion.math.set.relation.nary;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.NTuple;
import com.orion.math.MathObject;
import com.orion.math.set.relation.nary.tasks.RelationEqualsTask;
import com.orion.math.set.relation.nary.tasks.RelationHashCodeTask;
import com.orion.math.set.relation.nary.tasks.UseRecursiveLoopToCreateAllNTuplesForNAryRelationTask;
import com.orion.math.set.relation.nary.tasks.query.DoExistingNTuplesSatisfyConditionOfBinaryRelationTask;
import com.orion.math.set.relation.nary.tasks.query.DoesNTupleSatisfyConditionOfBinaryRelationTask;
import com.orion.math.set.relation.nary.tasks.transform.Join2BinaryRelationsTask;
import java.util.List;

class NAryRelationInternalService implements MathObject
{
    static boolean equals(NAryRelation x, Object y)
    {
        return RelationEqualsTask.run(x, y);
    }


    static int hashCode(NAryRelation x)
    {
        return RelationHashCodeTask.run(x);
    }


    static boolean doesNTupleSatisfyCondition(NAryRelation x, NTuple nTuple)
    {
        return DoesNTupleSatisfyConditionOfBinaryRelationTask.run(x, nTuple);
    }


    static boolean doExistingNTuplesSatisfyCondition(NAryRelation x)
    {
        return DoExistingNTuplesSatisfyConditionOfBinaryRelationTask.run(x);
    }


    static void recursiveLoopToCreateAllNTuples(NAryRelation x, int indexOfNextSet, List<Object> set, List<Object> elementsOfNTuple, OrionList<NTuple> newNTuples)
    {
        UseRecursiveLoopToCreateAllNTuplesForNAryRelationTask.run(x, indexOfNextSet, set, elementsOfNTuple, newNTuples);
    }


    static NAryRelation join(NAryRelation x, NAryRelation other, int numberOfNTupleElementsThatHaveToAgree)
    {
        return Join2BinaryRelationsTask.run(x, other, numberOfNTupleElementsThatHaveToAgree);
    }
}