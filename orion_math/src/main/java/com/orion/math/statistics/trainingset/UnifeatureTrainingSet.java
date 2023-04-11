package com.orion.math.statistics.trainingset;

import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnifeatureTrainingSet extends TrainingSet
{
    private List<Pair<ANumber, ANumber>> trainingSet;


    public UnifeatureTrainingSet(List<Pair<ANumber, ANumber>> trainingSet)
    {
        TrainingSetRules.isValidUnifeatureTrainingSet(trainingSet);
        this.trainingSet = trainingSet;
    }


    public static UnifeatureTrainingSet of(List<Pair<ANumber, ANumber>> trainingSet)
    {
        return new UnifeatureTrainingSet(trainingSet);
    }


    @Override
    public int getSize()
    {
        return getTrainingSet().size();
    }


    @Override
    public ANumber getSizeAsNumber()
    {
        return ANumber.of(getSize());
    }


    public Pair<ANumber, ANumber> get(int index)
    {
        return getTrainingSet().get(index);
    }


    public ANumber getDataPoint(int index)
    {
        return getTrainingSet().get(index).getFirst();
    }


    public List<ANumber> getDataPoints()
    {
        return getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
    }


    public ANumber getNumberOfOccurencesOfDataPointInTrainingSet(ANumber dataPoint)
    {
        return ANumber.of(getDataPoints().stream().filter(point -> point.equal(dataPoint)).count());
    }


    public ANumber getClassForIndex(int index)
    {
        return getTrainingSet().get(index).getSecond();
    }


    @Override
    public int getNumberOfClasses()
    {
        return getClasses().size();
    }


    @Override
    public ANumber getNumberOfDataPointsWithClass(ANumber classToCheck)
    {
        return ANumber.of(getTrainingSet().stream().filter(pair -> pair.getSecond().equal(classToCheck)).count());
    }


    public ANumber getProbabilityOfClass(ANumber classToCheck)
    {
        return getNumberOfDataPointsWithClass(classToCheck).divideGET(getSize());
    }


    public List<ANumber> getDataPointsWithClass(ANumber classToCheck)
    {
        return getTrainingSet().stream().filter(pair -> pair.getSecond().equal(classToCheck))
                        .map(pair -> pair.getFirst()).collect(Collectors.toList());
    }


    @Override
    public List<ANumber> getClasses()
    {
        Set<ANumber> classes = getTrainingSet().stream().map(pair -> pair.getSecond()).collect(Collectors.toSet());
        return new ArrayList<ANumber>(classes);
    }


    public List<Pair<ANumber, ANumber>> getTrainingSet()
    {
        return trainingSet;
    }
}