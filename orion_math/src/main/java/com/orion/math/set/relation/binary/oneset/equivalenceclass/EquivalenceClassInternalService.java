package com.orion.math.set.relation.binary.oneset.equivalenceclass;

import com.orion.math.MathObject;
import com.orion.math.set.relation.binary.oneset.equivalenceclass.tasks.EquivalenceClassEqualsTask;
import com.orion.math.set.relation.binary.oneset.equivalenceclass.tasks.EquivalenceClassHashCodeTask;

class EquivalenceClassInternalService implements MathObject
{
    static boolean equals(EquivalenceClass x, Object y)
    {
        return EquivalenceClassEqualsTask.run(x, y);
    }


    static int hashCode(EquivalenceClass x)
    {
        return EquivalenceClassHashCodeTask.run(x);
    }
}