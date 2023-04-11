package com.orion.math.probability.distribution.discrete.binomial;

import com.orion.core.abstraction.Orion;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.probability.event.simple.SimpleEvent;
import java.util.HashMap;
import java.util.Map;

public class BinomialDistribution extends Orion
{
    private SimpleEvent<ANumber> event1;
    private SimpleEvent<ANumber> event2;
    private ANumber numberOfObservations;
    private ANumber probabilityOfEvent1;
    private ANumber probabilityOfEvent2;
    private Map<ANumber, ANumber> eventAndItsProbabilityMapper;
    private Function3x1<ANumber, ANumber, Map<ANumber, ANumber>, ANumber> formula;


    public BinomialDistribution(SimpleEvent<ANumber> event1, SimpleEvent<ANumber> event2, ANumber numberOfObservations, ANumber probabilityOfEvent1, ANumber probabilityOfEvent2)
    {
        BinomialDistributionRules.isValid(event1, event2, numberOfObservations, probabilityOfEvent1, probabilityOfEvent2);
        this.event1 = event1;
        this.event2 = event2;
        this.numberOfObservations = numberOfObservations;
        this.probabilityOfEvent1 = probabilityOfEvent1;
        this.probabilityOfEvent2 = probabilityOfEvent2;
        this.eventAndItsProbabilityMapper = createEventAndItsProbabilityMapper();
        Function3x1IF<ANumber, ANumber, Map<ANumber, ANumber>, ANumber> f = (ANumber event, ANumber numberOfObservations1, Map<ANumber, ANumber> eventAndItsProbabilityMapper1) ->
        {
            BinomialDistributionRules.isValidEvent(this, event);
            ANumber numberOfCombinations = CombinatoricsService.getNumberOfCombinations(numberOfObservations1, event);
            ANumber probabilityOfEvent = eventAndItsProbabilityMapper.get(event).exponentiateGET(event);
            ANumber otherEvent = getOtherEventGiven(event);
            ANumber probabilityOfEvent2a = eventAndItsProbabilityMapper.get(otherEvent).exponentiateGET(numberOfObservations1.subtractGET(event));
            return numberOfCombinations.multiplyGET(probabilityOfEvent).multiplyGET(probabilityOfEvent2a);
        };
        formula = Function3x1.<ANumber, ANumber, Map<ANumber, ANumber>, ANumber>of(f);
    }


    public static BinomialDistribution of(SimpleEvent<ANumber> event1, SimpleEvent<ANumber> event2, ANumber numberOfObservations, ANumber probabilityOfEvent1, ANumber probabilityOfEvent2)
    {
        return new BinomialDistribution(event1, event2, numberOfObservations, probabilityOfEvent1, probabilityOfEvent2);
    }


    private Map<ANumber, ANumber> createEventAndItsProbabilityMapper()
    {
        Map<ANumber, ANumber> temp = new HashMap<ANumber, ANumber>();
        temp.put(event1.getValue(), probabilityOfEvent1);
        temp.put(event2.getValue(), probabilityOfEvent2);
        return temp;
    }


    public ANumber getProbability(ANumber event)
    {
        return formula.run(event, numberOfObservations, eventAndItsProbabilityMapper);
    }


    public ANumber getOtherEventGiven(ANumber event)
    {

        if(event.equal(event1.getValue()))
        {
            return event2.getValue();
        }
        else if(event.equal(event2.getValue()))
        {
            return event1.getValue();
        }

        return null;
    }


    public ANumber getExpectedValue()
    {
        return numberOfObservations.multiplyGET(probabilityOfEvent1);
    }


    public ANumber getVariance()
    {
        return getExpectedValue().multiplyGET(probabilityOfEvent2);
    }


    public ANumber getStandardDeviation()
    {
        return getVariance().getSquareRoot();
    }


    public SimpleEvent<ANumber> getEvent1()
    {
        return this.event1;
    }


    public SimpleEvent<ANumber> getEvent2()
    {
        return this.event2;
    }


    public ANumber getNumberOfObservations()
    {
        return this.numberOfObservations;
    }


    public ANumber getProbabilityOfEvent1()
    {
        return this.probabilityOfEvent1;
    }


    public ANumber getProbabilityOfEvent2()
    {
        return this.probabilityOfEvent2;
    }


    public Map<ANumber, ANumber> getEventAndItsProbabilityMapper()
    {
        return this.eventAndItsProbabilityMapper;
    }
}