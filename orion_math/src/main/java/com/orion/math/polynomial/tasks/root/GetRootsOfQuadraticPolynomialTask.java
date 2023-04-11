package com.orion.math.polynomial.tasks.root;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.polynomial.QuadraticPolynomial;

public class GetRootsOfQuadraticPolynomialTask extends Orion
{
    public static Pair<ANumber, ANumber> run(QuadraticPolynomial polynomial, int squareRootPrecision)
    {
        PolynomialRules.isValid(polynomial);
        ANumber b = polynomial.getCoefficientCopy(1);
        ANumber bSquared = b.squareGET();
        ANumber a = polynomial.getCoefficientCopy(2);
        ANumber c = polynomial.getCoefficientCopy(0);
        ANumber discriminant = bSquared.subtractGET(ANumber.of(4).multiplyGET(a.multiplyGET(c)));
        ANumber twoA = a.doubleGET();
        ANumber squareRootOfDiscriminant = discriminant.getSquareRoot(squareRootPrecision);
        ANumber x1 = b.negateGET().subtractGET(squareRootOfDiscriminant).divideGET(twoA);
        ANumber x2 = b.negateGET().addGET(squareRootOfDiscriminant).divideGET(twoA);
        return Pair.of(x1, x2);
    }
}