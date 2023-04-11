package com.orion.analytics.user;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.runnable.functions.OrionFunction2x1;
import java.math.BigDecimal;

public class AnalyticsUsersPercentageFunction extends Orion
{
    private static OrionFunction2x1<Long, Long, BigDecimal> formula;
    static
    {
        formula = (Long x, Long y) -> (BigDecimal.valueOf((100.0 * x) / y));
    }


    public static BigDecimal run(Long partialNumber, Long totalNumber)
    {
        Assert.notNull(partialNumber, "partialNumber is null.");
        Assert.notNull(totalNumber, "totalNumber is null.");
        return formula.run(partialNumber, totalNumber);
    }


    public static OrionFunction2x1<Long, Long, BigDecimal> getFormula()
    {
        return formula;
    }
}