package com.orion.math.sequence.generatingfunction;

import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.MathObject;
import com.orion.math.MathRule;
import com.orion.math.function.Functions;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.sequence.Sequence;

public class GeneratingFunctionOfSequenceRules extends MathRule
{
    public static void isValid(Function1x1IF<ANumber, ANumber> expression)
    {
        Assert.isFalse(Functions.isNotValid(expression), "Series analytic function is empty.");
    }


    public static void isValid(MathObject expression)
    {
        Assert.notNull(expression, "The expression input for the generating function cannot be null.");

        if(expression instanceof Function1x1IF == false && expression instanceof Polynomial == false)
        {
            throw new InvalidArgumentException("The given expression for the generating function has to be a polynomial or an instance of Function1x1IF.");
        }
        else if(expression instanceof Polynomial)
        {
            PolynomialRules.isValid((Polynomial)expression);
        }

    }


    public static void isValid(Sequence sequence, int numberOfTermsToUse)
    {
        Assert.notNull(sequence, "The sequence input to build the generating function cannot be null.");
        NumberRules.isPositive(numberOfTermsToUse);
    }
}