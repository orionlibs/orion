package com.orion.math.number.precision.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ApplyPrecisionToNumberTask extends Orion
{
    public void run(ANumber x)
    {
        NumberRules.isNotNull(x);
        BigDecimal temp = x.get();
        int numberOfDecimalDigits = NumberService.getNumberOfDecimalDigits(temp.toPlainString());

        if(numberOfDecimalDigits < x.getPrecision())
        {
            temp = temp.setScale(numberOfDecimalDigits + 1, RoundingMode.HALF_EVEN);
            x.setRealValue(new BigDecimal(temp.toPlainString(), MathContext.UNLIMITED).setScale(numberOfDecimalDigits + 1).stripTrailingZeros());
        }
        else
        {
            temp = temp.setScale(x.getPrecision(), RoundingMode.HALF_EVEN);
            x.setRealValue(new BigDecimal(temp.toPlainString(), MathContext.UNLIMITED).setScale(x.getPrecision() + 1).stripTrailingZeros());
        }

        BigDecimal temp1 = x.getImaginaryValue();
        int numberOfDecimalDigits1 = NumberService.getNumberOfDecimalDigits(temp1.toPlainString());

        if(numberOfDecimalDigits1 < x.getPrecision())
        {
            temp1 = temp1.setScale(numberOfDecimalDigits1 + 1, RoundingMode.HALF_EVEN);
            x.setImaginaryValue(new BigDecimal(temp1.toPlainString(), MathContext.UNLIMITED).setScale(numberOfDecimalDigits1 + 1).stripTrailingZeros());
        }
        else
        {
            temp1 = temp1.setScale(x.getPrecision(), RoundingMode.HALF_EVEN);
            x.setImaginaryValue(new BigDecimal(temp1.toPlainString(), MathContext.UNLIMITED).setScale(x.getPrecision() + 1).stripTrailingZeros());
        }

    }
}