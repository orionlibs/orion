package com.orion.math.statistics.data.summarytable;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.variable.StatisticalVariable;
import java.util.Map;

public class DataSummaryTable extends Orion
{
    private Map<StatisticalVariable, ANumber> categoriesToPercentagesMapper;


    public DataSummaryTable(Map<StatisticalVariable, ANumber> categoriesToPercentagesMapper)
    {
        DataSummaryTableRules.isValid(categoriesToPercentagesMapper);
        this.categoriesToPercentagesMapper = categoriesToPercentagesMapper;
    }


    public static DataSummaryTable of(Map<StatisticalVariable, ANumber> categoriesToPercentagesMapper)
    {
        return new DataSummaryTable(categoriesToPercentagesMapper);
    }


    public OrionList<Map.Entry<StatisticalVariable, ANumber>> getAsList()
    {
        return OrionArrayList.<Map.Entry<StatisticalVariable, ANumber>>of(getCategoriesToPercentagesMapper().entrySet());
    }


    public Map<StatisticalVariable, ANumber> getCategoriesToPercentagesMapper()
    {
        return this.categoriesToPercentagesMapper;
    }
}