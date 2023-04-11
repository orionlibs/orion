package com.orion.math.statistics.data.contingencytable;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class DataContingencyTableRules extends MathRule
{
    public static void isValid(DataContingencyTable dataContingencyTable)
    {
        Assert.notNull(dataContingencyTable, "The dataContingencyTable input cannor be null.");
    }
}