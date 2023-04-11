package com.orion.math.set.relation.binary.oneset;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.set.relation.binary.BinaryRelation;
import com.orion.math.set.relation.binary.tasks.oneset.BinaryRelationOnOneSetEqualsTask;
import com.orion.math.set.relation.binary.tasks.oneset.BinaryRelationOnOneSetHashCodeTask;
import com.orion.math.set.relation.binary.tasks.oneset.UseRecursiveLoopToCreateAllPairsForBinaryRelationOnOneSetTask;
import com.orion.math.set.relation.binary.tasks.oneset.query.DoExistingPairsSatisfyConditionOfBinaryRelationOnOneSetTask;
import com.orion.math.set.relation.binary.tasks.oneset.query.DoesPairSatisfyConditionOfBinaryRelationOnOneSetTask;
import com.orion.math.set.relation.binary.tasks.oneset.query.IsBinaryRelationOnOneSetTransitiveTask;
import com.orion.math.set.relation.binary.tasks.oneset.transform.ExponentiateBinaryRelationOnOneSetTask;
import com.orion.math.set.relation.binary.tasks.oneset.transform.GetReflexiveClosureOfBinaryRelationOnOneSetTask;
import com.orion.math.set.relation.binary.tasks.oneset.transform.GetSymmetricClosureOfBinaryRelationOnOneSetTask;
import java.util.List;

class BinaryRelationOnOneSetInternalService implements MathObject
{
    static boolean equals(BinaryRelationOnOneSet x, Object y)
    {
        return BinaryRelationOnOneSetEqualsTask.run(x, y);
    }


    static int hashCode(BinaryRelationOnOneSet x)
    {
        return BinaryRelationOnOneSetHashCodeTask.run(x);
    }


    static boolean doesPairSatisfyCondition(BinaryRelationOnOneSet x, Pair<Object, Object> pair)
    {
        return DoesPairSatisfyConditionOfBinaryRelationOnOneSetTask.run(x, pair);
    }


    static boolean doExistingPairsSatisfyCondition(BinaryRelationOnOneSet x)
    {
        return DoExistingPairsSatisfyConditionOfBinaryRelationOnOneSetTask.run(x);
    }


    static void recursiveLoopToCreateAllPairs(BinaryRelationOnOneSet x, int indexOfNextSet, List<Object> set, List<Object> elementsOfPair, OrionList<Pair<Object, Object>> newPairs)
    {
        UseRecursiveLoopToCreateAllPairsForBinaryRelationOnOneSetTask.run(x, indexOfNextSet, set, elementsOfPair, newPairs);
    }


    static boolean isTransitive(BinaryRelationOnOneSet x)
    {
        return IsBinaryRelationOnOneSetTransitiveTask.run(x);
    }


    static BinaryRelationOnOneSet exponentiate(BinaryRelationOnOneSet x, int n)
    {
        return ExponentiateBinaryRelationOnOneSetTask.run(x, n);
    }


    static BinaryRelationOnOneSet getReflexiveClosure(BinaryRelationOnOneSet x)
    {
        return GetReflexiveClosureOfBinaryRelationOnOneSetTask.run(x);
    }


    static BinaryRelationOnOneSet getSymmetricClosure(BinaryRelationOnOneSet x)
    {
        return GetSymmetricClosureOfBinaryRelationOnOneSetTask.run(x);
    }


    static Function1x1<ANumber, ANumber> calculateFunctionForThisRelation(BinaryRelationOnOneSet x)
    {
        return BinaryRelation.of(x.getElements(), x.getSet(), x.getSet(), x.getConditionPairsMustSatisfy()).calculateFunctionForThisRelation();
    }
}