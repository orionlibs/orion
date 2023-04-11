package com.orion.machine_learning.classification.k_nearest_neighbours;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.orion.machine_learning.classification.k_nearest_neighbours.tasks.CreateTestDataSet;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

public class KNearestNeighboursTest
{
    @SuppressWarnings("unchecked")
    @Test
    public void testKNearestNeighbours()
    {
        TrainingSet<ANumber, String> trainingSet = CreateTestDataSet.run();
        TrainingDataPoint<ANumber> feature1 = TrainingDataPoint.of(ANumber.of(1));
        TrainingDataPoint<ANumber> feature2 = TrainingDataPoint.of(ANumber.of(1.1));
        TrainingData<ANumber> featuresOfElementToClassify = TrainingData.of(feature1, feature2);
        DomainSet<ANumber> domainSet = DomainSet.of(featuresOfElementToClassify);
        Element<ANumber, String> element = Element.of(domainSet);
        String classOfTest = KNearestNeighboursService.<String>runKNearestNeighbours(element, trainingSet, 3);
        assertEquals("A", classOfTest);
    }


    @Test
    public void testKNearestNeighbours2()
    {
        TrainingSet<ANumber, String> trainingSet = CreateTestDataSet.run();
        TrainingDataPoint<ANumber> feature1 = TrainingDataPoint.of(ANumber.of(0));
        TrainingDataPoint<ANumber> feature2 = TrainingDataPoint.of(ANumber.of(0.1));
        @SuppressWarnings("unchecked")
        TrainingData<ANumber> featuresOfElementToClassify = TrainingData.of(feature1, feature2);
        DomainSet<ANumber> domainSet = DomainSet.of(featuresOfElementToClassify);
        Element<ANumber, String> element = Element.of(domainSet);
        String classOfTest = KNearestNeighboursService.<String>runKNearestNeighbours(element, trainingSet, 3);
        assertEquals("B", classOfTest);
    }
}