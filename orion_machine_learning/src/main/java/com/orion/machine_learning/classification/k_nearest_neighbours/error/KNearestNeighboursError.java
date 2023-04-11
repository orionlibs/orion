package com.orion.machine_learning.classification.k_nearest_neighbours.error;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.core.object.EqualityFunction;
import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursService;
import com.orion.machine_learning.hypothesis.error.AlgorithmError;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import java.util.concurrent.atomic.AtomicLong;

public class KNearestNeighboursError<LABEL_TYPE> extends AlgorithmError
{
    public KNearestNeighboursError(Element<ANumber, LABEL_TYPE> elementToClassify, String expectedLabel, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k) throws InvalidArgumentException
    {
        KNearestNeighboursErrorRules.isValid(elementToClassify, expectedLabel, trainingSet, k);
        calculateErrorForElement(elementToClassify, expectedLabel, trainingSet, k);
    }


    public KNearestNeighboursError(OrionList<Element<ANumber, LABEL_TYPE>> elementsToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        KNearestNeighboursErrorRules.isValid(elementsToClassify, trainingSet, k);
        calculateErrorForElements(elementsToClassify, trainingSet, k);
    }


    public KNearestNeighboursError(TrainingSet<ANumber, LABEL_TYPE> trainingSetToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        KNearestNeighboursErrorRules.isValid(trainingSetToClassify, trainingSet, k);
        calculateErrorForTrainingSet(trainingSetToClassify, trainingSet, k);
    }


    public static <LABEL_TYPE> KNearestNeighboursError<LABEL_TYPE> of(Element<ANumber, LABEL_TYPE> elementToClassify, String expectedLabel, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k) throws InvalidArgumentException
    {
        return new KNearestNeighboursError<LABEL_TYPE>(elementToClassify, expectedLabel, trainingSet, k);
    }


    public static <LABEL_TYPE> KNearestNeighboursError<LABEL_TYPE> of(OrionList<Element<ANumber, LABEL_TYPE>> elementsToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        return new KNearestNeighboursError<LABEL_TYPE>(elementsToClassify, trainingSet, k);
    }


    public static <LABEL_TYPE> KNearestNeighboursError<LABEL_TYPE> of(TrainingSet<ANumber, LABEL_TYPE> trainingSetToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        return new KNearestNeighboursError<LABEL_TYPE>(trainingSetToClassify, trainingSet, k);
    }


    private void calculateErrorForElement(Element<ANumber, LABEL_TYPE> elementToClassify, String expectedLabel, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k) throws InvalidArgumentException
    {
        LABEL_TYPE labelResult = KNearestNeighboursService.<LABEL_TYPE>runKNearestNeighbours(elementToClassify, trainingSet, k);
        ANumber error = ANumber.of(EqualityFunction.run(expectedLabel, labelResult));
        setError(error.divideGET(trainingSet.getNumberOfElements() + 1));
    }


    private void calculateErrorForElements(OrionList<Element<ANumber, LABEL_TYPE>> elementsToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        AtomicLong numberOfMislabelings = new AtomicLong();
        elementsToClassify.forAll((Element<ANumber, LABEL_TYPE> element) ->
        {
            LABEL_TYPE labelResult = KNearestNeighboursService.<LABEL_TYPE>runKNearestNeighbours(element, trainingSet, k);

            if(!labelResult.equals(element.getLabelValue(0)))
            {
                numberOfMislabelings.incrementAndGet();
            }

        });
        setError(ANumber.of(numberOfMislabelings).divideGET(trainingSet.getNumberOfElements() + elementsToClassify.getSize()));
    }


    private void calculateErrorForTrainingSet(TrainingSet<ANumber, LABEL_TYPE> trainingSetToClassify, TrainingSet<ANumber, LABEL_TYPE> trainingSet, int k)
    {
        AtomicLong numberOfMislabelings = new AtomicLong();
        trainingSetToClassify.forAll((Element<ANumber, LABEL_TYPE> element) ->
        {
            LABEL_TYPE labelResult = KNearestNeighboursService.<LABEL_TYPE>runKNearestNeighbours(element, trainingSet, k);

            if(!labelResult.equals(element.getLabelValue(0)))
            {
                numberOfMislabelings.incrementAndGet();
            }

        });
        setError(ANumber.of(numberOfMislabelings).divideGET(trainingSet.getNumberOfElements() + trainingSetToClassify.getNumberOfElements()));
    }
}