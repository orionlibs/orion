package com.orion.math.set.relation.nary;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.NTuple;
import com.orion.math.MathRule;

public class NAryRelationRules extends MathRule
{
    public static void isValid(OrionSet<NTuple> elements, OrionList<OrionSet<Object>> sets)
    {
        Assert.notNull(elements, "The Cartesian product elements input cannot be null.");
        Assert.notEmpty(sets, "The sets input cannot be null.");
        Assert.hasLengthAtLeast(sets, 1, "For an N-ary relation I need a list of at least 1 set.");

        for(NTuple tuple : elements)
        {

            if(tuple.getSize() != sets.size())
            {
                throw new InvalidArgumentException("The NTuples sizes do not much the number of sets.");
            }
            else
            {

                for(int i = 0; i < sets.size(); i++)
                {

                    if(sets.get(i).notContains(tuple.get(i)))
                    {
                        throw new InvalidArgumentException("The " + i + "th set does not contain " + tuple.get(i));
                    }

                }

            }

        }

    }


    public static void doesNTupleBelongToRelation(NAryRelation relation, NTuple nTuple)
    {
        Assert.notNull(relation, "The relation input cannot be null.");
        Assert.notNull(nTuple, "The nTuple input cannot be null.");

        if(relation.doesNTupleNotBelongToRelation(nTuple))
        {
            throw new InvalidArgumentException("The given nTuple does not belong to the relation.");
        }

    }


    public static void isValid(int nTupleSize, int numberOfFirstNTupleElementsToKeep)
    {
        Assert.isLessThanOrEqualTo(numberOfFirstNTupleElementsToKeep, nTupleSize, "The given numberOfFirstNTupleElementsToKeep has to be less than the nTupleSize.");
    }


    public static void isValid(OrionList<OrionSet<Object>> sets, Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        Assert.notNull(sets, "The sets input cannot be null.");
        isValid(conditionNTuplesMustSatisfy);
    }


    public static void isValidForJoin(int degreeOfRelation1, int degreeOfRelation2, int numberOfNTupleElementsThatHaveToAgree)
    {
        Assert.isLessThanOrEqualTo(numberOfNTupleElementsThatHaveToAgree, degreeOfRelation1, "The given numberOfNTupleElementsThatHaveToAgree has to be <= the degree of relation1.");
        Assert.isLessThanOrEqualTo(numberOfNTupleElementsThatHaveToAgree, degreeOfRelation2, "The given numberOfNTupleElementsThatHaveToAgree has to be <= the degree of relation2.");
    }


    public static void isValid(Condition<NTuple> conditionNTuplesMustSatisfy)
    {
        Assert.notNull(conditionNTuplesMustSatisfy, "The conditionNTuplesMustSatisfy input cannot be null.");
    }


    public static void isValid(NAryRelation relation)
    {
        Assert.notNull(relation, "The relation input cannot be null.");
        isValid(relation.getElements(), relation.getSets());
    }
}