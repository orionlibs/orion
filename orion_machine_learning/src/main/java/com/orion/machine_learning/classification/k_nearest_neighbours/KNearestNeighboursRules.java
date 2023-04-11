package com.orion.machine_learning.classification.k_nearest_neighbours;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.machine_learning.training.set.TrainingSetRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class KNearestNeighboursRules<LABEL_TYPE> extends Orion
{
    public static <LABEL_TYPE> void isValid(TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k) throws InvalidKValueForKNearestNeighboursException
    {
        TrainingSetRules.isValid(trainingSet);

        if(Numbers.hasNotNaturalNumberValue(k))
        {
            throw new InvalidKValueForKNearestNeighboursException("k has to be a natural number.");
        }

    }


    public static <LABEL_TYPE> void isValid(TrainingSet<ANumber, LABEL_TYPE> trainingSet)
    {
        TrainingSetRules.isValid(trainingSet);
    }
}