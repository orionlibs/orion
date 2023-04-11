package com.orion.math.number.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetModulusOfComplexNumberTask extends Orion
{
    public static ANumber run(ANumber x)
    {
        NumberRules.isNotNull(x);
        ANumber realValue = ANumber.of(x.get());
        ANumber imaginaryValue = ANumber.of(x.getImaginaryValue());
        ANumber realValueSquared = realValue.squareGET();
        ANumber imaginaryValueSquared = imaginaryValue.squareGET();
        int precision = realValueSquared.getNumberOfDecimalDigitsOfRealValue() + imaginaryValueSquared.getNumberOfDecimalDigitsOfRealValue();
        return realValueSquared.addGET(imaginaryValueSquared).getSquareRoot(precision);
    }
}