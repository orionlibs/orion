package com.orion.math.statemachine;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;

public class State extends Orion implements MathObject
{
    private boolean isInitialState;
    private boolean isFinalState;


    public State(boolean isInitialState, boolean isFinalState)
    {
        this.isInitialState = isInitialState;
        this.isFinalState = isFinalState;
    }


    public static State of(boolean isInitialState, boolean isFinalState)
    {
        return new State(isInitialState, isFinalState);
    }


    public boolean isInitialState()
    {
        return this.isInitialState;
    }


    public boolean isFinalState()
    {
        return this.isFinalState;
    }
}