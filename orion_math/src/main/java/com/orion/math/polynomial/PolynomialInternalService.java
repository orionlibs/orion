package com.orion.math.polynomial;

import com.orion.math.MathObject;
import com.orion.math.polynomial.tasks.PolynomialEqualsTask;
import com.orion.math.polynomial.tasks.PolynomialHashCodeTask;

class PolynomialInternalService implements MathObject
{
    static boolean equals(Polynomial x, Object y)
    {
        return PolynomialEqualsTask.run(x, y);
    }


    static int hashCode(Polynomial x)
    {
        return PolynomialHashCodeTask.run(x);
    }
}