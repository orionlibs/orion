package com.orion.math.statemachine.finite.deterministic.withoutput;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statemachine.InputAlphabet;
import com.orion.math.statemachine.InputAlphabetRules;
import com.orion.math.statemachine.OutputAlphabet;
import com.orion.math.statemachine.OutputAlphabetRules;
import com.orion.math.statemachine.OutputFunction;
import com.orion.math.statemachine.OutputFunctionRules;
import com.orion.math.statemachine.State;
import com.orion.math.statemachine.TransitionFunction;
import com.orion.math.statemachine.TransitionFunctionRules;

public class FiniteStateMachineWithOutputRules extends MathRule
{
    public static void isValid(OrionSet<State> states, InputAlphabet inputAlphabet, OutputAlphabet outputAlphabet, TransitionFunction transitionFunction, OutputFunction outputFunction)
    {
        Assert.notNull(states, "The states input cannot be null.");
        Assert.areEqual(states.filter(state -> state.isInitialState()).count(), 1, "There has to be one state marked to be an initial state.");
        InputAlphabetRules.isValid(inputAlphabet);
        OutputAlphabetRules.isValid(outputAlphabet);
        TransitionFunctionRules.isValid(transitionFunction);
        OutputFunctionRules.isValid(outputFunction);
    }


    public static void isValid(FiniteStateMachineWithOutput finiteStateMachineWithOutput)
    {
        Assert.notNull(finiteStateMachineWithOutput, "The finiteStateMachine input cannot be null.");
        isValid(finiteStateMachineWithOutput.getStates(), finiteStateMachineWithOutput.getInputAlphabet(), finiteStateMachineWithOutput.getOutputAlphabet(), finiteStateMachineWithOutput.getTransitionFunction(), finiteStateMachineWithOutput.getOutputFunction());
    }
}