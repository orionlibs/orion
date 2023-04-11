package com.orion.math.probability.event.inclusionexclusion;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.Arrays;

public class InclusionExclusionFunctionRules extends MathRule
{
    public static void isValid(ANumber x, ANumber y, ANumber z)
    {
        NumberRules.areBetween(Arrays.asList(x, y, z), 0, 1);
    }


    public static void isValid(ANumber x, ANumber y, ANumber z, ANumber w)
    {
        NumberRules.areBetween(Arrays.asList(x, y, z, w), 0, 1);
    }


    public static void isValid(InclusionExclusionFunction inclusionExclusionFunction)
    {
        Assert.notNull(inclusionExclusionFunction, "The inclusionExclusionFunction input cannot be null.");
        isValid(inclusionExclusionFunction.getProbabilityOfAOrB(), inclusionExclusionFunction.getProbabilityOfA(), inclusionExclusionFunction.getProbabilityOfB(), inclusionExclusionFunction.getProbabilityOfAAndB());
    }
}