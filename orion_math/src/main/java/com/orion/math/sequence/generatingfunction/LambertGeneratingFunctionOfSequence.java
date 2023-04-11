package com.orion.math.sequence.generatingfunction;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.sequence.Sequence;
import java.util.List;

public class LambertGeneratingFunctionOfSequence extends GeneratingFunctionOfSequence
{
    private Function1x1<ANumber, ANumber> expressionOfSequence;


    public LambertGeneratingFunctionOfSequence(Sequence sequence, int numberOfTermsToUse)
    {
        GeneratingFunctionOfSequenceRules.isValid(sequence, numberOfTermsToUse);
        List<ANumber> terms = sequence.getFirstNTerms(numberOfTermsToUse);
        Function1x1IF<ANumber, ANumber> function = (ANumber x) ->
        {
            ANumber value = ANumber.of(0);

            for(int i = 1; i <= numberOfTermsToUse; i++)
            {
                ANumber a = terms.get(i - 1).multiplyGET(x.exponentiateGET(i));
                ANumber b = ANumber.of(1).subtractGET(x.exponentiateGET(i));
                value.add(a.divideGET(b));
            }

            return value;
        };
        this.expressionOfSequence = Function1x1.<ANumber, ANumber>of(function);
        setExpression(expressionOfSequence.getFunctionCasted());
    }


    public static LambertGeneratingFunctionOfSequence of(Sequence sequence, int numberOfTermsToUse)
    {
        return new LambertGeneratingFunctionOfSequence(sequence, numberOfTermsToUse);
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