package com.orion.math.statistics;

import com.orion.core.abstraction.OrionService;
import com.orion.math.error.ErrorService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.average.AverageService;
import com.orion.math.number.average.function.ArithmeticAverageFunction;
import com.orion.math.number.interval.Interval;
import com.orion.math.statistics.data.quartile.Quartiles;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;
import com.orion.math.statistics.tasks.query.GetCovarianceTask;
import com.orion.math.statistics.tasks.query.GetKurtosisTask;
import com.orion.math.statistics.tasks.query.GetMeanAbsoluteDeviationTask;
import com.orion.math.statistics.tasks.query.GetModeTask;
import com.orion.math.statistics.tasks.query.GetPercentileTask;
import com.orion.math.statistics.tasks.query.GetSkewnessTask;
import com.orion.math.statistics.trainingset.UnifeatureTrainingSet;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StatisticsService extends OrionService
{
    public static ANumber getMean(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return ArithmeticAverageFunction.run(numbers.getAsArray());
    }


    public static ANumber getStandardErrorOfMean(Vector population, ANumber sampleSize)
    {
        VectorRules.isValid(population);
        NumberRules.isNotNull(sampleSize);
        return getPopulationStandardDeviation(population).divideGET(sampleSize.getSquareRoot());
    }


    public static ANumber getStandardErrorOfMean(ANumber populationStandardDeviation, ANumber sampleSize)
    {
        NumberRules.isNotNull(populationStandardDeviation);
        return populationStandardDeviation.divideGET(sampleSize.getSquareRoot());
    }


    public static ANumber getMeanAbsoluteDeviation(Vector numbers)
    {
        return GetMeanAbsoluteDeviationTask.run(numbers);
    }


    public static Interval getConfidenceIntervalForMean(ANumber sampleMean, ANumber populationStandardDeviation, ANumber criticalValue, ANumber sampleSize)
    {
        NumberRules.areNotNull(sampleMean, populationStandardDeviation, criticalValue);
        NumberRules.hasNaturalNumberValue(sampleSize);
        ANumber leftEndpoint = sampleMean.subtractGET(populationStandardDeviation.multiplyGET(criticalValue).divideGET(sampleSize.getSquareRoot()));
        ANumber rightEndpoint = sampleMean.addGET(populationStandardDeviation.multiplyGET(criticalValue).divideGET(sampleSize.getSquareRoot()));
        return Interval.of(leftEndpoint, rightEndpoint);
    }


    public static Interval getConfidenceIntervalForMean(Vector sample, Vector population, ANumber criticalValue)
    {
        VectorRules.areValid(sample, population);
        NumberRules.isNotNull(criticalValue);
        return getConfidenceIntervalForMean(sample.getArithmeticAverage(), getPopulationStandardDeviation(population), criticalValue, sample.getDimensionsAsNumber());
    }


    public static Interval getConfidenceIntervalForMeanWithUnknownStandardDeviation(ANumber sampleMean, ANumber sampleSize, ANumber sampleVariance, ANumber tStatistic)
    {
        NumberRules.areNotNull(sampleMean, sampleVariance, tStatistic);
        NumberRules.hasNaturalNumberValue(sampleSize);
        ANumber leftEndpoint = sampleMean.subtractGET(tStatistic.multiplyGET(sampleVariance).divideGET(sampleSize.getSquareRoot()));
        ANumber rightEndpoint = sampleMean.addGET(tStatistic.multiplyGET(sampleVariance).divideGET(sampleSize.getSquareRoot()));
        return Interval.of(leftEndpoint, rightEndpoint);
    }


    public static Interval getConfidenceIntervalForMeanWithUnknownStandardDeviation(Vector sample, Vector population, ANumber tStatistic)
    {
        VectorRules.areValid(sample, population);
        NumberRules.isNotNull(tStatistic);
        ANumber sampleVariance = getSampleVariance(sample);
        return getConfidenceIntervalForMeanWithUnknownStandardDeviation(sample.getArithmeticAverage(), sample.getDimensionsAsNumber(), sampleVariance, tStatistic);
    }


    public static Interval getConfidenceIntervalForPopulationProportion(ANumber sampleProportion, ANumber sampleSize, ANumber criticalValue)
    {
        NumberRules.areNotNull(sampleProportion, sampleSize, criticalValue);
        ANumber standardErrorOfProportion = sampleProportion.multiplyGET(ANumber.of(1).subtractGET(sampleProportion)).divideGET(sampleSize);
        ANumber leftEndpoint = sampleProportion.subtractGET(standardErrorOfProportion.multiplyGET(criticalValue));
        ANumber rightEndpoint = sampleProportion.addGET(standardErrorOfProportion.multiplyGET(criticalValue));
        return Interval.of(leftEndpoint, rightEndpoint);
    }


    public static ANumber getBiasCorrectedVariance(Vector numbers)
    {
        VectorRules.isValid(numbers);
        ANumber sum = ANumber.of(0);
        numbers.forAll(x -> sum.add(ErrorService.getErrorSquared(x, getMean(numbers))));
        return sum.divideGET(numbers.getDimensions() - 1);
    }


    public static ANumber getSampleVariance(Vector numbers)
    {
        return getBiasCorrectedVariance(numbers);
    }


    public static ANumber getPopulationVariance(Vector numbers)
    {
        VectorRules.isValid(numbers);
        ANumber sum = ANumber.of(0);
        numbers.forAll(x -> sum.add(ErrorService.getErrorSquared(x, getMean(numbers))));
        return sum.divideGET(numbers.getDimensions());
    }


    public static ANumber getPopulationStandardDeviation(Vector numbers)
    {
        return getPopulationVariance(numbers).getSquareRoot();
    }


    public static ANumber getSampleStandardDeviation(Vector numbers)
    {
        return getBiasCorrectedVariance(numbers).getSquareRoot();
    }


    public static ANumber getVariance(Vector numbers, Map<ANumber, ANumber> probabilityOfEachValueMapper)
    {
        StatisticsRules.isValidForVariance(numbers, probabilityOfEachValueMapper);
        ANumber sum = ANumber.of(0);
        ANumber expectedValue = getExpectedValue(numbers, probabilityOfEachValueMapper);
        IntStream.range(0, numbers.getDimensions())
                        .forEach(i -> numbers.get(i).subtractGET(expectedValue).squareGET().multiplyGET(probabilityOfEachValueMapper.get(numbers.get(i))));
        return sum;
    }


    public static ANumber getVarianceOfSumOf2Variables(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        ANumber variance1 = getVariance(vector1, probabilityOfEachValueInVector1);
        ANumber variance2 = getVariance(vector2, probabilityOfEachValueInVector2);
        ANumber covariance = getCovariance(vector1, probabilityOfEachValueInVector1, vector2, probabilityOfEachValueInVector2, jointProbabilityOfVector1And2);
        return variance1.addGET(variance2).addGET(covariance.doubleGET());
    }


    public static ANumber getStandardDeviationOfSumOf2Variables(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        return getVarianceOfSumOf2Variables(vector1, probabilityOfEachValueInVector1, vector2, probabilityOfEachValueInVector2, jointProbabilityOfVector1And2).getSquareRoot();
    }


    public static ANumber getSkewness(Vector numbers)
    {
        return GetSkewnessTask.run(numbers, getMean(numbers), getPopulationStandardDeviation(numbers));
    }


    public static ANumber getKurtosis(Vector numbers)
    {
        return GetKurtosisTask.run(numbers, getMean(numbers), getPopulationVariance(numbers));
    }


    public static boolean isLepokurtic(Vector numbers)
    {
        return getKurtosis(numbers).isPositive();
    }


    public static boolean isPlatykurtic(Vector numbers)
    {
        return getKurtosis(numbers).isNegative();
    }


    public static ANumber getPercentile(Vector numbers, ANumber percentile)
    {
        return GetPercentileTask.run(numbers, percentile);
    }


    public static ANumber getPercentile(Vector numbers, Number percentile)
    {
        return GetPercentileTask.run(numbers, ANumber.of(percentile));
    }


    public static ANumber getMedian(Vector numbers)
    {
        return getPercentile(numbers, 50);
    }


    public static ANumber getSumOfSquaredDifferences(Vector vector1, Vector vector2)
    {
        VectorRules.doVectorSizesMatch(vector1, vector2);
        ANumber sumOfSquaredDifferences = ANumber.of(0);
        IntStream.range(0, vector1.getDimensions())
                        .forEach(i -> sumOfSquaredDifferences.add(ErrorService.getErrorSquared(vector1.get(i), vector2.get(i))));
        return sumOfSquaredDifferences;
    }


    public static ANumber getSumOfSquaredDifferencesFromTheMean(Vector vector)
    {
        VectorRules.isValid(vector);
        ANumber mean = getMean(vector);
        ANumber sumOfSquaredDifferences = ANumber.of(0);
        IntStream.range(0, vector.getDimensions())
                        .forEach(i -> sumOfSquaredDifferences.add(ErrorService.getErrorSquared(vector.get(i), mean)));
        return sumOfSquaredDifferences;
    }


    public static ANumber getExpectedValueOfSquaredDifferences(Vector vector1, Vector vector2)
    {
        return getSumOfSquaredDifferences(vector1, vector2).divideGET(vector1.getDimensions());
    }


    public static SimpleLinearRegression getLinearRegression(UnifeatureTrainingSet trainingSet)
    {
        return SimpleLinearRegression.of(trainingSet);
    }


    public static ANumber getCorrelation(Vector vector1, Vector vector2)
    {
        return getCovariance(vector1, vector2).divideGET(getSampleStandardDeviation(vector1).multiplyGET(getSampleStandardDeviation(vector2)));
    }


    public static Vector getMeanVector(List<Vector> vectors)
    {
        return AverageService.getArithmeticAverageVector(vectors);
    }


    public static Vector getMeanVector(Vector[] vectors)
    {
        return AverageService.getArithmeticAverageVector(vectors);
    }


    public static Vector getMeanVector(Vector vector1, Vector vector2)
    {
        return AverageService.getArithmeticAverageVector(vector1, vector2);
    }


    public static ANumber getExpectedValue(Vector vector, Map<ANumber, ANumber> probabilityOfEachValueInVector)
    {
        StatisticsRules.isValidForExpectedValue(vector, probabilityOfEachValueInVector);
        ANumber sum = ANumber.of(0);
        IntStream.range(0, vector.getDimensions())
                        .forEach(i -> vector.get(i).multiplyGET(probabilityOfEachValueInVector.get(vector.get(i))));
        return sum;
    }


    public static ANumber getExpectedValueOfSumOf2Variables(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2)
    {
        StatisticsRules.isValidForExpectedValueOfSumOf2Variables(vector1, probabilityOfEachValueInVector1, vector2, probabilityOfEachValueInVector2);
        return getExpectedValue(vector1, probabilityOfEachValueInVector1).addGET(getExpectedValue(vector2, probabilityOfEachValueInVector2));
    }


    public static ANumber getCovariance(Vector vector1, Vector vector2)
    {
        return GetCovarianceTask.run(vector1, vector2);
    }


    public static ANumber getCovariance(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2, Map<Integer, ANumber> jointProbabilityOfVector1And2)
    {
        ANumber expectedValue1 = getExpectedValue(vector1, probabilityOfEachValueInVector1);
        ANumber expectedValue2 = getExpectedValue(vector2, probabilityOfEachValueInVector2);
        return GetCovarianceTask.run(vector1, probabilityOfEachValueInVector1, vector2, probabilityOfEachValueInVector2, jointProbabilityOfVector1And2, expectedValue1, expectedValue2);
    }


    public static ANumber getCovariance(Vector vector)
    {
        return getBiasCorrectedVariance(vector);
    }


    public static List<ANumber> getMode(Vector numbers)
    {
        return GetModeTask.run(numbers);
    }


    public static ANumber getRange(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return numbers.getMaximum().subtractGET(numbers.getMinimum());
    }


    public static ANumber getCoefficientOfVariation(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return getSampleStandardDeviation(numbers).divideGET(getMean(numbers)).multiplyGET(100);
    }


    public static ANumber getZScore(Vector numbers, ANumber valueForWhichToMeasureZScore)
    {
        VectorRules.contains(numbers, valueForWhichToMeasureZScore);
        return valueForWhichToMeasureZScore.subtractGET(getMean(numbers)).divideGET(getSampleStandardDeviation(numbers));
    }


    public static Quartiles getQuartiles(Vector numbers)
    {
        return Quartiles.of(numbers);
    }


    public static ANumber getInterquartileRange(Vector numbers)
    {
        Quartiles quartiles = getQuartiles(numbers);
        return quartiles.getQuartile3().subtractGET(quartiles.getQuartile1());
    }


    public static ANumber getCoefficientOfCorrelation(Vector x, Vector y)
    {
        return getCovariance(x, y).divideGET(getSampleStandardDeviation(x).multiplyGET(getSampleStandardDeviation(y)));
    }


    public static ANumber getSampleSizeNeededForMean(ANumber confidenceLevel, ANumber acceptableSamplingError, ANumber populationStandardDeviation)
    {
        NumberRules.areNotNull(confidenceLevel, acceptableSamplingError, populationStandardDeviation);
        return confidenceLevel.squareGET().multiplyGET(populationStandardDeviation.squareGET()).divideGET(acceptableSamplingError.squareGET());
    }


    public static ANumber getSampleSizeNeededForProportion(ANumber confidenceLevel, ANumber acceptableSamplingError, ANumber populationProportion)
    {
        NumberRules.areNotNull(confidenceLevel, acceptableSamplingError, populationProportion);
        ANumber a = populationProportion.multiplyGET(ANumber.of(1).subtractGET(populationProportion));
        return confidenceLevel.squareGET().multiplyGET(a).divideGET(acceptableSamplingError.squareGET());
    }
}