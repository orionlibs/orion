package com.orion.math.statistics.data.summarytable;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.variable.StatisticalVariable;
import java.util.Map;

public class DataSummaryTableRules extends MathRule
{
    public static void isValid(Map<StatisticalVariable, ANumber> categoriesToPercentagesMapper)
    {
        Assert.notEmpty(categoriesToPercentagesMapper, "The categoriesToPercentagesMapper input cannor be null/empty.");
    }


    public static void isValid(DataSummaryTable dataSummaryTable)
    {
        Assert.notNull(dataSummaryTable, "The dataSummaryTable input cannor be null.");
        isValid(dataSummaryTable.getCategoriesToPercentagesMapper());
    }
}