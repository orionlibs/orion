package com.orion.math.set.relation.binary.oneset.equivalenceclass;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.MathRule;

public class EquivalenceClassRules extends MathRule
{
    public static void isValid(Object representativeElement, OrionSet<Object> set)
    {
        Assert.notNull(representativeElement, "The representativeElement input cannot be null.");
        Assert.notNull(set, "The set input cannot be null.");

        if(set.notContains(representativeElement))
        {
            throw new InvalidArgumentException("The given set does not contain the given representative element.");
        }

    }


    public static void isValid(EquivalenceClass equivalenceClass)
    {
        Assert.notNull(equivalenceClass, "The equivalenceClass input cannot be null.");
        isValid(equivalenceClass.getRepresentativeElement(), equivalenceClass.getSet());
    }
}