package com.orion.math.probability;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.stream.IntStream;

public class ProbabilityService extends OrionService
{
    public static ANumber getSimpleProbabilityOfOccurence(ANumber numberOfWaysEventOccurs, ANumber totalNumberOfPossibleOutcomes)
    {
        NumberRules.areNotNull(numberOfWaysEventOccurs, totalNumberOfPossibleOutcomes);
        return numberOfWaysEventOccurs.divideGET(totalNumberOfPossibleOutcomes);
    }


    public static ANumber getJointProbabilityOfOccurence(Vector probabilityOfEachEvent, ANumber totalNumberOfPossibleOutcomes)
    {
        VectorRules.isValid(probabilityOfEachEvent);
        NumberRules.isNotNull(totalNumberOfPossibleOutcomes);
        return ArithmeticService.multiply(probabilityOfEachEvent).divideGET(totalNumberOfPossibleOutcomes);
    }


    public static ANumber getMarginalProbabilityOfOccurence(Vector jointProbabilityOfEventAndOtherEvents)
    {
        VectorRules.isValid(jointProbabilityOfEventAndOtherEvents);
        return ArithmeticService.add(jointProbabilityOfEventAndOtherEvents);
    }


    public static boolean areEventsIndependent(ANumber probabilityOfEvent1GivenEvent2, ANumber probabilityOfEvent1)
    {
        NumberRules.areNotNull(probabilityOfEvent1GivenEvent2, probabilityOfEvent1);
        return probabilityOfEvent1GivenEvent2.equal(probabilityOfEvent1);
    }


    public static ANumber getProbabilityOfJointIndependentEvents(Vector probabilityOfEachEvent)
    {
        VectorRules.isValid(probabilityOfEachEvent);
        return ArithmeticService.multiply(probabilityOfEachEvent);
    }


    public static boolean areEventsIndependent(ANumber jointProbabilityOfEvents, Vector probabilityOfEachEvent)
    {
        NumberRules.isNotNull(jointProbabilityOfEvents);
        return ArithmeticService.multiply(probabilityOfEachEvent).equal(jointProbabilityOfEvents);
    }


    public static ANumber getMarginalProbabilityOfEvent(Vector probabilityOfEventGivenEachOtherEvent, Vector probabilityOfEachOtherEvent)
    {
        VectorRules.doVectorSizesMatch(probabilityOfEventGivenEachOtherEvent, probabilityOfEachOtherEvent);
        ANumber sum = ANumber.of(0);
        IntStream.range(0, probabilityOfEventGivenEachOtherEvent.getDimensions())
                        .forEach(i -> sum.add(probabilityOfEventGivenEachOtherEvent.get(i).multiplyGET(probabilityOfEachOtherEvent.get(i))));
        return sum;
    }


    public static ANumber getNumberOfPossibleOutcomesOfMutuallyExclusiveEvents(ANumber numberOfEvents, ANumber numberOfTrials)
    {
        NumberRules.haveNaturalNumberValue(numberOfEvents, numberOfTrials);
        return numberOfEvents.exponentiateGET(numberOfTrials);
    }


    public static ANumber getNumberOfPossibleOutcomesWithDifferentEventsOnEachTrial(Vector numberOfEventsOnEachTrial)
    {
        VectorRules.hasNaturalNumbers(numberOfEventsOnEachTrial);
        return ArithmeticService.multiply(numberOfEventsOnEachTrial);
    }
}