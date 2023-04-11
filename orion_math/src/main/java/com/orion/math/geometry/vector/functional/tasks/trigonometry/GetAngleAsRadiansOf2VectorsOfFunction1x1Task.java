package com.orion.math.geometry.vector.functional.tasks.trigonometry;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;

public class GetAngleAsRadiansOf2VectorsOfFunction1x1Task extends Orion
{
    public static Function1x1<ANumber, ANumber> run(VectorOfFunction1x1 x, VectorOfFunction1x1 y, int precision)
    {
        VectorOfFunction1x1Rules.areValid(x, y);

        if(x.isZeroVector() || y.isZeroVector())
        {
            return Function1x1.<ANumber, ANumber>of(x1 -> ANumber.ofNaN());
        }
        else
        {
            Function1x1<ANumber, ANumber> cosine = x.getDotProduct(y).divide(x.getMagnitude(precision).multiply(y.getMagnitude(precision)));
            return cosine.getArccosineAsRadians();
        }

    }
}