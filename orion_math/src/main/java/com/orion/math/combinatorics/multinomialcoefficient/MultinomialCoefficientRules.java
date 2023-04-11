package com.orion.math.combinatorics.multinomialcoefficient;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.List;

public class MultinomialCoefficientRules extends MathRule
{
    public static void isValid(ANumber numberOfElements, List<ANumber> numberOfElementsToSelectOfEachType)
    {
        NumberRules.isNotNull(numberOfElements);
        NumberRules.areNotNull(numberOfElementsToSelectOfEachType);
        NumberRules.hasNaturalNumberValue(numberOfElements);
        NumberRules.haveNaturalNumberValue(numberOfElementsToSelectOfEachType);
        Assert.isTrue(ArithmeticService.add(numberOfElementsToSelectOfEachType).equal(numberOfElements), "The sum of the numberOfElementsToSelectOfEachType numbers have to equal numberOfElements.");
    }


    public static void isValid(MultinomialCoefficient multinomialCoefficient)
    {
        Assert.notNull(multinomialCoefficient, "The multinomialCoefficient input cannot be null.");
        isValid(multinomialCoefficient.getNumberOfElements(), multinomialCoefficient.getNumberOfElementsToSelectOfEachType());
    }
}