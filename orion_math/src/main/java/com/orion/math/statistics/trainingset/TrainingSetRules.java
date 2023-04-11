package com.orion.math.statistics.trainingset;

import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.util.List;

public class TrainingSetRules extends MathRule
{
    public static void isValidUnifeatureTrainingSet(List<Pair<ANumber, ANumber>> trainingSet)
    {
        Assert.notEmpty(trainingSet, "The trainingSet input cannot be null/empty.");

        for(Pair<ANumber, ANumber> pair : trainingSet)
        {
            Assert.notNull(pair, "The training set pair cannot be null/empty.");
            Assert.isFalse(Numbers.isNull(pair.getFirst()), "Training set observation/label is null.");
            Assert.isFalse(Numbers.isNull(pair.getSecond()), "Training set observation/label is null.");
        }

    }


    public static void isValidMultifeatureTrainingSet(List<Pair<Vector, ANumber>> trainingSet)
    {
        Assert.notEmpty(trainingSet, "The trainingSet input cannot be null/empty.");

        for(Pair<Vector, ANumber> pair : trainingSet)
        {
            Assert.notNull(pair, "The training set pair cannot be null/empty.");
            Assert.isFalse(Numbers.isNull(pair.getFirst()), "Training set observation/label is null.");
            Assert.isFalse(Numbers.isNull(pair.getSecond()), "Training set observation/label is null.");
        }

    }


    public static void isValid(UnifeatureTrainingSet trainingSet)
    {
        Assert.notNull(trainingSet, "The UnifeatureTrainingSet cannot be null/empty.");
        isValidUnifeatureTrainingSet(trainingSet.getTrainingSet());
    }


    public static void isValid(MultifeatureTrainingSet trainingSet)
    {
        Assert.notNull(trainingSet, "The MultifeatureTrainingSet cannot be null/empty.");
        isValidMultifeatureTrainingSet(trainingSet.getTrainingSet());
    }
}