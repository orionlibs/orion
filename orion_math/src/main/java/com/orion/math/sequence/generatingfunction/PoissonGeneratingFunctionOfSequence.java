package com.orion.math.sequence.generatingfunction;

import com.orion.math.function.Functions;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1Service;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.sequence.Sequence;

public class PoissonGeneratingFunctionOfSequence extends GeneratingFunctionOfSequence
{
    private Function1x1<ANumber, ANumber> expressionOfSequence;


    @SuppressWarnings("unchecked")
    public PoissonGeneratingFunctionOfSequence(Sequence sequence, int numberOfTermsToUse)
    {
        GeneratingFunctionOfSequenceRules.isValid(sequence, numberOfTermsToUse);
        Polynomial polynomial = ExponentialGeneratingFunctionOfSequence.of(sequence, numberOfTermsToUse).getPolynomialExpressionOfSequence();
        this.expressionOfSequence = Function1x1Service.multiply(Functions.exp, polynomial.getAsFunction());
        setExpression(expressionOfSequence.getFunctionCasted());
    }


    public static PoissonGeneratingFunctionOfSequence of(Sequence sequence, int numberOfTermsToUse)
    {
        return new PoissonGeneratingFunctionOfSequence(sequence, numberOfTermsToUse);
    }


    public ANumber run(ANumber x)
    {
        return expressionOfSequence.run(x);
    }


    public Function1x1<ANumber, ANumber> getExpressionOfSequence()
    {
        return this.expressionOfSequence;
    }
}