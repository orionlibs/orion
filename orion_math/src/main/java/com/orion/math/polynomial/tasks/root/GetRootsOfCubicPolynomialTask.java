package com.orion.math.polynomial.tasks.root;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Triple;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.CubicPolynomial;
import com.orion.math.polynomial.PolynomialRules;

public class GetRootsOfCubicPolynomialTask extends Orion
{
    public static Triple<ANumber, ANumber, ANumber> run(CubicPolynomial polynomial, int nthRootPrecision)
    {
        PolynomialRules.isValid(polynomial);
        ANumber x1 = ANumber.of(0);
        ANumber x2 = ANumber.of(0);
        ANumber x3 = ANumber.of(0);
        ANumber[] coefficients = polynomial.getCoefficientsCopy();
        ANumber a = coefficients[3];
        ANumber b = coefficients[2];
        ANumber c = coefficients[1];
        ANumber d = coefficients[0];
        ANumber aa = a.squareGET();
        ANumber bb = b.squareGET();
        ANumber q = (ANumber.of(3).multiplyGET(a).multiplyGET(c).subtractGET(bb)).divideGET(aa.multiplyGET(9));
        ANumber r = (ANumber.of(9).multiplyGET(a).multiplyGET(b).multiplyGET(c).subtractGET(ANumber.of(27).multiplyGET(aa).multiplyGET(d)).subtractGET(ANumber.of(2).multiplyGET(bb).multiplyGET(b)).divideGET(ANumber.of(54).multiplyGET(aa).multiplyGET(a)));
        ANumber bOver3a = b.divideGET(ANumber.of(3).multiplyGET(a));
        ANumber qqq = q.exponentiateGET(3);
        ANumber D = qqq.addGET(r.squareGET());
        ANumber DSqrt = D.getSquareRoot(nthRootPrecision);
        ANumber root3Over2 = ANumber.of(3).getSquareRoot(nthRootPrecision).halfGET();

        if(D.isNonNegative())
        {
            ANumber s = r.addGET(DSqrt).getNthRoot(3, nthRootPrecision);
            ANumber t = r.subtractGET(DSqrt).getNthRoot(3, nthRootPrecision);
            ANumber spt = s.addGET(t);
            ANumber smt = s.subtractGET(t);
            ANumber rootRe = spt.negateGET().halfGET().subtractGET(bOver3a);
            ANumber rootIm = smt.multiplyGET(root3Over2);
            x1 = spt.subtractGET(bOver3a);
            x2 = ANumber.of(rootRe, rootIm);
            x3 = ANumber.of(rootRe, rootIm.negateGET());
        }
        else
        {
            ANumber rho = qqq.negateGET().getSquareRoot(nthRootPrecision);
            ANumber theta = r.divideGET(rho).getArccosine(nthRootPrecision);
            ANumber mod = rho.getNthRoot(3, nthRootPrecision);
            ANumber arg = theta.divideGET(3);
            ANumber s = ANumber.ofPolarCoordinates(mod, arg);
            ANumber t = ANumber.ofPolarCoordinates(mod, arg.negateGET());
            ANumber spt = s.addGET(t);
            ANumber smt = s.subtractGET(t);
            ANumber r1 = spt.divideGET(ANumber.of(-2, 0)).subtractGET(ANumber.of(bOver3a, 0));
            ANumber r2 = smt.multiplyGET(ANumber.of(0, root3Over2));
            x1 = spt.subtractGET(ANumber.of(bOver3a, 0)).getAsANumber();
            x2 = r1.addGET(r2).getAsANumber();
            x3 = r1.subtractGET(r2).getAsANumber();
        }

        return Triple.of(x1, x2, x3);
    }
}