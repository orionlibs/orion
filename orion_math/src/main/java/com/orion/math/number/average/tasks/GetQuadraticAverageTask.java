package com.orion.math.number.average.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import java.util.List;

public class GetQuadraticAverageTask extends Orion
{
    public static ANumber run(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        ANumber oneOverN = ANumber.of(numbers.size()).reciprocateGET();
        ANumber sumOfSquares = ArithmeticService.getSumOfSquares(numbers);
        return oneOverN.multiplyGET(sumOfSquares).getSquareRoot();
    }


    public static ANumber run(List<ANumber> numbers, int precision)
    {
        ANumber result = run(numbers);
        precision = Precision.getValidPrecision(precision);
        result.applyPrecision(precision);
        return result;
    }
}