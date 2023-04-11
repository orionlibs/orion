package com.orion.math.statistics.data.fivenumbersummary;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class FiveNumberSummaryRules extends MathRule
{
    public static void isValid(Vector numbers)
    {
        VectorRules.isValid(numbers);
    }


    public static void isValid(FiveNumberSummary fiveNumberSummary)
    {
        Assert.notNull(fiveNumberSummary, "The fiveNumberSummary input cannor be null.");
        isValid(fiveNumberSummary.getNumbers());
    }
}