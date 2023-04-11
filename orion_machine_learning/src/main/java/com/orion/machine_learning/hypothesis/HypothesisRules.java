package com.orion.machine_learning.hypothesis;

import com.orion.core.abstraction.Orion;
import com.orion.core.runnable.functions.OrionFunction;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;

public class HypothesisRules extends Orion
{
    public static void isValid(OrionFunction formula)
    {
        FunctionRules.isValid(formula);
    }


    public static void isValid(Function formula)
    {
        FunctionRules.isValid(formula);
    }


    @SuppressWarnings("rawtypes")
    public static void isValid(Hypothesis hypothesis)
    {

        if(hypothesis == null)
        {
            throw new NullHypothesisException("Hypothesis is null.");
        }

        isValid(hypothesis.getFormula());
    }
}