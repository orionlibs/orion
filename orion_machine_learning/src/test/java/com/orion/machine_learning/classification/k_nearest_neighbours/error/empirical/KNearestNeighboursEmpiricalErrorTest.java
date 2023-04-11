package com.orion.machine_learning.classification.k_nearest_neighbours.error.empirical;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.machine_learning.classification.k_nearest_neighbours.tasks.CreateTestDataSet;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

public class KNearestNeighboursEmpiricalErrorTest
{
    @Test
    public void testKNearestNeighboursExpectedError()
    {
        TrainingSet<ANumber, String> trainingSet = CreateTestDataSet.run();
        ANumber result = KNearestNeighboursEmpiricalError.<String>of(trainingSet, 2).getError();
        ANumber expected = ANumber.of(0);
        assertTrue(expected.equal(result));
    }
}