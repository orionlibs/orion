package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;
import java.util.stream.IntStream;

public class GetRandomNumberTask extends Orion
{
    public static ANumber run(ANumber start, ANumber end)
    {
        NumberRules.areNotNull(start, end);
        BigDecimal random = new BigDecimal(Math.random());
        random = random.multiply(end.subtractGET(start).get());
        return start.addGET(ANumber.of(random));
    }


    public static ANumber[] run(ANumber start, ANumber end, int numberOfRandomNumbersToGenerate)
    {
        NumberRules.isPositive(numberOfRandomNumbersToGenerate);
        ANumber[] randomNumbers = new ANumber[numberOfRandomNumbersToGenerate];
        IntStream.range(0, numberOfRandomNumbersToGenerate).forEach(i -> randomNumbers[i] = run(start, end));
        return randomNumbers;
    }
}