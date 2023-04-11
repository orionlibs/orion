package com.orion.math.statemachine;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.math.MathObject;

public class InputAlphabet extends Orion implements MathObject
{
    private OrionSet<Object> alphabet;


    public InputAlphabet(OrionSet<Object> alphabet)
    {
        InputAlphabetRules.isValid(alphabet);
        this.alphabet = alphabet;
    }


    public static InputAlphabet of(OrionSet<Object> alphabet)
    {
        return new InputAlphabet(alphabet);
    }


    public OrionSet<Object> getAlphabet()
    {
        return this.alphabet;
    }
}