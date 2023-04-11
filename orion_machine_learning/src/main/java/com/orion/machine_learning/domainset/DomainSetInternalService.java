package com.orion.machine_learning.domainset;

import com.orion.machine_learning.domainset.tasks.DomainSetEqualsTask;
import com.orion.machine_learning.domainset.tasks.DomainSetHashCodeTask;
import com.orion.math.MathObject;

class DomainSetInternalService implements MathObject
{
    @SuppressWarnings("rawtypes")
    static boolean equals(DomainSet x, Object y)
    {
        return DomainSetEqualsTask.run(x, y);
    }


    @SuppressWarnings("rawtypes")
    static int hashCode(DomainSet x)
    {
        return DomainSetHashCodeTask.run(x);
    }
}