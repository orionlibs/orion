package com.orion.math.probability.event.inclusionexclusion;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;

public class InclusionExclusionFunction extends Orion
{
    private ANumber probabilityOfAOrB;
    private ANumber probabilityOfA;
    private ANumber probabilityOfB;
    private ANumber probabilityOfAAndB;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToFindProbabilityOfAOrB;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToFindProbabilityOfA;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToFindProbabilityOfB;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToFindProbabilityOfAAndB;
    static
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f1 = (ANumber probabilityOfA, ANumber probabilityOfB, ANumber probabilityOfAAndB) ->
        {
            return probabilityOfA.addGET(probabilityOfB).subtractGET(probabilityOfAAndB);
        };
        formulaToFindProbabilityOfAOrB = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f1);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f2 = (ANumber probabilityOfAOrB, ANumber probabilityOfB, ANumber probabilityOfAAndB) ->
        {
            return probabilityOfAOrB.subtractGET(probabilityOfB).addGET(probabilityOfAAndB);
        };
        formulaToFindProbabilityOfA = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f2);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f3 = (ANumber probabilityOfAOrB, ANumber probabilityOfA, ANumber probabilityOfAAndB) ->
        {
            return probabilityOfAOrB.subtractGET(probabilityOfA).addGET(probabilityOfAAndB);
        };
        formulaToFindProbabilityOfB = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f3);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f4 = (ANumber probabilityOfAOrB, ANumber probabilityOfA, ANumber probabilityOfB) ->
        {
            return probabilityOfA.subtractGET(probabilityOfAOrB).addGET(probabilityOfB);
        };
        formulaToFindProbabilityOfAAndB = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f4);
    }


    public InclusionExclusionFunction(ANumber probabilityOfAOrB, ANumber probabilityOfA, ANumber probabilityOfB, ANumber probabilityOfAAndB)
    {
        this.probabilityOfAOrB = probabilityOfAOrB;
        this.probabilityOfA = probabilityOfA;
        this.probabilityOfB = probabilityOfB;
        this.probabilityOfAAndB = probabilityOfAAndB;
    }


    public static InclusionExclusionFunction ofFindAOrB(ANumber probabilityOfA, ANumber probabilityOfB, ANumber probabilityOfAAndB)
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfA, probabilityOfB, probabilityOfAAndB);
        return new InclusionExclusionFunction(null, probabilityOfA, probabilityOfB, probabilityOfAAndB);
    }


    public static InclusionExclusionFunction ofFindA(ANumber probabilityOfAOrB, ANumber probabilityOfB, ANumber probabilityOfAAndB)
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfB, probabilityOfAAndB);
        return new InclusionExclusionFunction(probabilityOfAOrB, null, probabilityOfB, probabilityOfAAndB);
    }


    public static InclusionExclusionFunction ofFindB(ANumber probabilityOfAOrB, ANumber probabilityOfA, ANumber probabilityOfAAndB)
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfA, probabilityOfAAndB);
        return new InclusionExclusionFunction(probabilityOfAOrB, probabilityOfA, null, probabilityOfAAndB);
    }


    public static InclusionExclusionFunction ofFindAAndB(ANumber probabilityOfAOrB, ANumber probabilityOfA, ANumber probabilityOfB)
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfA, probabilityOfB);
        return new InclusionExclusionFunction(probabilityOfAOrB, probabilityOfA, probabilityOfB, null);
    }


    public ANumber getProbabilityOfAOrB()
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfA, probabilityOfB, probabilityOfAAndB);
        return formulaToFindProbabilityOfAOrB.run(probabilityOfA, probabilityOfB, probabilityOfAAndB);
    }


    public ANumber getProbabilityOfA()
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfB, probabilityOfAAndB);
        return formulaToFindProbabilityOfA.run(probabilityOfAOrB, probabilityOfB, probabilityOfAAndB);
    }


    public ANumber getProbabilityOfB()
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfA, probabilityOfAAndB);
        return formulaToFindProbabilityOfB.run(probabilityOfAOrB, probabilityOfA, probabilityOfAAndB);
    }


    public ANumber getProbabilityOfAAndB()
    {
        InclusionExclusionFunctionRules.isValid(probabilityOfAOrB, probabilityOfA, probabilityOfB);
        return formulaToFindProbabilityOfAAndB.run(probabilityOfAOrB, probabilityOfA, probabilityOfB);
    }
}