package com.orion.math.statistics.chart.stemandleafdisplay.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateStemsForStemAndLeafDisplayChartTask extends Orion
{
    public static Map<ANumber, List<ANumber>> run(Vector values)
    {
        Map<ANumber, List<ANumber>> temp = new HashMap<ANumber, List<ANumber>>();

        for(ANumber value : values.getAsList())
        {
            ANumber integerPart = value.getIntegerPart();
            ANumber roundedDecimalPart = value.roundGET(1).getDecimalPart().getIntegerPart();

            if(temp.get(integerPart) == null)
            {
                temp.put(integerPart, new ArrayList<ANumber>());
            }

            temp.get(integerPart).add(roundedDecimalPart);
        }

        temp.entrySet().forEach(entry -> Collections.sort(entry.getValue()));
        return temp;
    }
}