package com.orion.math.statemachine.finite.deterministic.withoutoutput;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashSet;
import com.orion.core.tuple.Pair;
import com.orion.core.tuple.Triple;
import com.orion.math.statemachine.InputAlphabet;
import com.orion.math.statemachine.State;
import com.orion.math.statemachine.StateMachine;
import com.orion.math.statemachine.TransitionStateCheckingFunction;
import java.util.stream.Collectors;

public class FiniteStateAutomaton extends StateMachine
{
    private OrionSet<State> states;
    private State initialState;
    private OrionSet<State> finalStates;
    private InputAlphabet inputAlphabet;
    private TransitionStateCheckingFunction transitionStateCheckingFunction;


    public FiniteStateAutomaton(OrionSet<State> states, InputAlphabet inputAlphabet, TransitionStateCheckingFunction transitionStateCheckingFunction)
    {
        FiniteStateAutomatonRules.isValid(states, inputAlphabet, transitionStateCheckingFunction);
        this.states = states;
        this.initialState = states.filter(state -> state.isInitialState()).collect(Collectors.toList()).get(0);
        this.finalStates = OrionHashSet.<State>of(states.filter(state -> state.isFinalState()).collect(Collectors.toSet()));
        this.inputAlphabet = inputAlphabet;
        this.transitionStateCheckingFunction = transitionStateCheckingFunction;
    }


    public static FiniteStateAutomaton of(OrionSet<State> states, InputAlphabet inputAlphabet, TransitionStateCheckingFunction transitionStateCheckingFunction)
    {
        return new FiniteStateAutomaton(states, inputAlphabet, transitionStateCheckingFunction);
    }


    public Triple<State, Object, Boolean> run(State state, Object inputValueFromInputAlphabet)
    {
        Pair<State, Object> result = getTransitionStateCheckingFunction().run(state, inputValueFromInputAlphabet);
        boolean reachedFinalState = finalStates.contains(result.getFirst());
        return Triple.<State, Object, Boolean>of(result.getFirst(), result.getSecond(), reachedFinalState);
    }


    public OrionSet<State> getStates()
    {
        return this.states;
    }


    public State getInitialState()
    {
        return this.initialState;
    }


    public InputAlphabet getInputAlphabet()
    {
        return this.inputAlphabet;
    }


    public OrionSet<State> getFinalStates()
    {
        return this.finalStates;
    }


    public TransitionStateCheckingFunction getTransitionStateCheckingFunction()
    {
        return this.transitionStateCheckingFunction;
    }
}