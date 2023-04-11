package com.orion.math.geometry.vector.functional.tasks.trigonometry;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetCosineVectorOfFunction1x1WithAxisTask extends Orion
{
    public static Function1x1<ANumber, ANumber> run(VectorOfFunction1x1 x, Axis axis, int precision)
    {
        VectorOfFunction1x1Rules.isValid(x);

        if(x.isZeroVector())
        {
            return Function1x1.<ANumber, ANumber>of(x1 -> ANumber.ofNaN());
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            VectorOfFunction1x1 axisVector = x.getBasisVector(x.getDimensions(), axis);
            return x.getDotProduct(axisVector).divide(x.getMagnitude(precision));
        }

    }
}