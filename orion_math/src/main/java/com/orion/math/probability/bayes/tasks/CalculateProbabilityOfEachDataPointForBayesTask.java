package com.orion.math.probability.bayes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.HashMap;
import java.util.Map;

public class CalculateProbabilityOfEachDataPointForBayesTask extends Orion
{
    public static Map<ANumber, ANumber> run(UnifeatureTrainingSet trainingSet, Map<ANumber, ANumber> probabilityOfEachClass, Map<Pair<ANumber, ANumber>, ANumber> probabilityOfEachFeatureGivenClass)
    {
        Map<ANumber, ANumber> mapper = new HashMap<ANumber, ANumber>();

        for(ANumber feature : trainingSet.getDataPoints())
        {
            ANumber sum = ANumber.of(0);

            for(Map.Entry<ANumber, ANumber> probabilityOfClass : probabilityOfEachClass.entrySet())
            {
                ANumber class1 = probabilityOfClass.getKey();
                ANumber probability = probabilityOfClass.getValue();
                sum.add(probability.multiplyGET(probabilityOfEachFeatureGivenClass.get(Pair.<ANumber, ANumber>of(feature, class1))));
            }

            mapper.put(feature, sum);
        }

        return mapper;
    }


    public static Map<Vector, ANumber> run(MultifeatureTrainingSet trainingSet, Map<ANumber, ANumber> probabilityOfEachClass, Map<Pair<Vector, ANumber>, ANumber> probabilityOfEachDataPointGivenClass)
    {
        Map<Vector, ANumber> mapper = new HashMap<Vector, ANumber>();

        for(Vector dataPoint : trainingSet.getDataPoints())
        {
            ANumber sum = ANumber.of(0);

            for(Map.Entry<ANumber, ANumber> probabilityOfClass : probabilityOfEachClass.entrySet())
            {
                ANumber class1 = probabilityOfClass.getKey();
                ANumber probability = probabilityOfClass.getValue();
                sum.add(probability.multiplyGET(probabilityOfEachDataPointGivenClass.get(Pair.<Vector, ANumber>of(dataPoint, class1))));
            }

            mapper.put(dataPoint, sum);
        }

        return mapper;
    }
}