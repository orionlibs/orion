package com.orion.math.set.relation.binary.oneset;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;

public class BinaryRelationOnOneSetRules extends MathRule
{
    public static void isValid(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set)
    {
        Assert.notNull(elements, "The Cartesian product elements input cannot be null.");
        Assert.notNull(set, "The set input cannot be null.");

        for(Pair<Object, Object> pair : elements)
        {

            if(set.notContains(pair.getFirst()))
            {
                throw new InvalidArgumentException("The given set does not contain " + pair.getFirst());
            }

            if(set.notContains(pair.getSecond()))
            {
                throw new InvalidArgumentException("The given set does not contain " + pair.getSecond());
            }

        }

    }


    public static void isValid(OrionSet<Object> set, Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        isValid(conditionPairsMustSatisfy);
        Assert.notNull(set, "The set input cannot be null.");
    }


    public static void isValid(Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        Assert.notNull(conditionPairsMustSatisfy, "The conditionPairsMustSatisfy input cannot be null.");
    }


    public static void isValid(BinaryRelationOnOneSet relation)
    {
        Assert.notNull(relation, "The relation input cannot be null.");
        isValid(relation.getElements(), relation.getSet());
    }
}