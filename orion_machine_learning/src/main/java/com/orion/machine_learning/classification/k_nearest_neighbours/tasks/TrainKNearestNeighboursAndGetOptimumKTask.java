package com.orion.machine_learning.classification.k_nearest_neighbours.tasks;

import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursRules;
import com.orion.machine_learning.classification.k_nearest_neighbours.error.empirical.KNearestNeighboursEmpiricalError;
import com.orion.machine_learning.hypothesis.error.ExpectedErrorMinimisationAlgorithm;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainKNearestNeighboursAndGetOptimumKTask<LABEL_TYPE> extends ExpectedErrorMinimisationAlgorithm
{
    public static <LABEL_TYPE> int run(TrainingSet<ANumber, LABEL_TYPE> trainingSet)
    {
        KNearestNeighboursRules.isValid(trainingSet);
        int optimumKTemp = 1;
        AtomicInteger k = new AtomicInteger(1);
        ANumber numberOfErrors = ANumber.of(trainingSet.getNumberOfElements());

        for(; k.get() < trainingSet.getNumberOfElements() - 1; k.incrementAndGet())
        {
            ANumber errorForK = KNearestNeighboursEmpiricalError.<LABEL_TYPE>of(trainingSet, k.get()).getError();

            if(errorForK.isLessThan(numberOfErrors))
            {
                numberOfErrors = errorForK;
                optimumKTemp = k.get();
            }

        }

        return optimumKTemp;
    }
}