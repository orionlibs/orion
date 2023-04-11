package com.orion.math.sequence.generatingfunction;

import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.sequence.Sequence;
import java.util.List;

public class OrdinaryGeneratingFunctionOfSequence extends GeneratingFunctionOfSequence
{
    private Polynomial polynomialExpressionOfSequence;


    public OrdinaryGeneratingFunctionOfSequence(Sequence sequence, int numberOfTermsToUse)
    {
        GeneratingFunctionOfSequenceRules.isValid(sequence, numberOfTermsToUse);
        List<ANumber> terms = sequence.getFirstNTerms(numberOfTermsToUse);
        this.polynomialExpressionOfSequence = Polynomial.of(terms);
        setExpression(polynomialExpressionOfSequence.getAsFunction().getFunctionCasted());
    }


    public static OrdinaryGeneratingFunctionOfSequence of(Sequence sequence, int numberOfTermsToUse)
    {
        return new OrdinaryGeneratingFunctionOfSequence(sequence, numberOfTermsToUse);
    }


    public ANumber run(ANumber x)
    {
        return polynomialExpressionOfSequence.getValueFor(x);
    }


    public Polynomial getPolynomialExpressionOfSequence()
    {
        return this.polynomialExpressionOfSequence;
    }
}