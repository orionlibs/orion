package com.orion.math.set.relation.binary;

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

public class BinaryRelation extends Orion implements MathObject, Cloneable
{
    private OrionSet<Pair<Object, Object>> elements;
    private OrionSet<Object> setA;
    private OrionSet<Object> setB;
    private Condition<Pair<Object, Object>> conditionPairsMustSatisfy;


    public BinaryRelation()
    {
        this.elements = OrionHashSet.<Pair<Object, Object>>of();
        this.setA = OrionHashSet.<Object>of();
        this.setB = OrionHashSet.<Object>of();
    }


    public BinaryRelation(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> setA, OrionSet<Object> setB, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        BinaryRelationRules.isValid(elements, setA, setB);
        this.elements = elements;
        this.setA = setA;
        this.setB = setB;
        this.conditionPairsMustSatisfy = conditionPairsMustSatisfy;
    }


    public BinaryRelation(OrionSet<Object> setA, OrionSet<Object> setB, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        BinaryRelationRules.isValid(setA, setB, conditionPairsMustSatisfy);
        this.setA = setA;
        this.setB = setB;
        this.conditionPairsMustSatisfy = conditionPairsMustSatisfy;
        buildRelations();
    }


    public static BinaryRelation of()
    {
        return new BinaryRelation();
    }


    public static BinaryRelation of(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> setA, OrionSet<Object> setB, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new BinaryRelation(elements, setA, setB, conditionPairsMustSatisfy);
    }


    public static BinaryRelation of(OrionSet<Object> setA, OrionSet<Object> setB, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        return new BinaryRelation(setA, setB, conditionPairsMustSatisfy);
    }


    private void buildRelations()
    {
        OrionList<Pair<Object, Object>> newPairs = OrionArrayList.of();
        BinaryRelationInternalService.recursiveLoopToCreateAllPairs(this, 1, setA.getAsList(), null, newPairs);
        this.elements = OrionHashSet.of(newPairs);
    }


    public int getDegree()
    {
        return 2;
    }


    public boolean doesPairSatisfyCondition(Pair<Object, Object> pair)
    {
        return BinaryRelationInternalService.doesPairSatisfyCondition(this, pair);
    }


    public boolean doesPairNotSatisfyCondition(Pair<Object, Object> pair)
    {
        return !doesPairSatisfyCondition(pair);
    }


    public boolean doExistingPairsSatisfyCondition()
    {
        return BinaryRelationInternalService.doExistingPairsSatisfyCondition(this);
    }


    public boolean doesPairBelongToRelation(Pair<Object, Object> pair)
    {
        return getElements().findAny(p -> pair.equals(pair));
    }


    public boolean couldPairBelongToRelation(Pair<Object, Object> pair)
    {
        BinaryRelationRules.isValid(conditionPairsMustSatisfy);
        return conditionPairsMustSatisfy.apply(pair);
    }


    public boolean doesPairNotBelongToRelation(Pair<Object, Object> pair)
    {
        return !doesPairBelongToRelation(pair);
    }


    @SuppressWarnings("unchecked")
    public BinaryRelation getUnion(BinaryRelation other)
    {
        BinaryRelationRules.doSetAAndSetBMatch(this, other);
        OrionSet<Pair<Object, Object>> newElements = elements.getUnion(other.getElements());
        return BinaryRelation.of(newElements, setA, setB, conditionPairsMustSatisfy);
    }


    @SuppressWarnings("unchecked")
    public BinaryRelation getIntersection(BinaryRelation other)
    {
        BinaryRelationRules.doSetAAndSetBMatch(this, other);
        OrionSet<Pair<Object, Object>> newElements = elements.getIntersection(other.getElements());
        return BinaryRelation.of(newElements, setA, setB, conditionPairsMustSatisfy);
    }


    public BinaryRelation getDifference(BinaryRelation other)
    {
        BinaryRelationRules.doSetAAndSetBMatch(this, other);
        OrionSet<Pair<Object, Object>> newElements = elements.getDifference(other.getElements());
        return BinaryRelation.of(newElements, setA, setB, conditionPairsMustSatisfy);
    }


    public BinaryRelation getSymmetricDifference(BinaryRelation other)
    {
        BinaryRelationRules.doSetAAndSetBMatch(this, other);
        OrionSet<Pair<Object, Object>> newElements = elements.getSymmetricDifference(other.getElements());
        return BinaryRelation.of(newElements, setA, setB, conditionPairsMustSatisfy);
    }


    public BinaryRelation compose(BinaryRelation other)
    {
        return BinaryRelationInternalService.compose(this, other);
    }


    public BinaryRelation reverseRelation()
    {
        OrionSet<Pair<Object, Object>> newPairs = OrionHashSet.of();
        getElements().forAll(pair -> newPairs.add(pair.reversePair()));
        return BinaryRelation.of(newPairs, setB, setA, Condition.of(conditionPairsMustSatisfy.getPredicate().negate()));
    }


    public BinaryRelation getComplement()
    {
        return BinaryRelationInternalService.getComplement(this);
    }


    public Function1x1<ANumber, ANumber> calculateFunctionForThisRelation()
    {
        return BinaryRelationInternalService.calculateFunctionForThisRelation(this);
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
        return BinaryRelationInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return BinaryRelationInternalService.equals(this, object);
    }


    @Override
    public BinaryRelation clone() throws CloneNotSupportedException
    {
        return (BinaryRelation)CloningService.clone(this);
    }


    public BinaryRelation getCopy()
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


    public OrionSet<Object> getSetA()
    {
        return this.setA;
    }


    public OrionSet<Object> getSetB()
    {
        return this.setB;
    }


    public Condition<Pair<Object, Object>> getConditionPairsMustSatisfy()
    {
        return this.conditionPairsMustSatisfy;
    }
}