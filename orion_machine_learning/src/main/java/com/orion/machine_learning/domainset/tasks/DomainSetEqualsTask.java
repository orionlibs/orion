package com.orion.machine_learning.domainset.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.domainset.DomainSetRules;

public class DomainSetEqualsTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static boolean run(DomainSet x, Object y)
    {
        DomainSetRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return x.getTrainingData().equals(((DomainSet)y).getTrainingData());
        }

    }
}