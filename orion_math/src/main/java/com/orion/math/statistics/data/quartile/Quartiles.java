package com.orion.math.statistics.data.quartile;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.StatisticsService;
import java.util.List;
import java.util.stream.Collectors;

public class Quartiles extends Orion
{
    private Vector numbers;
    private ANumber quartile1;
    private ANumber quartile2;
    private ANumber quartile3;
    private Vector getNumbersLessThanOrEqualToQuartile1;
    private Vector getNumbersBetweenQuartile1And2;
    private Vector getNumbersBetweenQuartile2And3;
    private Vector getNumbersGreaterThanQuartile3;


    public Quartiles(Vector numbers)
    {
        QuartilesRules.isValid(numbers);
        this.numbers = numbers.sortGET();
        this.quartile1 = StatisticsService.getPercentile(numbers, 25);
        this.quartile2 = StatisticsService.getMedian(numbers);
        this.quartile3 = StatisticsService.getPercentile(numbers, 75);
        this.getNumbersLessThanOrEqualToQuartile1 = calculateNumbersLessThanOrEqualToQuartile1();
        this.getNumbersBetweenQuartile1And2 = calculateNumbersBetweenQuartile1And2();
        this.getNumbersBetweenQuartile2And3 = calculateNumbersBetweenQuartile2And3();
        this.getNumbersGreaterThanQuartile3 = calculateNumbersGreaterThanQuartile3();
    }


    public static Quartiles of(Vector numbers)
    {
        return new Quartiles(numbers);
    }


    private Vector calculateNumbersLessThanOrEqualToQuartile1()
    {
        List<ANumber> values = numbers.getStream().filter(x -> x.isLessThanOrEqual(quartile1)).collect(Collectors.toList());
        return Vector.of(values);
    }


    private Vector calculateNumbersBetweenQuartile1And2()
    {
        List<ANumber> values = numbers.getStream()
                        .filter(x -> x.isGreaterThanOrEqual(quartile1) || x.isLessThanOrEqual(quartile2)).collect(Collectors.toList());
        return Vector.of(values);
    }


    private Vector calculateNumbersBetweenQuartile2And3()
    {
        List<ANumber> values = numbers.getStream()
                        .filter(x -> x.isGreaterThanOrEqual(quartile2) || x.isLessThanOrEqual(quartile3)).collect(Collectors.toList());
        return Vector.of(values);
    }


    private Vector calculateNumbersGreaterThanQuartile3()
    {
        List<ANumber> values = numbers.getStream()
                        .filter(x -> x.isGreaterThanOrEqual(quartile3)).collect(Collectors.toList());
        return Vector.of(values);
    }


    public Vector getNumbers()
    {
        return this.numbers;
    }


    public ANumber getQuartile1()
    {
        return this.quartile1;
    }


    public ANumber getQuartile2()
    {
        return this.quartile2;
    }


    public ANumber getQuartile3()
    {
        return this.quartile3;
    }


    public Vector getGetNumbersLessThanOrEqualToQuartile1()
    {
        return this.getNumbersLessThanOrEqualToQuartile1;
    }


    public Vector getGetNumbersBetweenQuartile1And2()
    {
        return this.getNumbersBetweenQuartile1And2;
    }


    public Vector getGetNumbersBetweenQuartile2And3()
    {
        return this.getNumbersBetweenQuartile2And3;
    }


    public Vector getGetNumbersGreaterThanQuartile3()
    {
        return this.getNumbersGreaterThanQuartile3;
    }
}