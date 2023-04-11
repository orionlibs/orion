package com.orion.math.combinatorics.binomialcoefficient;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class ExtendedBinomialCoefficient extends Orion implements MathObject
{
    private ANumber numberOfElements;
    private ANumber numberOfElementsToSelect;


    public ExtendedBinomialCoefficient(ANumber numberOfElements, ANumber numberOfElementsToSelect)
    {
        NumberRules.areNotNull(numberOfElements, numberOfElementsToSelect);
        NumberRules.hasNonnegativeIntegerNumberValue(numberOfElementsToSelect);
        this.numberOfElements = numberOfElements;
        this.numberOfElementsToSelect = numberOfElementsToSelect;
    }


    public static ExtendedBinomialCoefficient of(ANumber numberOfElements, ANumber numberOfElementsToSelect)
    {
        return new ExtendedBinomialCoefficient(numberOfElements, numberOfElementsToSelect);
    }


    public ANumber get()
    {
        ANumber a = ANumber.of(-1).exponentiateGET(numberOfElementsToSelect);
        ANumber b = numberOfElements.addGET(numberOfElementsToSelect).subtractOneGET();
        return a.multiplyGET(CombinatoricsService.getNumberOfCombinations(b, numberOfElementsToSelect));
    }


    public ANumber getNumberOfElements()
    {
        return this.numberOfElements;
    }


    public ANumber getNumberOfElementsToSelect()
    {
        return this.numberOfElementsToSelect;
    }
}