package com.orion.math.statistics.classes.aclass.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.aclass.StatisticalClassRules;

public class StatisticalClassEqualsTask extends Orion
{
    public static boolean run(StatisticalClass x, Object y)
    {
        StatisticalClassRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            StatisticalClass other = (StatisticalClass)y;
            return x.getValues().equals(other.getValues())
                            && x.getClassIntervalWidth().equal(other.getClassIntervalWidth());
        }

    }
}