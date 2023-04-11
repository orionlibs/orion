package com.orion.math.polynomial.spline.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.spline.PolynomialSpline;
import com.orion.math.polynomial.spline.PolynomialSplineRules;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GetValueForPolynomialSplineTask extends Orion
{
    public static ANumber run(PolynomialSpline polynomial, ANumber x)
    {
        PolynomialSplineRules.isValuewithinInterval(polynomial, x);
        List<ANumber> temp = polynomial.getKnots().getAsListCopy();
        Collections.sort(temp);
        int i = Arrays.binarySearch(temp.toArray(new ANumber[0]), x);

        if(i < 0)
        {
            i = -i - 2;
        }
        else if(i >= polynomial.getPolynomials().length)
        {
            i--;
        }

        return polynomial.getPolynomial(i).getValueFor(x.subtractGET(polynomial.getKnots().get(i)));
    }
}