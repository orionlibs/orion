package com.orion.machine_learning.domainset;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.machine_learning.training.element.training_data.TrainingData;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;

public class DomainSet<FEATURE_TYPE> extends Orion implements Cloneable
{
    private TrainingData<FEATURE_TYPE> trainingData;


    public DomainSet(TrainingData<FEATURE_TYPE> features)
    {
        DomainSetRules.isValid(features);
        this.trainingData = features;
    }


    public static <FEATURE_TYPE> DomainSet<FEATURE_TYPE> of(TrainingData<FEATURE_TYPE> features)
    {
        return new DomainSet<FEATURE_TYPE>(features);
    }


    public TrainingDataPoint<FEATURE_TYPE> get(int index)
    {
        return getTrainingData().get(index);
    }


    public FEATURE_TYPE getFeatureValue(int featureIndex)
    {
        return get(featureIndex).getValue();
    }


    public int getNumberOfFeatures()
    {
        return getTrainingData().getSize();
    }


    public boolean isSubsetOf(DomainSet<FEATURE_TYPE> other)
    {
        DomainSetRules.isValid(other);
        return other.getTrainingData().getTrainingDataPoints().containsAll(getTrainingData().getTrainingDataPoints());
    }


    public boolean isSupersetOf(DomainSet<FEATURE_TYPE> other)
    {
        DomainSetRules.isValid(other);
        return getTrainingData().getTrainingDataPoints().containsAll(other.getTrainingData().getTrainingDataPoints());
    }


    @Override
    public int hashCode()
    {
        return DomainSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return DomainSetInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public DomainSet<FEATURE_TYPE> clone() throws CloneNotSupportedException
    {
        return (DomainSet<FEATURE_TYPE>)CloningService.clone(this);
    }


    public DomainSet<FEATURE_TYPE> getCopy()
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


    public TrainingData<FEATURE_TYPE> getTrainingData()
    {
        return this.trainingData;
    }
}