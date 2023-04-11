package com.orion.math.statistics.data.fivenumbersummary;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.data.quartile.Quartiles;

public class FiveNumberSummary extends Orion
{
    private Vector numbers;
    private ANumber minimum;
    private ANumber maximum;
    private ANumber quartile1;
    private ANumber median;
    private ANumber quartile3;


    public FiveNumberSummary(Vector numbers)
    {
        FiveNumberSummaryRules.isValid(numbers);
        this.numbers = numbers;
        this.minimum = numbers.getMinimum();
        this.maximum = numbers.getMaximum();
        Quartiles quartiles = Quartiles.of(numbers);
        this.quartile1 = quartiles.getQuartile1();
        this.median = quartiles.getQuartile2();
        this.quartile3 = quartiles.getQuartile3();
    }


    public static FiveNumberSummary of(Vector numbers)
    {
        return new FiveNumberSummary(numbers);
    }


    public Vector getNumbers()
    {
        return this.numbers;
    }


    public ANumber getMinimum()
    {
        return this.minimum;
    }


    public ANumber getMaximum()
    {
        return this.maximum;
    }


    public ANumber getQuartile1()
    {
        return this.quartile1;
    }


    public ANumber getMedian()
    {
        return this.median;
    }


    public ANumber getQuartile3()
    {
        return this.quartile3;
    }
}