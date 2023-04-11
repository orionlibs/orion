package com.orion.math.probability.bayes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.HashMap;
import java.util.Map;

public class CalculateProbabilityOfEachDataPointGivenClassForBayesTask extends Orion
{
    public static Map<Pair<ANumber, ANumber>, ANumber> run(UnifeatureTrainingSet trainingSet)
    {
        Map<Pair<ANumber, ANumber>, ANumber> mapper = new HashMap<Pair<ANumber, ANumber>, ANumber>();

        for(ANumber dataPoint : trainingSet.getDataPoints())
        {

            for(ANumber class1 : trainingSet.getClasses())
            {
                long count = trainingSet.getDataPointsWithClass(class1).stream().filter(dp -> dp.equal(dataPoint)).count();
                mapper.put(Pair.<ANumber, ANumber>of(dataPoint, class1), ANumber.of(1).divideGET(count));
            }

        }

        return mapper;
    }


    public static Map<Pair<Vector, ANumber>, ANumber> run(MultifeatureTrainingSet trainingSet)
    {
        Map<Pair<Vector, ANumber>, ANumber> mapper = new HashMap<Pair<Vector, ANumber>, ANumber>();

        for(Vector dataPoint : trainingSet.getDataPoints())
        {

            for(ANumber class1 : trainingSet.getClasses())
            {
                long count = trainingSet.getDataPointsWithClass(class1).stream().filter(dp -> dp.equals(dataPoint)).count();
                mapper.put(Pair.<Vector, ANumber>of(dataPoint, class1), ANumber.of(1).divideGET(count));
            }

        }

        return mapper;
    }
}