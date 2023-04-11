package com.orion.math.probability.distribution.discrete.binomial;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.probability.event.simple.SimpleEvent;
import com.orion.math.probability.event.simple.SimpleEventRules;

public class BinomialDistributionRules extends MathRule
{
    public static void isValid(SimpleEvent<ANumber> event1, SimpleEvent<ANumber> event2, ANumber numberOfObservations, ANumber probabilityOfEvent1, ANumber probabilityOfEvent2)
    {
        SimpleEventRules.<ANumber>isValid(event1);
        SimpleEventRules.<ANumber>isValid(event2);
        NumberRules.hasNaturalNumberValue(numberOfObservations);
        NumberRules.isBetween(probabilityOfEvent1, 0, 1);
        Assert.isFalse(Numbers.notEqual(probabilityOfEvent1, ANumber.of(1).subtractGET(probabilityOfEvent2)), "probabilityOfEvent1 has to equal 1-probabilityOfEvent2.");
    }


    public static void isValid(BinomialDistribution distribution)
    {
        Assert.notNull(distribution, "the BinomialDistribution input cannot be null.");
        isValid(distribution.getEvent1(), distribution.getEvent2(), distribution.getNumberOfObservations(), distribution.getProbabilityOfEvent1(), distribution.getProbabilityOfEvent2());
    }


    public static void isValidEvent(BinomialDistribution distribution, ANumber event)
    {
        Assert.isFalse(!distribution.getEvent1().getValue().notEqual(event), "Given event does not exist.");
        Assert.isFalse(!distribution.getEvent2().getValue().notEqual(event), "Given event does not exist.");
        Assert.isFalse(Numbers.isLessThanOrEqual(event, distribution.getNumberOfObservations()), "numberOfEventsOfInterest has to be <= numberOfObservations.");
    }
}