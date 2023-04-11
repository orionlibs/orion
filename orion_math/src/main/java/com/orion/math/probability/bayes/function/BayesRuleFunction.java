package com.orion.math.probability.bayes.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;

public class BayesRuleFunction extends Orion
{
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToGetProbabilityOfXGivenY;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToGetProbabilityOfYGivenX;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToGetProbabilityOfX;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToGetProbabilityOfY;
    static
    {
        //P(X|Y) = P(Y|X)P(Y) / P(X)
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f1 = (ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfX) -> (probabilityOfYGivenX.multiplyGET(probabilityOfY).divideGET(probabilityOfX));
        formulaToGetProbabilityOfXGivenY = Function3x1.of(f1);
        //P(Y|X) = P(X|Y)P(X) / P(Y)
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f2 = (ANumber probabilityOfXGivenY, ANumber probabilityOfY, ANumber probabilityOfX) -> (probabilityOfXGivenY.multiplyGET(probabilityOfX).divideGET(probabilityOfY));
        formulaToGetProbabilityOfYGivenX = Function3x1.of(f2);
        //P(X) = P(Y|X)P(Y) / P(X|Y)
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f3 = (ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfXGivenY) -> (probabilityOfYGivenX.multiplyGET(probabilityOfY).divideGET(probabilityOfXGivenY));
        formulaToGetProbabilityOfX = Function3x1.of(f3);
        //P(Y) = P(X|Y)P(X) / P(Y|X)
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f4 = (ANumber probabilityOfXGivenY, ANumber probabilityOfX, ANumber probabilityOfYGivenX) -> (probabilityOfXGivenY.multiplyGET(probabilityOfX).divideGET(probabilityOfYGivenX));
        formulaToGetProbabilityOfY = Function3x1.of(f4);
    }


    public static ANumber getProbabilityOfXGivenY(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfXGivenY(probabilityOfYGivenX, probabilityOfY, probabilityOfX);
        return formulaToGetProbabilityOfXGivenY.run(probabilityOfYGivenX, probabilityOfY, probabilityOfX);
    }


    public static ANumber getProbabilityOfYGivenX(ANumber probabilityOfXGivenY, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfYGivenX(probabilityOfXGivenY, probabilityOfY, probabilityOfX);
        return formulaToGetProbabilityOfYGivenX.run(probabilityOfXGivenY, probabilityOfY, probabilityOfX);
    }


    public static ANumber getProbabilityOfX(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfXGivenY)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfX(probabilityOfYGivenX, probabilityOfY, probabilityOfXGivenY);
        return formulaToGetProbabilityOfX.run(probabilityOfYGivenX, probabilityOfY, probabilityOfXGivenY);
    }


    public static ANumber getProbabilityOfY(ANumber probabilityOfXGivenY, ANumber probabilityOfX, ANumber probabilityOfYGivenX)
    {
        BayesRuleFunctionRules.isValidToGetProbabilityOfY(probabilityOfXGivenY, probabilityOfX, probabilityOfYGivenX);
        return formulaToGetProbabilityOfX.run(probabilityOfXGivenY, probabilityOfX, probabilityOfYGivenX);
    }
}