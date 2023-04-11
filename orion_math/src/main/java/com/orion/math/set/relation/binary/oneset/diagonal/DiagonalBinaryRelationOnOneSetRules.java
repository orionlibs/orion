package com.orion.math.set.relation.binary.oneset.diagonal;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.runnable.predicates.Condition;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;

public class DiagonalBinaryRelationOnOneSetRules extends MathRule
{
    public static void isValid(OrionSet<Pair<Object, Object>> elements, OrionSet<Object> set)
    {
        Assert.notNull(elements, "The Cartesian product elements input cannot be null.");
        Assert.notNull(set, "The set input cannot be null.");

        for(Pair<Object, Object> pair : elements)
        {

            if(!pair.getFirst().equals(pair.getSecond()))
            {
                throw new InvalidArgumentException("All pairs for the relation have to be reflections i.e. for all a in set: (a, a) belongs to the relation.");
            }

        }

    }


    public static void isValid(Condition<Pair<Object, Object>> conditionPairsMustSatisfy)
    {
        Assert.notNull(conditionPairsMustSatisfy, "The conditionPairsMustSatisfy input cannot be null.");
    }


    public static void isValid(DiagonalBinaryRelationOnOneSet relation)
    {
        Assert.notNull(relation, "The relation input cannot be null.");
        isValid(relation.getElements(), relation.getSet());
    }
}