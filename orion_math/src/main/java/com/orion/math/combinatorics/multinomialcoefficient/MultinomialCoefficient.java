package com.orion.math.combinatorics.multinomialcoefficient;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.number.ANumber;
import java.util.List;

public class MultinomialCoefficient extends Orion implements MathObject
{
    private ANumber numberOfElements;
    private List<ANumber> numberOfElementsToSelectOfEachType;


    public MultinomialCoefficient(ANumber numberOfElements, List<ANumber> numberOfElementsToSelectOfEachType)
    {
        MultinomialCoefficientRules.isValid(numberOfElements, numberOfElementsToSelectOfEachType);
        this.numberOfElements = numberOfElements;
        this.numberOfElementsToSelectOfEachType = numberOfElementsToSelectOfEachType;
    }


    public static MultinomialCoefficient of(ANumber numberOfElements, List<ANumber> numberOfElementsToSelectOfEachType)
    {
        return new MultinomialCoefficient(numberOfElements, numberOfElementsToSelectOfEachType);
    }


    public ANumber get()
    {
        return CombinatoricsService.getNumberOfRearrangements(numberOfElements, numberOfElementsToSelectOfEachType);
    }


    public ANumber getNumberOfElements()
    {
        return this.numberOfElements;
    }


    public List<ANumber> getNumberOfElementsToSelectOfEachType()
    {
        return this.numberOfElementsToSelectOfEachType;
    }
}