package com.orion.math.combinatorics;

import com.orion.core.abstraction.OrionService;
import com.orion.math.combinatorics.tasks.GetCombinationsWithoutElementRepetitionTask;
import com.orion.math.combinatorics.tasks.GetNumberOfCombinationsTask;
import com.orion.math.combinatorics.tasks.GetPascalTriangleTask;
import com.orion.math.combinatorics.tasks.GetStirlingNumberOfSecondKindTask;
import com.orion.math.function.Functions;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.statistics.frequency.FrequencyOfObjects;
import java.util.List;

public class CombinatoricsService<T> extends OrionService
{
    public static ANumber getNumberOfCombinations(ANumber n, ANumber r)
    {
        return GetNumberOfCombinationsTask.run(n, r);
    }


    public static ANumber getNumberOfCombinations(Number n, Number r)
    {
        return getNumberOfCombinations(ANumber.of(n), ANumber.of(r));
    }


    public static ANumber getNumberOfCombinationsWithElementRepetition(ANumber n, ANumber r)
    {
        NumberRules.isNotNull(n);
        return getNumberOfCombinations(n.addGET(r).subtractOneGET(), r);
    }


    public static <T> List<List<T>> getCombinationsWithoutElementRepetition(List<T> items, int combinationSize)
    {
        return new GetCombinationsWithoutElementRepetitionTask<T>().run(items, combinationSize);
    }


    public static Matrix getPascalTriangle(int order)
    {
        return GetPascalTriangleTask.run(order);
    }


    public static ANumber getStirlingNumberOfFirstKind(ANumber n)
    {
        return Functions.factorial.run(n.subtractOneGET());
    }


    public static ANumber getStirlingNumberOfSecondKind(ANumber n, ANumber j)
    {
        return GetStirlingNumberOfSecondKindTask.run(n, j);
    }


    public static ANumber getNumberOfRearrangements(ANumber numberOfItemsToRearrange)
    {
        return Functions.factorial.run(numberOfItemsToRearrange);
    }


    public static ANumber getNumberOfRearrangements(ANumber numberOfItemsToRearrange, List<ANumber> numberOfItemsRepetitions)
    {
        ANumber divisor = ANumber.of(1);
        numberOfItemsRepetitions.forEach(numberOfItemRepetitions -> divisor.multiply(Functions.factorial.run(numberOfItemRepetitions)));
        return Functions.factorial.run(numberOfItemsToRearrange).divideGET(divisor);
    }


    public static ANumber getNumberOfRearrangements(List<?> itemsToRearrange)
    {
        FrequencyOfObjects frequencyOfItems = FrequencyOfObjects.of(itemsToRearrange);
        ANumber divisor = ANumber.of(1);
        frequencyOfItems.getUniqueElements()
                        .forEach(uniqueItem -> divisor.multiply(Functions.factorial.run(frequencyOfItems.getFrequency(uniqueItem))));
        return Functions.factorial.run(ANumber.of(itemsToRearrange.size())).divideGET(divisor);
    }


    public static ANumber getNumberOfOrderedSelections(ANumber numberOfItems, ANumber sizeOfEachSelection)
    {
        NumberRules.haveNaturalNumberValue(numberOfItems, sizeOfEachSelection);
        NumberRules.isLessThanOrEqual(sizeOfEachSelection, numberOfItems);
        return Functions.factorial.run(sizeOfEachSelection).multiplyGET(getNumberOfCombinations(numberOfItems, sizeOfEachSelection));
    }


    public static ANumber getNumberOfWaysToChooseWithReplacementInAnyOrder(ANumber numberOfItems, ANumber sizeOfEachSelection)
    {
        NumberRules.haveNaturalNumberValue(numberOfItems, sizeOfEachSelection);
        NumberRules.isLessThanOrEqual(sizeOfEachSelection, numberOfItems);
        return getNumberOfCombinations(numberOfItems.addGET(sizeOfEachSelection).subtractOneGET(), sizeOfEachSelection);
    }


    public static ANumber getNumberOfMPartCompositionsOfN(ANumber n, ANumber m)
    {
        NumberRules.haveNaturalNumberValue(n, m);
        NumberRules.isLessThanOrEqual(m, n);
        return getNumberOfCombinations(n.subtractOneGET(), m.subtractOneGET());
    }


    public static ANumber getNumberOfCompositionsOfN(ANumber n)
    {
        NumberRules.hasNaturalNumberValue(n);
        return ANumber.of(2).exponentiateGET(n.subtractOneGET());
    }
}