package com.orion.math.sequence;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciSequence extends Sequence
{
    private static Function1x1<ANumber, ANumber> expression;
    static
    {
        Function1x1IF<ANumber, ANumber> function = (ANumber n) -> (calculateNthTerm(n));
        expression = Function1x1.<ANumber, ANumber>of(function);
    }


    @SuppressWarnings("unchecked")
    public FibonacciSequence()
    {
        super((Function1x1IF<ANumber, ANumber>)expression.getFunction());
    }


    public static FibonacciSequence of()
    {
        return new FibonacciSequence();
    }


    private static ANumber calculateNthTerm(ANumber n)
    {
        NumberRules.isPositive(n);
        List<ANumber> terms = new ArrayList<ANumber>();
        terms.add(ANumber.of(1));
        terms.add(ANumber.of(1));
        BigInteger termMinus2 = BigInteger.ONE;
        BigInteger termMinus1 = BigInteger.ONE;
        BigInteger termN = BigInteger.ONE;

        for(BigInteger i = BigInteger.valueOf(3); i.compareTo(n.getAsInteger()) < 1; i = i.add(BigInteger.ONE))
        {
            termN = termMinus1.add(termMinus2);
            termMinus2 = termMinus1;
            termMinus1 = termN;
            terms.add(ANumber.of(termN));
        }

        return terms.get(terms.size() - 1);
    }
}