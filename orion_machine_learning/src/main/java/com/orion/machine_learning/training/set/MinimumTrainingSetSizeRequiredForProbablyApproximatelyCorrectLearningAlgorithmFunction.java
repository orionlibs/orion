package com.orion.machine_learning.training.set;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;

public class MinimumTrainingSetSizeRequiredForProbablyApproximatelyCorrectLearningAlgorithmFunction extends Orion
{
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formula;
    static
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f = (ANumber numberOfHypotheses, ANumber probabilityDistributionWillGenerateMisleadingTrainingSet,
                        ANumber generalisationError) -> (numberOfHypotheses.divideGET(probabilityDistributionWillGenerateMisleadingTrainingSet).getNeperianLogarithm().divideGET(generalisationError));
        formula = Function3x1.of(f);
    }


    public static ANumber run(ANumber numberOfHypotheses, ANumber probabilityDistributionWillGenerateMisleadingTrainingSet, ANumber generalisationError)
    {
        return formula.run(numberOfHypotheses, probabilityDistributionWillGenerateMisleadingTrainingSet, generalisationError);
    }
}