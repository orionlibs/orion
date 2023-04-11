package com.orion.math.probability.bayes.function;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class BayesRuleFunctionRules extends MathRule
{
    public static void isValidToGetProbabilityOfXGivenY(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        Assert.isFalse(Numbers.isNegative(probabilityOfYGivenX), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfY), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfX), "BayesRuleFunction component(s) is/are negative.");
    }


    public static void isValidToGetProbabilityOfYGivenX(ANumber probabilityOfXGivenY, ANumber probabilityOfY, ANumber probabilityOfX)
    {
        Assert.isFalse(Numbers.isNegative(probabilityOfXGivenY), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfY), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfX), "BayesRuleFunction component(s) is/are negative.");
    }


    public static void isValidToGetProbabilityOfX(ANumber probabilityOfYGivenX, ANumber probabilityOfY, ANumber probabilityOfXGivenY)
    {
        Assert.isFalse(Numbers.isNegative(probabilityOfYGivenX), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfY), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfXGivenY), "BayesRuleFunction component(s) is/are negative.");
    }


    public static void isValidToGetProbabilityOfY(ANumber probabilityOfXGivenY, ANumber probabilityOfX, ANumber probabilityOfYGivenX)
    {
        Assert.isFalse(Numbers.isNegative(probabilityOfXGivenY), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfX), "BayesRuleFunction component(s) is/are negative.");
        Assert.isFalse(Numbers.isNegative(probabilityOfYGivenX), "BayesRuleFunction component(s) is/are negative.");
    }
}