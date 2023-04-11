package com.orion.machine_learning.classification.k_nearest_neighbours.error.empirical;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursRules;
import com.orion.machine_learning.training.set.TrainingSet;

public class KNearestNeighboursEmpiricalErrorRules extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static void isValid(TrainingSet trainingSet, int k)
    {
        KNearestNeighboursRules.isValid(trainingSet, k);
    }
}