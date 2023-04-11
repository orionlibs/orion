package com.orion.math.probability.distribution.continuous.studentst;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.Map;

public class StudentsTDistributionRules extends MathRule
{
    public static void isValid(Vector population, Vector sample)
    {
        VectorRules.areValid(population, sample);
    }


    public static void isValid(Vector population, Vector sample, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        isValid(population, sample);
        Assert.notNull(probabilityOfEachValueMapper, "the probabilityOfEachValueMapper input cannot be null.");
        Assert.areEqual(probabilityOfEachValueMapper.size(), sample.getDimensions(), "probabilityOfEachValueMapper size does not match the number of sample values.");
    }


    public static void isValid(StudentsTDistribution distribution)
    {
        Assert.notNull(distribution, "the StudentsTDistribution input cannot be null.");
        isValid(distribution.getPopulation(), distribution.getSample());
    }
}