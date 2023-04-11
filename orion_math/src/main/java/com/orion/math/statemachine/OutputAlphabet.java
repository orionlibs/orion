package com.orion.math.statemachine;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathObject;

public class OutputAlphabet extends Orion implements MathObject
{
    private OrionSet<Object> alphabet;


    public OutputAlphabet(OrionSet<Object> alphabet)
    {
        OutputAlphabetRules.isValid(alphabet);
        this.alphabet = alphabet;
    }


    public static OutputAlphabet of(OrionSet<Object> alphabet)
    {
        return new OutputAlphabet(alphabet);
    }


    public OrionSet<Object> getAlphabet()
    {
        return this.alphabet;
    }
}