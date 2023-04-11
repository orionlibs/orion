package com.orion.math.set.relation.binary.oneset;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;

public class BinaryRelationOnOneSet extends Orion implements MathObject, Cloneable
{
    private OrionSet<Pair<Object, Object>> elements;
    private OrionSet<Object> set;
    private Condition<Pair<Object, Object>> conditionPairsMustSatisfy;


    public BinaryRelationOnOneSet()
    {
        this.elements = OrionHashSet.<Pair<Object, Object>>of();
        this.set = OrionHashSet.<Object>of();
    }


    public BinaryRelationOnOneSet(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        BinaryRelationOnOneSetRules.isValid(elements, set);
        this.elements = elements;
        this.set = set;
        this.conditionPairsMustSatisfy = conditionPairsMustSatisfy;
    }


    public BinaryRelationOnOneSet(OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        BinaryRelationOnOneSetRules.isValid(set, conditionPairsMustSatisfy);
        this.set = set;
        this.conditionPairsMustSatisfy = conditionPairsMustSatisfy;
        buildRelations();
    }


    public static BinaryRelationOnOneSet of()
    {
        return new BinaryRelationOnOneSet();
    }


    public static BinaryRelationOnOneSet of(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new BinaryRelationOnOneSet(elements, set, conditionPairsMustSatisfy);
    }


    public static BinaryRelationOnOneSet of(OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new BinaryRelationOnOneSet(set, conditionPairsMustSatisfy);
    }


    private void buildRelations()
    {
        OrionList<Pair<Object, Object>> newPairs = OrionArrayList.of();
        BinaryRelationOnOneSetInternalService.recursiveLoopToCreateAllPairs(this, 1, set.getAsList(), null, newPairs);
        this.elements = OrionHashSet.of(newPairs);
    }


    public int getDegree()
    {
        return 2;
    }


    public boolean doesPairSatisfyCondition(Pair<Object, Object> pair)
    {
        return BinaryRelationOnOneSetInternalService.doesPairSatisfyCondition(this, pair);
    }


    public boolean doesPairNotSatisfyCondition(Pair<Object, Object> pair)
    {
        return !doesPairSatisfyCondition(pair);
    }


    public boolean doExistingPairsSatisfyCondition()
    {
        return BinaryRelationOnOneSetInternalService.doExistingPairsSatisfyCondition(this);
    }


    public boolean doesPairBelongToRelation(Pair<Object, Object> pair)
    {
        return getElements().findAny(p -> pair.equals(pair));
    }


    public boolean doesPairNotBelongToRelation(Pair<Object, Object> pair)
    {
        return !doesPairBelongToRelation(pair);
    }


    public boolean couldPairBelongToRelation(Pair<Object, Object> pair)
    {
        BinaryRelationOnOneSetRules.isValid(conditionPairsMustSatisfy);
        return conditionPairsMustSatisfy.apply(pair);
    }


    public boolean isReflexive()
    {
        return !set.findAny(x -> doesPairNotBelongToRelation(Pair.<Object, Object>of(x, x)));
    }


    public boolean isIrreflexive()
    {
        return set.findNone(x -> doesPairBelongToRelation(Pair.<Object, Object>of(x, x)));
    }


    public boolean isSymmetric()
    {
        OrionList<Object> list = set.getAsOrionList();
        return list.forAllPairsCountedOnceFilter((Integer i, Integer j) -> doesPairBelongToRelation(Pair.<Object, Object>of(list.get(i), list.get(j)))
                        && doesPairNotBelongToRelation(Pair.<Object, Object>of(list.get(j), list.get(i)))).count() == 0L;
    }


    public boolean isAsymmetric()
    {
        OrionList<Object> list = set.getAsOrionList();
        long numberOfPairsCountedOnce = list.getNumberOfAllPairsCountedOnce();
        return list.forAllPairsCountedOnceFilter((Integer i, Integer j) -> doesPairBelongToRelation(Pair.<Object, Object>of(list.get(i), list.get(j)))
                        && doesPairNotBelongToRelation(Pair.<Object, Object>of(list.get(j), list.get(i)))).count() == numberOfPairsCountedOnce;
    }


    public boolean isAntisymmetric()
    {
        OrionList<Object> list = set.getAsOrionList();
        return list.forAllPairsCountedOnceFilter((Integer i, Integer j) -> doesPairBelongToRelation(Pair.<Object, Object>of(list.get(i), list.get(j)))
                        && doesPairBelongToRelation(Pair.<Object, Object>of(list.get(j), list.get(i)))).count() == 0L;
    }


    public boolean isTransitive()
    {
        return BinaryRelationOnOneSetInternalService.isTransitive(this);
    }


    public BinaryRelationOnOneSet exponentiate(int n)
    {
        return BinaryRelationOnOneSetInternalService.exponentiate(this, n);
    }


    public BinaryRelationOnOneSet getReflexiveClosure()
    {
        return BinaryRelationOnOneSetInternalService.getReflexiveClosure(this);
    }


    public BinaryRelationOnOneSet getSymmetricClosure()
    {
        return BinaryRelationOnOneSetInternalService.getSymmetricClosure(this);
    }


    public Function1x1<ANumber, ANumber> calculateFunctionForThisRelation()
    {
        return BinaryRelationOnOneSetInternalService.calculateFunctionForThisRelation(this);
    }


    public boolean isEquivalenceRelation()
    {
        return isReflexive() && isSymmetric() && isTransitive();
    }


    public boolean areElementsEquivalent(Pair<Object, Object> pair)
    {
        return doesPairBelongToRelation(pair) && isEquivalenceRelation();
    }


    public boolean isPartialOrderingRelation()
    {
        return isReflexive() && isAntisymmetric() && isTransitive();
    }


    public BinaryRelationOnOneSet invertRelation()
    {
        OrionSet<Pair<Object, Object>> newElements = OrionHashSet.of(getElements().mapToSet(pair -> pair.reversePair()));
        Condition<Pair<Object, Object>> newConditionPairsMustSatisfy = conditionPairsMustSatisfy.getCopy();
        newConditionPairsMustSatisfy.not();
        return BinaryRelationOnOneSet.of(newElements, set.getCopy(), newConditionPairsMustSatisfy);
    }


    public int getSize()
    {
        return getElements().getSize();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public boolean isNotEmpty()
    {
        return !getElements().isEmpty();
    }


    @Override
    public int hashCode()
    {
        return BinaryRelationOnOneSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return BinaryRelationOnOneSetInternalService.equals(this, object);
    }


    @Override
    public BinaryRelationOnOneSet clone() throws CloneNotSupportedException
    {
        return (BinaryRelationOnOneSet)CloningService.clone(this);
    }


    public BinaryRelationOnOneSet getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public OrionSet<Pair<Object, Object>> getElements()
    {
        return this.elements;
    }


    public OrionSet<Object> getSet()
    {
        return this.set;
    }


    public Condition<Pair<Object, Object>> getConditionPairsMustSatisfy()
    {
        return this.conditionPairsMustSatisfy;
    }
}