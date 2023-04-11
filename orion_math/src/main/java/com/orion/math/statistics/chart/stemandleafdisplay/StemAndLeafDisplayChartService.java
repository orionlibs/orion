package com.orion.math.statistics.chart.stemandleafdisplay;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.chart.stemandleafdisplay.tasks.CalculateStemsForStemAndLeafDisplayChartTask;
import java.util.List;
import java.util.Map;

public class StemAndLeafDisplayChartService extends OrionService
{
    public static Map<ANumber, List<ANumber>> calculateStems(Vector values)
    {
        return CalculateStemsForStemAndLeafDisplayChartTask.run(values);
    }
}