package com.orion.math.statemachine.finite.deterministic.withoutput;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.tuple.Pair;
import com.orion.math.statemachine.InputAlphabet;
import com.orion.math.statemachine.OutputAlphabet;
import com.orion.math.statemachine.OutputFunction;
import com.orion.math.statemachine.State;
import com.orion.math.statemachine.StateMachine;
import com.orion.math.statemachine.TransitionFunction;
import java.util.stream.Collectors;

public class FiniteStateMachineWithOutput extends StateMachine
{
    private OrionSet<State> states;
    private State initialState;
    private InputAlphabet inputAlphabet;
    private OutputAlphabet outputAlphabet;
    private TransitionFunction transitionFunction;
    private OutputFunction outputFunction;


    public FiniteStateMachineWithOutput(OrionSet<State> states, InputAlphabet inputAlphabet, OutputAlphabet outputAlphabet, TransitionFunction transitionFunction, OutputFunction outputFunction)
    {
        FiniteStateMachineWithOutputRules.isValid(states, inputAlphabet, outputAlphabet, transitionFunction, outputFunction);
        this.states = states;
        this.initialState = states.filter(state -> state.isInitialState()).collect(Collectors.toList()).get(0);
        this.inputAlphabet = inputAlphabet;
        this.outputAlphabet = outputAlphabet;
        this.transitionFunction = transitionFunction;
        this.outputFunction = outputFunction;
    }


    public static FiniteStateMachineWithOutput of(OrionSet<State> states, InputAlphabet inputAlphabet, OutputAlphabet outputAlphabet, TransitionFunction transitionFunction, OutputFunction outputFunction)
    {
        return new FiniteStateMachineWithOutput(states, inputAlphabet, outputAlphabet, transitionFunction, outputFunction);
    }


    public Pair<State, Object> run(State state, Object inputValueFromInputAlphabet)
    {
        return getTransitionFunction().run(state, inputValueFromInputAlphabet);
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


    public OutputAlphabet getOutputAlphabet()
    {
        return this.outputAlphabet;
    }


    public TransitionFunction getTransitionFunction()
    {
        return this.transitionFunction;
    }


    public OutputFunction getOutputFunction()
    {
        return this.outputFunction;
    }
}