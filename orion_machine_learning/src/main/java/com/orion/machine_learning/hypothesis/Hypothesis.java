package com.orion.machine_learning.hypothesis;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.core.reflection.method.access.ReflectionMethodAccessService;
import com.orion.core.runnable.functions.OrionFunction;
import com.orion.math.function.Function;
import com.orion.math.function.Functions;
import java.lang.reflect.Method;

public class Hypothesis<LABEL_TYPE> extends Orion implements Cloneable
{
    private OrionFunction formula;


    public Hypothesis()
    {
    }


    public Hypothesis(OrionFunction formula)
    {
        HypothesisRules.isValid(formula);
        this.formula = formula;
    }


    public Hypothesis(Function formula)
    {
        HypothesisRules.isValid(formula);
        this.formula = formula.getFunction();
    }


    public static <LABEL_TYPE> Hypothesis<LABEL_TYPE> of(OrionFunction formula)
    {
        return new Hypothesis<LABEL_TYPE>(formula);
    }


    public static <LABEL_TYPE> Hypothesis<LABEL_TYPE> of(Function formula)
    {
        return new Hypothesis<LABEL_TYPE>(formula);
    }


    @SuppressWarnings("unchecked")
    public LABEL_TYPE run(Object[] args)
    {
        Method method = Functions.getRunMethod(formula);
        return (LABEL_TYPE)ReflectionMethodAccessService.callMethod(method, formula, args);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Hypothesis<LABEL_TYPE> clone() throws CloneNotSupportedException
    {
        return (Hypothesis<LABEL_TYPE>)CloningService.clone(this);
    }


    public Hypothesis<LABEL_TYPE> getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public OrionFunction getFormula()
    {
        return this.formula;
    }


    protected void setFormula(OrionFunction formula)
    {
        this.formula = formula;
    }
}