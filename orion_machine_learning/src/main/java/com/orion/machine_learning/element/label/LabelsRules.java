package com.orion.machine_learning.element.label;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import java.util.Arrays;
import java.util.List;

public class LabelsRules<T> extends Orion
{
    private static final String LABELS_ARE_NULL = "Labels are null.";


    public static <T> void isValid(OrionList<? extends Label<T>> labels)
    {

        if(labels == null)
        {
            throw new NullLabelException(LABELS_ARE_NULL);
        }

        labels.forAll(label -> LabelRules.isValid(label));
    }


    public static <T> void isValid(List<? extends Label<T>> labels)
    {

        if(labels == null)
        {
            throw new NullLabelException(LABELS_ARE_NULL);
        }

        labels.forEach(label -> LabelRules.isValid(label));
    }


    @SuppressWarnings("unchecked")
    public static <T> void isValid(Label<T>... labels)
    {

        if(labels == null || labels.length == 0)
        {
            throw new NullLabelException(LABELS_ARE_NULL);
        }

        Arrays.stream(labels).forEach(label -> LabelRules.isValid(label));
    }


    public static <T> void isValid(Labels<T> labels)
    {

        if(labels == null)
        {
            throw new NullLabelException(LABELS_ARE_NULL);
        }

        isValid(labels.getLabels());
    }
}