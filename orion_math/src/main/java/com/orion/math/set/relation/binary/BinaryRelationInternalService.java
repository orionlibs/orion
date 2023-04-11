package com.orion.math.set.relation.binary;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.set.relation.binary.tasks.BinaryRelationEqualsTask;
import com.orion.math.set.relation.binary.tasks.BinaryRelationHashCodeTask;
import com.orion.math.set.relation.binary.tasks.UseRecursiveLoopToCreateAllPairsForBinaryRelationTask;
import com.orion.math.set.relation.binary.tasks.query.CalculateFunctionForBinaryRelationTask;
import com.orion.math.set.relation.binary.tasks.query.DoExistingPairsSatisfyConditionOfBinaryRelationTask;
import com.orion.math.set.relation.binary.tasks.query.DoesPairSatisfyConditionOfBinaryRelationTask;
import com.orion.math.set.relation.binary.tasks.transform.Compose2BinaryRelationsTask;
import com.orion.math.set.relation.binary.tasks.transform.GetComplementOfBinaryRelationTask;
import java.util.List;

class BinaryRelationInternalService implements MathObject
{
    static boolean equals(BinaryRelation x, Object y)
    {
        return BinaryRelationEqualsTask.run(x, y);
    }


    static int hashCode(BinaryRelation x)
    {
        return BinaryRelationHashCodeTask.run(x);
    }


    static boolean doesPairSatisfyCondition(BinaryRelation x, Pair<Object, Object> pair)
    {
        return DoesPairSatisfyConditionOfBinaryRelationTask.run(x, pair);
    }


    static boolean doExistingPairsSatisfyCondition(BinaryRelation x)
    {
        return DoExistingPairsSatisfyConditionOfBinaryRelationTask.run(x);
    }


    static void recursiveLoopToCreateAllPairs(BinaryRelation x, int indexOfNextSet, List<Object> set, List<Object> elementsOfPair, OrionList<Pair<Object, Object>> newPairs)
    {
        UseRecursiveLoopToCreateAllPairsForBinaryRelationTask.run(x, indexOfNextSet, set, elementsOfPair, newPairs);
    }


    static BinaryRelation compose(BinaryRelation x, BinaryRelation other)
    {
        return Compose2BinaryRelationsTask.run(x, other);
    }


    static BinaryRelation getComplement(BinaryRelation x)
    {
        return GetComplementOfBinaryRelationTask.run(x);
    }


    static Function1x1<ANumber, ANumber> calculateFunctionForThisRelation(BinaryRelation x)
    {
        return CalculateFunctionForBinaryRelationTask.run(x);
    }
}