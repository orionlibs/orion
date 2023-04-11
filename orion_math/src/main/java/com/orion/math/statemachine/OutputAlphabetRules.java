package com.orion.math.statemachine;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class OutputAlphabetRules extends MathRule
{
    public static void isValid(OrionSet<Object> alphabet)
    {
        Assert.notEmpty(alphabet, "The alphabet input cannot be null/empty.");
    }


    public static void isValid(OutputAlphabet outputAlphabet)
    {
        Assert.notNull(outputAlphabet, "The outputAlphabet input cannot be null.");
        isValid(outputAlphabet.getAlphabet());
    }
}