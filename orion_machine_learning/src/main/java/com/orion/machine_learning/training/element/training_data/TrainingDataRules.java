package com.orion.machine_learning.training.element.training_data;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPointRules;
import java.util.Arrays;
import java.util.List;

public class TrainingDataRules extends Orion
{
    private static final String FEATURES_ARE_NULL_EMPTY = "Features are null/empty.";


    public static <T> void isValid(OrionList<? extends TrainingDataPoint<T>> features)
    {

        if(features == null || features.isEmpty())
        {
            throw new NullTrainingDataException(FEATURES_ARE_NULL_EMPTY);
        }

        features.forAll(feature -> TrainingDataPointRules.isValid(feature));
    }


    public static <T> void isValid(List<? extends TrainingDataPoint<T>> features)
    {

        if(features == null || features.isEmpty())
        {
            throw new NullTrainingDataException(FEATURES_ARE_NULL_EMPTY);
        }

        features.forEach(feature -> TrainingDataPointRules.isValid(feature));
    }


    @SuppressWarnings("unchecked")
    public static <T> void isValid(TrainingDataPoint<T>... features)
    {

        if(features == null || features.length == 0)
        {
            throw new NullTrainingDataException(FEATURES_ARE_NULL_EMPTY);
        }

        Arrays.stream(features).forEach(feature -> TrainingDataPointRules.isValid(feature));
    }


    public static <T> void isValid(TrainingData<T> features)
    {

        if(features == null)
        {
            throw new NullTrainingDataException("Features is null/empty.");
        }

        isValid(features.getTrainingDataPoints());
    }
}