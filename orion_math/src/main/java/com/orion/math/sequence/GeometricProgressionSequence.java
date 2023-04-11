package com.orion.math.sequence;

import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GeometricProgressionSequence extends Sequence
{
    private ANumber term0;
    private ANumber ratio;


    public GeometricProgressionSequence(ANumber term0, ANumber ratio)
    {
        NumberRules.areNotNull(term0, ratio);
        this.term0 = term0;
        this.ratio = ratio;
        setExpression(buildFormula());
    }


    public static GeometricProgressionSequence of(ANumber term0, ANumber ratio)
    {
        return new GeometricProgressionSequence(term0, ratio);
    }


    private Function1x1IF<ANumber, ANumber> buildFormula()
    {
        return (ANumber n) -> (calculateNthTerm(n));
    }


    private ANumber calculateNthTerm(ANumber n)
    {
        return term0.multiplyGET(ratio.exponentiateGET(n));
    }


    @Override
    public ANumber getSumOfFirstNTerms(ANumber n)
    {

        if(ratio.isOne())
        {
            return term0.multiplyGET(n.addOneGET());
        }
        else
        {
            return term0.multiplyGET(ratio.exponentiateGET(n.addOneGET())).subtractGET(term0).divideGET(ratio.subtractOneGET());
        }

    }


    public ANumber getSumOfInfiniteTerms()
    {
        return term0.divideGET(ANumber.of(1).subtractGET(ratio));
    }


    public ANumber getTerm0()
    {
        return this.term0;
    }


    public ANumber getRatio()
    {
        return this.ratio;
    }
}