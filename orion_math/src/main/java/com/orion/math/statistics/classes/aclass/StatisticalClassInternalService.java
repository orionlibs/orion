package com.orion.math.statistics.classes.aclass;

import com.orion.math.MathObject;
import com.orion.math.statistics.classes.aclass.tasks.StatisticalClassEqualsTask;
import com.orion.math.statistics.classes.aclass.tasks.StatisticalClassHashCodeTask;

class StatisticalClassInternalService implements MathObject
{
    static boolean equals(StatisticalClass x, Object y)
    {
        return StatisticalClassEqualsTask.run(x, y);
    }


    static int hashCode(StatisticalClass x)
    {
        return StatisticalClassHashCodeTask.run(x);
    }
}