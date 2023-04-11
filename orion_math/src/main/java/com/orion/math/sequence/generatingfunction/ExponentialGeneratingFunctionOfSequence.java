package com.orion.math.sequence.generatingfunction;

import com.orion.math.function.Functions;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.sequence.Sequence;
import java.util.List;
import java.util.stream.IntStream;

public class ExponentialGeneratingFunctionOfSequence extends GeneratingFunctionOfSequence
{
    private Polynomial polynomialExpressionOfSequence;


    public ExponentialGeneratingFunctionOfSequence(Sequence sequence, int numberOfTermsToUse)
    {
        GeneratingFunctionOfSequenceRules.isValid(sequence, numberOfTermsToUse);
        List<ANumber> terms = sequence.getFirstNTerms(numberOfTermsToUse);
        IntStream.range(0, terms.size()).forEach(i -> terms.set(i, terms.get(i).divideGET(Functions.factorial.run(ANumber.of(i)))));
        this.polynomialExpressionOfSequence = Polynomial.of(terms);
        setExpression(polynomialExpressionOfSequence.getAsFunction().getFunctionCasted());
    }


    public static ExponentialGeneratingFunctionOfSequence of(Sequence sequence, int numberOfTermsToUse)
    {
        return new ExponentialGeneratingFunctionOfSequence(sequence, numberOfTermsToUse);
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