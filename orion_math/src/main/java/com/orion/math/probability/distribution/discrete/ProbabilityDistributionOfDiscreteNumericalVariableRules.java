package com.orion.math.probability.distribution.discrete;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.Map;

public class ProbabilityDistributionOfDiscreteNumericalVariableRules extends MathRule
{
    public static void isValid(Vector values, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        VectorRules.isValid(values);
        Assert.notNull(probabilityOfEachValueMapper, "the probabilityOfEachValueMapper input cannot be null.");
        Assert.areEqual(probabilityOfEachValueMapper.size(), values.getDimensions(), "probabilityOfEachValueMapper size does not match the number of values.");
    }


    public static void isValid(ProbabilityDistributionOfDiscreteNumericalVariable distribution)
    {
        Assert.notNull(distribution, "the ProbabilityDistributionOfDiscreteNumericalVariable input cannot be null.");
        isValid(distribution.getValues(), distribution.getProbabilityOfEachValueMapper());
    }
}