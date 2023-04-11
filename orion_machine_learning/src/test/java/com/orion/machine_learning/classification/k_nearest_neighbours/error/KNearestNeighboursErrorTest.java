package com.orion.machine_learning.classification.k_nearest_neighbours.error;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.core.exception.InvalidArgumentException;
import com.orion.machine_learning.classification.k_nearest_neighbours.tasks.CreateTestDataSet;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

public class KNearestNeighboursErrorTest
{
    @SuppressWarnings("unchecked")
    @Test
    public void testKNearestNeighboursEmpiricalError() throws InvalidArgumentException
    {
        TrainingSet<ANumber, String> trainingSet = CreateTestDataSet.run();
        TrainingDataPoint<ANumber> feature1 = TrainingDataPoint.of(ANumber.of(1));
        TrainingDataPoint<ANumber> feature2 = TrainingDataPoint.of(ANumber.of(1.1));
        TrainingData<ANumber> featuresOfElementToClassify = TrainingData.of(feature1, feature2);
        DomainSet<ANumber> domainSet = DomainSet.of(featuresOfElementToClassify);
        Element<ANumber, String> element = Element.of(domainSet);
        ANumber result = KNearestNeighboursError.of(element, "A", trainingSet, 2).getError();
        ANumber expected = ANumber.of(0);
        assertTrue(expected.equal(result));
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testKNearestNeighboursEmpiricalError2() throws InvalidArgumentException
    {
        TrainingSet<ANumber, String> trainingSet = CreateTestDataSet.run();
        TrainingDataPoint<ANumber> feature1 = TrainingDataPoint.of(ANumber.of(1));
        TrainingDataPoint<ANumber> feature2 = TrainingDataPoint.of(ANumber.of(1.1));
        TrainingData<ANumber> featuresOfElementToClassify = TrainingData.of(feature1, feature2);
        DomainSet<ANumber> domainSet = DomainSet.of(featuresOfElementToClassify);
        Element<ANumber, String> element = Element.of(domainSet);
        ANumber result = KNearestNeighboursError.of(element, "B", trainingSet, 2).getError();
        ANumber expected = ANumber.of(0.2);
        assertTrue(expected.equal(result));
    }
}