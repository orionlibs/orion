package com.orion.math.statistics.classes;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.aclass.StatisticalClassIntervalComparator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticalClasses extends Orion
{
    private OrionList<StatisticalClass> statisticalClasses;
    private OrionList<StatisticalClass> statisticalClassesOrderedByInterval;
    private int numberOfclasses;
    private Vector values;
    private Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper;
    private Map<StatisticalClass, Integer> classSizeMapper;
    private List<Interval> classesIntervals;
    private ANumber mimimumValue;
    private ANumber maximumValue;


    public StatisticalClasses(OrionList<StatisticalClass> statisticalClasses, Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        StatisticalClassesRules.isValid(statisticalClasses);
        this.statisticalClasses = statisticalClasses;
        this.numberOfclasses = statisticalClasses.getSize();
        this.values = getAllValuesFromClasses();
        StatisticalClassesRules.isValid(values, valuesAndClassMembershipMapper);
        this.valuesAndClassMembershipMapper = valuesAndClassMembershipMapper;
        this.classSizeMapper = StatisticalClassesService.calculateEachClassSize(valuesAndClassMembershipMapper);
        this.mimimumValue = values.getMinimum();
        this.maximumValue = values.getMaximum();
        this.classesIntervals = getClassesIntervalsList();
        this.statisticalClassesOrderedByInterval = orderStatisticalClassesByInterval();
    }


    public static StatisticalClasses of(OrionList<StatisticalClass> statisticalClasses, Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        return new StatisticalClasses(statisticalClasses, valuesAndClassMembershipMapper);
    }


    private Vector getAllValuesFromClasses()
    {
        Set<ANumber> allValues = new HashSet<ANumber>();
        statisticalClasses.forAll(sc -> allValues.addAll(sc.getValues().getAsListCopy()));
        return Vector.of(allValues);
    }


    private List<Interval> getClassesIntervalsList()
    {
        List<Interval> intervals = new ArrayList<Interval>();
        statisticalClasses.forAll(sc -> intervals.add(sc.getClassInterval()));
        return intervals;
    }


    public Interval getClassIntervalForValue(ANumber x)
    {
        return classesIntervals.stream().filter(interval -> interval.isPointInsideInterval(x))
                        .collect(Collectors.toList()).get(0);
    }


    private OrionList<StatisticalClass> orderStatisticalClassesByInterval()
    {
        return statisticalClasses.sortGET(new StatisticalClassIntervalComparator<StatisticalClass>());
    }


    public Vector getClassIntervalsMidpoints()
    {
        return Vector.of(classesIntervals.stream().map(interval -> interval.getMidpoint()).collect(Collectors.toList()));
    }


    public ANumber getClassIntervalMidpoints(StatisticalClass statisticalClass)
    {
        return classesIntervals.get(statisticalClasses.indexOf(statisticalClass)).getMidpoint();
    }


    public int getNumberOfElementsInClass(StatisticalClass statisticalClass)
    {
        return classSizeMapper.get(statisticalClass);
    }


    public ANumber getNumberOfElementsInClassAsNumber(StatisticalClass statisticalClass)
    {
        return ANumber.of(getNumberOfElementsInClass(statisticalClass));
    }


    public int getNumberOfValues()
    {
        return values.getDimensions();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    public Vector getValues()
    {
        return this.values;
    }


    public Map<ANumber, StatisticalClass> getValuesAndClassMembershipMapper()
    {
        return this.valuesAndClassMembershipMapper;
    }


    public Map<StatisticalClass, Integer> getClassSizeMapper()
    {
        return this.classSizeMapper;
    }


    public List<Interval> getClassesIntervals()
    {
        return this.classesIntervals;
    }


    public ANumber getMimimumValue()
    {
        return this.mimimumValue;
    }


    public ANumber getMaximumValue()
    {
        return this.maximumValue;
    }


    public OrionList<StatisticalClass> getStatisticalClasses()
    {
        return this.statisticalClasses;
    }


    public int getNumberOfclasses()
    {
        return this.numberOfclasses;
    }


    public OrionList<StatisticalClass> getStatisticalClassesOrderedByInterval()
    {
        return this.statisticalClassesOrderedByInterval;
    }
}