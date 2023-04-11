package com.orion.machine_learning.classification.k_nearest_neighbours.error;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.classification.k_nearest_neighbours.KNearestNeighboursRules;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.ElementRules;
import com.orion.machine_learning.training.set.TrainingSet;
import com.orion.machine_learning.training.set.TrainingSetRules;
import com.orion.math.number.ANumber;
import java.util.List;

public class KNearestNeighboursErrorRules<LABEL_TYPE> extends Orion
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static <LABEL_TYPE> void isValid(Element<ANumber, LABEL_TYPE> elementToClassify, String expectedLabel, TrainingSet trainingSet, int k)
    {
        ElementRules.isValid(elementToClassify);
        KNearestNeighboursRules.isValid(trainingSet, k);

        if(expectedLabel == null || expectedLabel.isEmpty())
        {
            throw new InvalidExpectedLabelForKNearestNeighboursErrorException("Expected label is null/empty.");
        }

    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static <LABEL_TYPE> void isValid(List<Element<ANumber, LABEL_TYPE>> elementsToClassify, TrainingSet trainingSet, int k)
    {
        ElementRules.areValid(elementsToClassify);
        KNearestNeighboursRules.isValid(trainingSet, k);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static <LABEL_TYPE> void isValid(TrainingSet<ANumber, LABEL_TYPE> trainingSetToClassify, TrainingSet trainingSet, int k)
    {
        TrainingSetRules.isValid(trainingSetToClassify);
        KNearestNeighboursRules.isValid(trainingSet, k);
    }
}