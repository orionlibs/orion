package com.orion.machine_learning.training.element.training_data;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import java.util.List;

public class TrainingData<T> extends Orion implements Cloneable
{
    private OrionList<? extends TrainingDataPoint<T>> trainingDataPoints;


    public TrainingData(OrionList<? extends TrainingDataPoint<T>> features)
    {
        TrainingDataRules.isValid(features);
        this.trainingDataPoints = features;
    }


    public TrainingData(List<? extends TrainingDataPoint<T>> features)
    {
        TrainingDataRules.isValid(features);
        this.trainingDataPoints = OrionArrayList.of(features);
    }


    @SuppressWarnings("unchecked")
    public TrainingData(TrainingDataPoint<T>... features)
    {
        TrainingDataRules.isValid(features);
        this.trainingDataPoints = OrionArrayList.of(features);
    }


    public static <T> TrainingData<T> of(OrionList<? extends TrainingDataPoint<T>> features)
    {
        return new TrainingData<T>(features);
    }


    public static <T> TrainingData<T> of(List<? extends TrainingDataPoint<T>> features)
    {
        return new TrainingData<T>(features);
    }


    @SuppressWarnings("unchecked")
    public static <T> TrainingData<T> of(TrainingDataPoint<T>... features)
    {
        return new TrainingData<T>(features);
    }


    public TrainingDataPoint<T> get(int index)
    {
        return getTrainingDataPoints().get(index);
    }


    public T getFeatureValue(int index)
    {
        return get(index).getValue();
    }


    public int getSize()
    {
        return getTrainingDataPoints().getSize();
    }


    @Override
    public int hashCode()
    {
        return TrainingDataInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return TrainingDataInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public TrainingData<T> clone() throws CloneNotSupportedException
    {
        return (TrainingData<T>)CloningService.clone(this);
    }


    public TrainingData<T> getCopy()
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


    public OrionList<? extends TrainingDataPoint<T>> getTrainingDataPoints()
    {
        return this.trainingDataPoints;
    }
}