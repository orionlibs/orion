package com.orion.math.combinatorics.binomialcoefficient;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class BinomialCoefficient extends Orion implements MathObject
{
    private ANumber numberOfElements;
    private ANumber numberOfElementsToSelect;


    public BinomialCoefficient(ANumber numberOfElements, ANumber numberOfElementsToSelect)
    {
        NumberRules.areNotNull(numberOfElements, numberOfElementsToSelect);
        NumberRules.haveNaturalNumberValue(numberOfElements, numberOfElementsToSelect);
        this.numberOfElements = numberOfElements;
        this.numberOfElementsToSelect = numberOfElementsToSelect;
    }


    public static BinomialCoefficient of(ANumber numberOfElements, ANumber numberOfElementsToSelect)
    {
        return new BinomialCoefficient(numberOfElements, numberOfElementsToSelect);
    }


    public ANumber get()
    {
        return CombinatoricsService.getNumberOfCombinations(numberOfElements, numberOfElementsToSelect);
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