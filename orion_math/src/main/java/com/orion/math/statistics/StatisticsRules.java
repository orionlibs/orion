package com.orion.math.statistics;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.util.Map;

public class StatisticsRules extends MathRule
{
    public static void isValidPercentile(ANumber percentile)
    {
        Assert.notNull(percentile, "The percentile input cannot be null.");
        Assert.isFalse(Numbers.isNotBetweenLeftExclusive(percentile, 0, 100), "Percentile has to be in (0, 100].");
    }


    public static void isValidForExpectedValue(Vector vector, Map<ANumber, ANumber> probabilityOfEachValueInVector)
    {
        VectorRules.isValid(vector);
        Assert.notNull(probabilityOfEachValueInVector, "The probabilityOfEachValueInVector input cannot be null.");
        Assert.areEqual(probabilityOfEachValueInVector.size(), vector.getDimensions(), "probabilityOfEachValueInVector size does not match the size of vector.");
    }


    public static void isValidForExpectedValueOfSumOf2Variables(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2)
    {
        VectorRules.doVectorSizesMatch(vector1, vector2);
        Assert.notNull(probabilityOfEachValueInVector1, "The probabilityOfEachValueInVector1 input cannot be null.");
        Assert.areEqual(probabilityOfEachValueInVector1.size(), vector1.getDimensions(), "probabilityOfEachValueInVector1 size does not match the size of vector.");
        Assert.notNull(probabilityOfEachValueInVector2, "The probabilityOfEachValueInVector2 input cannot be null.");
        Assert.areEqual(probabilityOfEachValueInVector2.size(), vector2.getDimensions(), "probabilityOfEachValueInVector2 size does not match the size of vector.");
    }


    public static void isValidForVariance(Vector vector, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        VectorRules.isValid(vector);
        Assert.notNull(probabilityOfEachValueMapper, "The probabilityOfEachValueMapper input cannot be null.");
        Assert.areEqual(probabilityOfEachValueMapper.size(), vector.getDimensions(), "probabilityOfEachValueMapper size does not match the size of vector.");
    }


    public static void isValidForCovariance(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2)
    {
        VectorRules.doVectorSizesMatch(vector1, vector2);
        Assert.notNull(probabilityOfEachValueInVector1, "The probabilityOfEachValueInVector1 input cannot be null.");
        Assert.notNull(probabilityOfEachValueInVector2, "The probabilityOfEachValueInVector2 input cannot be null.");
        Assert.areEqual(probabilityOfEachValueInVector1.size(), vector1.getDimensions(), "probabilityOfEachValueInVector1 size does not match the size of vector1.");
        Assert.areEqual(probabilityOfEachValueInVector2.size(), vector2.getDimensions(), "probabilityOfEachValueInVector2 size does not match the size of vector2.");
    }
}