package com.orion.math.statemachine.finite.deterministic.withoutoutput;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statemachine.InputAlphabet;
import com.orion.math.statemachine.InputAlphabetRules;
import com.orion.math.statemachine.State;
import com.orion.math.statemachine.TransitionStateCheckingFunction;
import com.orion.math.statemachine.TransitionStateCheckingFunctionRules;
import java.util.stream.Collectors;

public class FiniteStateAutomatonRules extends MathRule
{
    public static void isValid(OrionSet<State> states, InputAlphabet inputAlphabet, TransitionStateCheckingFunction transitionStateCheckingFunction)
    {
        Assert.notNull(states, "The states input cannot be null.");
        Assert.areEqual(states.filter(state -> state.isInitialState()).count(), 1, "There has to be one state marked to be an initial state.");
        Assert.notEmpty(states.filter(state -> state.isFinalState()).collect(Collectors.toSet()), "There has to be at least one state marked as final state.");
        InputAlphabetRules.isValid(inputAlphabet);
        TransitionStateCheckingFunctionRules.isValid(transitionStateCheckingFunction);
    }


    public static void isValid(FiniteStateAutomaton finiteStateAutomaton)
    {
        Assert.notNull(finiteStateAutomaton, "The finiteStateMachine input cannot be null.");
        isValid(finiteStateAutomaton.getStates(), finiteStateAutomaton.getInputAlphabet(), finiteStateAutomaton.getTransitionStateCheckingFunction());
    }
}