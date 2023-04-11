package com.orion.machine_learning.training.set;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.machine_learning.training.element.Element;
import java.util.List;

public class TrainingSetRules<FEATURE_TYPE, LABEL_TYPE> extends Orion
{
    private static final String ELEMENTS_ARE_NULL = "Elements are null.";


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(OrionList<? extends Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {

        if(elements == null || elements.isEmpty())
        {
            throw new NullTrainingSetException(ELEMENTS_ARE_NULL);
        }

    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(List<? extends Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {

        if(elements == null || elements.isEmpty())
        {
            throw new NullTrainingSetException(ELEMENTS_ARE_NULL);
        }

    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(Element<FEATURE_TYPE, LABEL_TYPE>... elements)
    {

        if(elements == null || elements.length == 0)
        {
            throw new NullTrainingSetException(ELEMENTS_ARE_NULL);
        }

    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(TrainingSet<FEATURE_TYPE, LABEL_TYPE> trainingSet)
    {

        if(trainingSet == null)
        {
            throw new NullTrainingSetException("TrainingSet is null.");
        }

        isValid(trainingSet.getElements());
    }
}