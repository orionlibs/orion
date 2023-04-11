package com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.statistics.regression.lineardiscriminantanalysis.onefeature.LinearDiscriminantAnalysis1FeatureRegressionParameters;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.ArrayList;
import java.util.List;

public class InitialiseParametersForLinearDiscriminantAnalysis1FeatureRegression extends Orion
{
    public static LinearDiscriminantAnalysis1FeatureRegressionParameters run(UnifeatureTrainingSet trainingSet)
    {
        List<ANumber> classes = trainingSet.getClasses();
        ANumber trainingSetSize = trainingSet.getSizeAsNumber();
        ANumber numberOfClasses = ANumber.of(classes.size());
        List<ANumber> averagesOfDataPointsForEachClass = new ArrayList<ANumber>();
        ANumber weightedAverageOfDataPointsVariancesForEachClass = ANumber.of(0);
        List<ANumber> probabilityOfEachClass = new ArrayList<ANumber>();

        for(ANumber class1 : classes)
        {
            List<ANumber> dataPointsWithClass = trainingSet.getDataPointsWithClass(class1);
            probabilityOfEachClass.add(ANumber.of(dataPointsWithClass.size()).divideGET(trainingSet.getSizeAsNumber()));
            ANumber average = ArithmeticService.add(dataPointsWithClass).divideGET(dataPointsWithClass.size());
            averagesOfDataPointsForEachClass.add(average);
            ANumber sum = ANumber.of(0);
            dataPointsWithClass.forEach(dataPointWithClass -> sum.add(dataPointWithClass.subtractGET(average).squareGET()));
            weightedAverageOfDataPointsVariancesForEachClass.add(sum);
        }

        weightedAverageOfDataPointsVariancesForEachClass.divide(trainingSetSize.subtractGET(numberOfClasses));
        return LinearDiscriminantAnalysis1FeatureRegressionParameters.of(averagesOfDataPointsForEachClass, weightedAverageOfDataPointsVariancesForEachClass, probabilityOfEachClass);
    }
}