package com.orion.math.number.services;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.precision.tasks.ApplyPrecisionToNumberTask;

public class PrecisionService extends OrionService
{
    public static void setGlobalPrecision(int precision)
    {
        Precision.precision = (precision > 0) ? precision : Precision.precision;
    }


    public static void applyPrecision(ANumber x)
    {
        new ApplyPrecisionToNumberTask().run(x);
    }


    public void applyPrecision(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);
        x.setPrecision(Precision.getValidPrecision(precision));
        applyPrecision(x);
    }
}