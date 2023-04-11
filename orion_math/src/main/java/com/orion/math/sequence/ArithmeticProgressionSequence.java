package com.orion.math.sequence;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class ArithmeticProgressionSequence extends Sequence
{
    private ANumber term0;
    private ANumber step;


    public ArithmeticProgressionSequence(ANumber term0, ANumber step)
    {
        NumberRules.areNotNull(term0, step);
        this.term0 = term0;
        this.step = step;
        setExpression(buildFormula());
    }


    public static ArithmeticProgressionSequence of(ANumber term0, ANumber step)
    {
        return new ArithmeticProgressionSequence(term0, step);
    }


    private Function1x1IF<ANumber, ANumber> buildFormula()
    {
        return (ANumber n) -> (calculateNthTerm(n));
    }


    private ANumber calculateNthTerm(ANumber n)
    {
        return term0.addGET(step.multiplyGET(n));
    }


    @Override
    public ANumber getSumOfFirstNTerms(ANumber n)
    {
        return term0.addGET(getNthTerm(n)).multiplyGET(n.addOneGET());
    }


    public ANumber getSumOfInfiniteTerms()
    {
        return term0.divideGET(ANumber.of(1).subtractGET(step));
    }


    public ANumber getTerm0()
    {
        return this.term0;
    }


    public ANumber getStep()
    {
        return this.step;
    }
}