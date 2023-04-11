package com.orion.math.statistics.trainingset;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MultifeatureTrainingSet extends TrainingSet
{
    private List<Pair<Vector, ANumber>> trainingSet;


    public MultifeatureTrainingSet(List<Pair<Vector, ANumber>> trainingSet)
    {
        TrainingSetRules.isValidMultifeatureTrainingSet(trainingSet);
        this.trainingSet = trainingSet;
    }


    public static MultifeatureTrainingSet of(List<Pair<Vector, ANumber>> trainingSet)
    {
        return new MultifeatureTrainingSet(trainingSet);
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


    public int getNumberOfFeatures()
    {
        return get(0).getFirst().getDimensions();
    }


    public Pair<Vector, ANumber> get(int index)
    {
        return getTrainingSet().get(index);
    }


    public Vector getDataPoint(int index)
    {
        return getTrainingSet().get(index).getFirst();
    }


    public List<Vector> getDataPoints()
    {
        return getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
    }


    public List<ANumber> getFeatures()
    {
        OrionSet<ANumber> features = OrionHashSet.<ANumber>of();
        getDataPoints().forEach(dataPoint -> features.addAll(dataPoint.getElements().getAsList()));
        return features.getAsList();
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


    public List<Vector> getDataPointsWithClass(ANumber classToCheck)
    {
        return getTrainingSet().stream().filter(pair -> pair.getSecond().equal(classToCheck))
                        .map(pair -> pair.getFirst()).collect(Collectors.toList());
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


    @Override
    public List<ANumber> getClasses()
    {
        Set<ANumber> classes = getTrainingSet().stream().map(pair -> pair.getSecond()).collect(Collectors.toSet());
        return new ArrayList<ANumber>(classes);
    }


    public Matrix getAsMatrix()
    {
        List<Vector> vectors = getTrainingSet().stream().map(pair -> pair.getFirst()).collect(Collectors.toList());
        OrionList<Vector> elements = OrionArrayList.of(vectors);
        return Matrix.of(elements);
    }


    public List<Pair<Vector, ANumber>> getTrainingSet()
    {
        return trainingSet;
    }
}