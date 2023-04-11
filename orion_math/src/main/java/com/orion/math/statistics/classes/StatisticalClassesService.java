package com.orion.math.statistics.classes;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.tasks.CalculateEachStatisticalClassSizeTask;
import java.util.Map;

public class StatisticalClassesService extends OrionService
{
    public static Map<StatisticalClass, Integer> calculateEachClassSize(Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        return CalculateEachStatisticalClassSizeTask.run(valuesAndClassMembershipMapper);
    }
}