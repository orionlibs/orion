package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.services.NumberService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetGreatestCommonDivisorOfNumbersTask extends Orion
{
    public static ANumber run(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        NumberRules.haveIntegerValue(x, y);
        return ANumber.of(x.getAsInteger().gcd(y.getAsInteger()));
    }


    public static ANumber run(List<ANumber> numbers)
    {
        Numbers.haveNaturalNumberValue(numbers);
        List<List<ANumber>> divisorsOfAllNumbers = new ArrayList<List<ANumber>>();
        List<ANumber> nonZeroNumbers = numbers.stream().filter(x -> x.isNotZero()).collect(Collectors.toList());

        if(nonZeroNumbers.size() == 1)
        {
            return nonZeroNumbers.get(0);
        }
        else
        {
            nonZeroNumbers.forEach(x -> divisorsOfAllNumbers.add(NumberService.getDivisors(x)));
            return getGCD(divisorsOfAllNumbers);
        }

    }


    private static ANumber getGCD(List<List<ANumber>> divisorsOfAllNumbers)
    {
        NumberRules.areNotNull(divisorsOfAllNumbers);
        List<ANumber> commonFactors = divisorsOfAllNumbers.get(0);
        IntStream.range(1, divisorsOfAllNumbers.size())
                        .forEach(i -> commonFactors.retainAll(divisorsOfAllNumbers.get(i)));
        Set<ANumber> commonFactorsTemp = new HashSet<ANumber>(commonFactors);
        List<ANumber> commonFactors1 = new ArrayList<ANumber>(commonFactorsTemp);
        Collections.sort(commonFactors1);
        return commonFactors1.get(commonFactors1.size() - 1);
    }
}