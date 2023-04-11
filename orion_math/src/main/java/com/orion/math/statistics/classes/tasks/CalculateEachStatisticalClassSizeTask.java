package com.orion.math.statistics.classes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import java.util.HashMap;
import java.util.Map;

public class CalculateEachStatisticalClassSizeTask extends Orion
{
    public static Map<StatisticalClass, Integer> run(Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        Map<StatisticalClass, Integer> temp = new HashMap<StatisticalClass, Integer>();

        for(Map.Entry<ANumber, StatisticalClass> valueAndClass : valuesAndClassMembershipMapper.entrySet())
        {

            if(temp.get(valueAndClass.getValue()) != null)
            {
                temp.put(valueAndClass.getValue(), temp.get(valueAndClass.getValue()) + 1);
            }
            else
            {
                temp.put(valueAndClass.getValue(), 1);
            }

        }

        return temp;
    }
}