package com.orion.math.probability.bayes.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateProbabilityOfEachFeatureGivenClassForBayesTask extends Orion
{
    public static Map<Pair<ANumber, ANumber>, ANumber> run(MultifeatureTrainingSet trainingSet)
    {
        Map<Pair<ANumber, ANumber>, ANumber> mapper = new HashMap<Pair<ANumber, ANumber>, ANumber>();

        for(ANumber feature : trainingSet.getFeatures())
        {

            for(ANumber class1 : trainingSet.getClasses())
            {
                List<Vector> dataPointsWithClass = trainingSet.getDataPointsWithClass(class1);
                long count = dataPointsWithClass.stream().filter(dp -> dp.contains(feature)).count();
                mapper.put(Pair.<ANumber, ANumber>of(feature, class1), ANumber.of(count).divideGET(dataPointsWithClass.size()));
            }

        }

        return mapper;
    }
}