package com.orion.math.statistics.classes.aclass.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.aclass.StatisticalClassRules;

public class StatisticalClassHashCodeTask extends Orion
{
    public static int run(StatisticalClass x)
    {
        StatisticalClassRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getValues().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getClassIntervalWidth().hashCode();
    }
}