package com.orion.machine_learning.domainset;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data.TrainingDataRules;

public class DomainSetRules<FEATURE_TYPE> extends Orion
{
    public static <FEATURE_TYPE> void isValid(TrainingData<FEATURE_TYPE> features)
    {
        TrainingDataRules.isValid(features);
    }


    public static <FEATURE_TYPE> void isValid(DomainSet<FEATURE_TYPE> domainSet)
    {

        if(domainSet == null)
        {
            throw new NullDomainSetException("DomainSet is null.");
        }

        isValid(domainSet.getTrainingData());
    }
}