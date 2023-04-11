package com.orion.machine_learning.domainset.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.domainset.DomainSetRules;

public class DomainSetHashCodeTask extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static int run(DomainSet x)
    {
        DomainSetRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getTrainingData().hashCode();
    }
}