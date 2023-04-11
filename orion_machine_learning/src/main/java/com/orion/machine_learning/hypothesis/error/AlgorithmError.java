package com.orion.machine_learning.hypothesis.error;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public abstract class AlgorithmError extends Orion
{
    private ANumber error;


    public ANumber getError()
    {
        return this.error;
    }


    protected void setError(ANumber error)
    {
        this.error = error;
    }
}