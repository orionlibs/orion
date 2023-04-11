package com.orion.math.combinatorics.permutations.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.function.Functions;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.List;

public class GetNumberOfPermutationsTask extends Orion
{
    public static ANumber run(List<?> elements, ANumber numberOfElementsToSelect)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        NumberRules.hasNaturalNumberValue(numberOfElementsToSelect);
        NumberRules.isGreaterThanOrEqual(ANumber.of(elements.size()), numberOfElementsToSelect);
        ANumber a = Functions.factorial.run(ANumber.of(elements.size()));
        ANumber b = Functions.factorial.run(ANumber.of(elements.size()).subtractGET(numberOfElementsToSelect));
        return a.divideGET(b);
    }


    public static ANumber run(List<?> elements, Vector numberOfElementsOfEachType)
    {
        Assert.notEmpty(elements, "The elements input cannot be null/empty.");
        VectorRules.isValid(numberOfElementsOfEachType);
        Assert.isLessThanOrEqualTo(numberOfElementsOfEachType.getSize(), elements.size(), "There cannot be more types of elements than there are elements in the list.");
        ANumber a = Functions.factorial.run(ANumber.of(elements.size()));
        ANumber denominator = ANumber.of(1);
        numberOfElementsOfEachType.forAll(t -> denominator.multiply(Functions.factorial.run(t)));
        return a.divideGET(denominator);
    }
}