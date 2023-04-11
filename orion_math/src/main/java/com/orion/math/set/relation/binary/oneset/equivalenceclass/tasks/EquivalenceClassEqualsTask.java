package com.orion.math.set.relation.binary.oneset.equivalenceclass.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.set.relation.binary.oneset.equivalenceclass.EquivalenceClass;
import com.orion.math.set.relation.binary.oneset.equivalenceclass.EquivalenceClassRules;

public class EquivalenceClassEqualsTask extends Orion
{
    public static boolean run(EquivalenceClass x, Object object)
    {
        EquivalenceClassRules.isValid(x);

        if(object == null || x.getClass() != object.getClass())
        {
            return false;
        }
        else
        {
            EquivalenceClass other = (EquivalenceClass)object;
            return x.getRepresentativeElement().equals(other.getRepresentativeElement()) && x.getSet().equals(other.getSet());
        }

    }
}