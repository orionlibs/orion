package com.orion.math.statistics.regression.linear.multiple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegressionRules;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;
import java.util.ArrayList;
import java.util.List;

public class Prepend1InXValuesOfMultifeatureTrainingSetTask extends Orion
{
    public static MultifeatureTrainingSet run(MultifeatureTrainingSet trainingSet)
    {
        MultipleLinearRegressionRules.isValid(trainingSet);
        List<Pair<Vector, ANumber>> newTrainingSet = new ArrayList<Pair<Vector, ANumber>>();

        for(int i = 0; i < trainingSet.getSize(); i++)
        {
            Vector newVector = trainingSet.getDataPoint(i).prepend(ANumber.of(1));
            newTrainingSet.add(Pair.<Vector, ANumber>of(newVector, trainingSet.getClassForIndex(i)));
        }

        return MultifeatureTrainingSet.of(newTrainingSet);
    }
}