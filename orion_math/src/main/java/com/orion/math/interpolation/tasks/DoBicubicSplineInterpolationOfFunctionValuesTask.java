package com.orion.math.interpolation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.geometry.vector.VectorService;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.spline.PolynomialSpline;
import java.util.stream.IntStream;

public class DoBicubicSplineInterpolationOfFunctionValuesTask extends Orion
{
    public static PolynomialSpline run(Vector xValues, Vector yValues)
    {
        VectorRules.doVectorSizesMatch(xValues, yValues);
        VectorRules.isDimensionsAtLeast(xValues.getDimensions(), 4);
        Pair<Vector, Vector> sortedPair = VectorService.sortAndMapTogether(xValues, yValues);
        ANumber[] xValuesSorted = sortedPair.getFirst().getAsArray();
        ANumber[] yValuesSorted = sortedPair.getSecond().getAsArray();
        int numberOfDiffAndWeightElements = xValuesSorted.length - 1;
        ANumber[] differences = new ANumber[numberOfDiffAndWeightElements];
        ANumber[] weights = new ANumber[numberOfDiffAndWeightElements];
        IntStream.range(0, differences.length)
                        .forEach(i -> differences[i] = (yValuesSorted[i + 1].subtractGET(yValuesSorted[i])).divideGET(xValuesSorted[i + 1].subtractGET(xValuesSorted[i])));
        IntStream.range(1, weights.length)
                        .forEach(i -> weights[i] = differences[i].subtractGET(differences[i - 1]).getAbsoluteValue());
        ANumber[] firstDerivatives = new ANumber[xValuesSorted.length];

        for(int i = 2; i < firstDerivatives.length - 2; i++)
        {
            ANumber wP = weights[i + 1];
            ANumber wM = weights[i - 1];

            if(wP.isZero() && wM.isZero())
            {
                ANumber xv = xValuesSorted[i];
                ANumber xvP = xValuesSorted[i + 1];
                ANumber xvM = xValuesSorted[i - 1];
                firstDerivatives[i] = xvP.subtractGET(xv).multiplyGET(differences[i - 1]).addGET(xv.subtractGET(xvM).multiplyGET(differences[i])).divideGET(xvP.subtractGET(xvM));
            }
            else
            {
                firstDerivatives[i] = (wP.multiplyGET(differences[i - 1]).addGET(wM.multiplyGET(differences[i]))).divideGET(wP.addGET(wM));
            }

        }

        firstDerivatives[0] = differentiateThreePoint(xValuesSorted, yValuesSorted, 0, 0, 1, 2);
        firstDerivatives[1] = differentiateThreePoint(xValuesSorted, yValuesSorted, 1, 0, 1, 2);
        firstDerivatives[xValuesSorted.length - 2] = differentiateThreePoint(xValuesSorted, yValuesSorted, xValuesSorted.length - 2, xValuesSorted.length - 3, xValuesSorted.length - 2, xValuesSorted.length - 1);
        firstDerivatives[xValuesSorted.length - 1] = differentiateThreePoint(xValuesSorted, yValuesSorted, xValuesSorted.length - 1, xValuesSorted.length - 3, xValuesSorted.length - 2, xValuesSorted.length - 1);
        return interpolateHermiteSorted(xValuesSorted, yValuesSorted, firstDerivatives);
    }


    private static ANumber differentiateThreePoint(ANumber[] xvals, ANumber[] yvals, int indexOfDifferentiation, int indexOfFirstSample, int indexOfSecondsample, int indexOfThirdSample)
    {
        ANumber x0 = yvals[indexOfFirstSample];
        ANumber x1 = yvals[indexOfSecondsample];
        ANumber x2 = yvals[indexOfThirdSample];
        ANumber t = xvals[indexOfDifferentiation].subtractGET(xvals[indexOfFirstSample]);
        ANumber t1 = xvals[indexOfSecondsample].subtractGET(xvals[indexOfFirstSample]);
        ANumber t2 = xvals[indexOfThirdSample].subtractGET(xvals[indexOfFirstSample]);
        ANumber c1 = x2.subtractGET(x0);
        ANumber c2 = x1.subtractGET(x0);
        ANumber c3 = t2.divideGET(t1);
        ANumber a = c1.subtractGET(c2.multiplyGET(c3)).divideGET(t2.squareGET().subtractGET(t1.multiplyGET(t2)));
        ANumber b = c2.subtractGET(a.multiplyGET(t1.squareGET())).divideGET(t1);
        return a.multiplyGET(t).doubleGET().addGET(b);
    }


    private static PolynomialSpline interpolateHermiteSorted(ANumber[] xvals, ANumber[] yvals, ANumber[] firstDerivatives)
    {
        VectorRules.doVectorSizesMatch(xvals, yvals);
        VectorRules.doVectorSizesMatch(xvals, firstDerivatives);
        int size = xvals.length - 1;
        Polynomial[] polynomials = new Polynomial[size];
        ANumber[] coefficients = new ANumber[4];

        for(int i = 0; i < polynomials.length; i++)
        {
            ANumber w = xvals[i + 1].subtractGET(xvals[i]);
            ANumber w2 = w.squareGET();
            ANumber yv = yvals[i];
            ANumber yvP = yvals[i + 1];
            ANumber fd = firstDerivatives[i];
            ANumber fdP = firstDerivatives[i + 1];
            coefficients[0] = yv;
            coefficients[1] = firstDerivatives[i];
            ANumber a = yvP.subtractGET(yv).multiplyGET(3).divideGET(w);
            a.subtract(fd.doubleGET());
            a.subtract(fdP);
            coefficients[2] = a.divideGET(w);
            ANumber b = yv.subtractGET(yvP).doubleGET();
            coefficients[3] = b.divideGET(w).addGET(fd.addGET(fdP)).divideGET(w2);
            polynomials[i] = Polynomial.of(coefficients);
        }

        return PolynomialSpline.of(polynomials, Vector.of(xvals));
    }
}