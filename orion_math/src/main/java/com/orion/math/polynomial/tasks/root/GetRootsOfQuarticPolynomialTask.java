package com.orion.math.polynomial.tasks.root;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Quadruple;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.polynomial.QuarticPolynomial;

public class GetRootsOfQuarticPolynomialTask extends Orion
{
    public static Quadruple<ANumber, ANumber, ANumber, ANumber> run(QuarticPolynomial polynomial, int nthRootPrecision)
    {
        PolynomialRules.isValid(polynomial);
        ANumber x1 = ANumber.of(0);
        ANumber x2 = ANumber.of(0);
        ANumber x3 = ANumber.of(0);
        ANumber x4 = ANumber.of(0);
        ANumber[] coefficients = polynomial.getCoefficientsCopy();
        ANumber a = coefficients[4];
        ANumber b = coefficients[3];
        ANumber c = coefficients[2];
        ANumber d = coefficients[1];
        ANumber e = coefficients[0];
        ANumber oneThird = ANumber.of(1).divideGET(3);
        ANumber cubicRoot2 = ANumber.of(2).getNthRoot(3, nthRootPrecision);
        ANumber aa = a.squareGET();
        ANumber aaa = aa.multiplyGET(a);
        ANumber bb = b.squareGET();
        ANumber bbb = bb.multiplyGET(b);
        ANumber cc = c.squareGET();
        ANumber ccc = cc.multiplyGET(c);
        ANumber bd = b.multiplyGET(d);
        ANumber ae = a.multiplyGET(e);
        ANumber k1 = bb.divideGET(aa).halfGET();
        ANumber k2 = oneThird.doubleGET().multiplyGET(c).divideGET(a);
        ANumber s = cc.subtractGET(ANumber.of(3).multiplyGET(bd)).addGET(ANumber.of(12).multiplyGET(ae));
        ANumber t = ccc.doubleGET().subtractGET(ANumber.of(9).multiplyGET(bd).multiplyGET(c)).addGET(ANumber.of(27).multiplyGET(a).multiplyGET(d).multiplyGET(d)).addGET(ANumber.of(27).multiplyGET(bb).multiplyGET(e)).subtractGET(ANumber.of(72).multiplyGET(ae).multiplyGET(c));
        ANumber u = (bbb.negateGET().addGET(ANumber.of(4).multiplyGET(a).multiplyGET(b).multiplyGET(c)).subtractGET(ANumber.of(8).multiplyGET(aa).multiplyGET(d))).divideGET(aaa).divideGET(ANumber.of(4));
        ANumber a1 = ANumber.of(ANumber.of(4).multiplyGET(s).exponentiateGET(3).addGET(t.squareGET()), 0);
        ANumber v = a1.getSquareRoot().addGET(ANumber.of(t, 0)).exponentiateGET(ANumber.of(oneThird, 0));
        ANumber w1 = ANumber.of(cubicRoot2.multiplyGET(oneThird).multiplyGET(s).divideGET(a), 0).divideGET(v);
        ANumber a3cbrt2 = a.multiplyGET(3).multiplyGET(cubicRoot2);
        ANumber w2 = ANumber.of(v.getAsANumber().divideGET(a3cbrt2), v.getImaginaryValueAsANumber().divideGET(a3cbrt2));
        ANumber w = w1.addGET(w2);
        ANumber x = ANumber.of(k1.halfGET().subtractGET(k2), 0).addGET(w).getSquareRoot(nthRootPrecision);
        ANumber y1 = ANumber.of(k1.subtractGET(k2.doubleGET()), 0).subtractGET(w);
        ANumber y2 = ANumber.of(u, 0).divideGET(x);
        ANumber sqrty1py2 = y1.addGET(y2).getSquareRoot(nthRootPrecision);
        ANumber sqrty1my2 = y1.subtractGET(y2).getSquareRoot(nthRootPrecision);
        ANumber z1 = ANumber.of(b.negateGET().divideGET(4).divideGET(a), 0);
        ANumber z2 = ANumber.of(x.getAsANumber().halfGET(), x.getImaginaryValueAsANumber().halfGET());
        ANumber z31 = ANumber.of(sqrty1py2.getAsANumber().halfGET(), sqrty1py2.getImaginaryValueAsANumber().halfGET());
        ANumber z32 = ANumber.of(sqrty1my2.getAsANumber().halfGET(), sqrty1my2.getImaginaryValueAsANumber().halfGET());
        x1 = z1.addGET(z2).subtractGET(z31);
        x2 = z1.addGET(z2).addGET(z31);
        x3 = z1.subtractGET(z2).subtractGET(z32);
        x4 = z1.subtractGET(z2).addGET(z32);
        return Quadruple.of(x1, x2, x3, x4);
    }
}