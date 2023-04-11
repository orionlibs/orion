package com.orion.math.statistics.frequency;

import com.orion.math.MathObject;
import com.orion.math.statistics.frequency.tasks.query.FrequencyOfObjectsEqualsTask;
import com.orion.math.statistics.frequency.tasks.query.FrequencyOfObjectsHashCodeTask;

class FrequencyOfObjectsInternalService implements MathObject
{
    static boolean equals(FrequencyOfObjects x, Object y)
    {
        return FrequencyOfObjectsEqualsTask.run(x, y);
    }


    static int hashCode(FrequencyOfObjects x)
    {
        return FrequencyOfObjectsHashCodeTask.run(x);
    }
}