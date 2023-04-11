package com.orion.machine_learning.classification.k_nearest_neighbours;

import com.orion.core.abstraction.OrionService;
import com.orion.machine_learning.classification.k_nearest_neighbours.error.KNearestNeighboursError;
import com.orion.machine_learning.classification.k_nearest_neighbours.tasks.RunKNearestNeighboursTask;
import com.orion.machine_learning.classification.k_nearest_neighbours.tasks.TrainKNearestNeighboursAndGetOptimumKTask;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;

public class KNearestNeighboursService<LABEL_TYPE> extends OrionService
{
    public static <LABEL_TYPE> LABEL_TYPE runKNearestNeighbours(Element<ANumber, LABEL_TYPE> elementToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        return new RunKNearestNeighboursTask<LABEL_TYPE>(elementToClassify, trainingSet, k).get();
    }


    public static <LABEL_TYPE> int trainKNearestNeighboursAndGetOptimumK(TrainingSet<ANumber, LABEL_TYPE> trainingSet)
    {
        return TrainKNearestNeighboursAndGetOptimumKTask.<LABEL_TYPE>run(trainingSet);
    }


    public static <LABEL_TYPE> ANumber crossValidateKNearestNeighboursAndGetError(TrainingSet<ANumber, LABEL_TYPE> trainingSet)
    {
        TrainingSet<ANumber, LABEL_TYPE> firstHalfOftrainingSet = trainingSet.getFirstHalf();
        int optimimK = trainKNearestNeighboursAndGetOptimumK(firstHalfOftrainingSet);
        TrainingSet<ANumber, LABEL_TYPE> secondHalfOftrainingSet = trainingSet.getSecondHalf();
        KNearestNeighboursError<LABEL_TYPE> error = KNearestNeighboursError.of(secondHalfOftrainingSet, firstHalfOftrainingSet, optimimK);
        return error.getError();
    }
}