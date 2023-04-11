package com.orion.math.set.relation.binary;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;

public class BinaryRelationRules extends MathRule
{
    public static void isValid(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> setA, OrionSet<Object> setB)
    {
        Assert.notNull(elements, "The Cartesian product elements input cannot be null.");
        Assert.notEmpty(setA, "The setA input cannot be null.");
        Assert.notEmpty(setB, "The setB input cannot be null.");

        for(Pair<Object, Object> pair : elements)
        {

            if(setA.notContains(pair.getFirst()))
            {
                throw new InvalidArgumentException("The given setA does not contain " + pair.getFirst());
            }

            if(setB.notContains(pair.getSecond()))
            {
                throw new InvalidArgumentException("The given setB does not contain " + pair.getSecond());
            }

        }

    }


    public static void isValid(OrionSet<Object> setA, OrionSet<Object> setB, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        Assert.notEmpty(setA, "The setA input cannot be null.");
        Assert.notEmpty(setB, "The setB input cannot be null.");
        isValid(conditionPairsMustSatisfy);
    }


    public static void isValid(Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        Assert.notNull(conditionPairsMustSatisfy, "The conditionPairsMustSatisfy input cannot be null.");
    }


    public static void isValid(BinaryRelation relation)
    {
        Assert.notNull(relation, "The relation input cannot be null.");
        isValid(relation.getElements(), relation.getSetA(), relation.getSetB());
    }


    public static void doSetAAndSetBMatch(BinaryRelation binaryRelation1, BinaryRelation binaryRelation2)
    {
        isValid(binaryRelation2);
        Assert.isTrue(binaryRelation1.getSetA().equals(binaryRelation2.getSetA()), "The setA is different in the 2 given binary relations.");
        Assert.isTrue(binaryRelation1.getSetB().equals(binaryRelation2.getSetB()), "The setB is different in the 2 given binary relations.");
    }


    public static void isValidForComposition(BinaryRelation binaryRelation1, BinaryRelation binaryRelation2)
    {
        isValid(binaryRelation2);
        Assert.isTrue(binaryRelation1.getSetB().equals(binaryRelation2.getSetA()), "The setB in binaryRelation1 has to match the setA of binaryRelation2.");
    }
}