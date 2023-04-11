package com.orion.math.set.relation.nary;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.object.CloningService;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.NTuple;
import com.orion.math.MathObject;
import java.util.List;

public class NAryRelation extends Orion implements MathObject, Cloneable
{
    private OrionSet<NTuple> elements;
    private OrionList<OrionSet<Object>> sets;
    private Condition<NTuple> conditionNTuplesMustSatisfy;


    @SuppressWarnings("unchecked")
    public NAryRelation()
    {
        this.elements = OrionHashSet.<NTuple>of();
        this.sets = OrionArrayList.<OrionSet<Object>>of(OrionHashSet.<Object>of());
    }


    public NAryRelation(OrionSet<NTuple> elements, OrionList<OrionSet<Object>> sets, Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        NAryRelationRules.isValid(elements, sets);
        this.elements = elements;
        this.sets = sets;
        this.conditionNTuplesMustSatisfy = conditionNTuplesMustSatisfy;
    }


    public NAryRelation(OrionList<OrionSet<Object>> sets, Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        NAryRelationRules.isValid(sets, conditionNTuplesMustSatisfy);
        this.sets = sets;
        this.conditionNTuplesMustSatisfy = conditionNTuplesMustSatisfy;
        buildRelations();
    }


    public static NAryRelation of()
    {
        return new NAryRelation();
    }


    public static NAryRelation of(OrionSet<NTuple> elements, OrionList<OrionSet<Object>> sets, Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        return new NAryRelation(elements, sets, conditionNTuplesMustSatisfy);
    }


    public static NAryRelation of(OrionList<OrionSet<Object>> sets, Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        return new NAryRelation(sets, conditionNTuplesMustSatisfy);
    }


    private void buildRelations()
    {
        OrionList<NTuple> newNTuples = OrionArrayList.of();
        NAryRelationInternalService.recursiveLoopToCreateAllNTuples(this, 1, sets.get(0).getAsList(), null, newNTuples);
        this.elements = OrionHashSet.of(newNTuples);
    }


    public NTuple getProjectionOfNTuple(NTuple nTuple, int numberOfFirstNTupleElementsToKeep)
    {
        NAryRelationRules.doesNTupleBelongToRelation(this, nTuple);
        NAryRelationRules.isValid(sets.getSize(), numberOfFirstNTupleElementsToKeep);
        List<Object> newElements = nTuple.getAsList().subList(0, numberOfFirstNTupleElementsToKeep);
        return NTuple.of(newElements);
    }


    public NAryRelation join(NAryRelation other, int numberOfNTupleElementsThatHaveToAgree)
    {
        return NAryRelationInternalService.join(this, other, numberOfNTupleElementsThatHaveToAgree);
    }


    public int getDegree()
    {
        return sets.getSize();
    }


    public boolean doesNTupleSatisfyCondition(NTuple nTuple)
    {
        return NAryRelationInternalService.doesNTupleSatisfyCondition(this, nTuple);
    }


    public boolean doesNTupleNotSatisfyCondition(NTuple nTuple)
    {
        return !doesNTupleSatisfyCondition(nTuple);
    }


    public boolean doExistingNTuplesSatisfyCondition()
    {
        return NAryRelationInternalService.doExistingNTuplesSatisfyCondition(this);
    }


    public boolean doesNTupleBelongToRelation(NTuple nTuple)
    {
        return getElements().findAny(tuple -> tuple.equals(nTuple));
    }


    public boolean doesNTupleNotBelongToRelation(NTuple nTuple)
    {
        return !doesNTupleBelongToRelation(nTuple);
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
        return NAryRelationInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return NAryRelationInternalService.equals(this, object);
    }


    @Override
    public NAryRelation clone() throws CloneNotSupportedException
    {
        return (NAryRelation)CloningService.clone(this);
    }


    public NAryRelation getCopy()
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


    public OrionSet<NTuple> getElements()
    {
        return this.elements;
    }


    public OrionList<OrionSet<Object>> getSets()
    {
        return this.sets;
    }


    public Condition<NTuple> getConditionNTuplesMustSatisfy()
    {
        return this.conditionNTuplesMustSatisfy;
    }
}