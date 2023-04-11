package com.orion.machine_learning.classification.k_nearest_neighbours.error.empirical;

import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursService;
import com.orion.machine_learning.hypothesis.error.EmpiricalError;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import java.util.concurrent.atomic.AtomicLong;

public class KNearestNeighboursEmpiricalError<LABEL_TYPE> extends EmpiricalError
{
    public KNearestNeighboursEmpiricalError(TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        KNearestNeighboursEmpiricalErrorRules.isValid(trainingSet, k);
        AtomicLong numberOfMislabelings = new AtomicLong();
        trainingSet.forAll((Element<ANumber, LABEL_TYPE> element) ->
        {
            LABEL_TYPE labelResult = KNearestNeighboursService.<LABEL_TYPE>runKNearestNeighbours(element, trainingSet, 3);

            if(!labelResult.equals(element.getLabelValue(0)))
            {
                numberOfMislabelings.incrementAndGet();
            }

        });
        setError(ANumber.of(numberOfMislabelings).divideGET(trainingSet.getNumberOfElements()));
    }


    public static <LABEL_TYPE> KNearestNeighboursEmpiricalError<LABEL_TYPE> of(TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        return new KNearestNeighboursEmpiricalError<LABEL_TYPE>(trainingSet, k);
    }
}