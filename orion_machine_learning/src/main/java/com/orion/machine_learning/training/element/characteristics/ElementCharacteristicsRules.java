package com.orion.machine_learning.training.element.characteristics;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.domainset.DomainSetRules;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.element.label.LabelsRules;

public class ElementCharacteristicsRules<FEATURE_TYPE, LABEL_TYPE> extends Orion
{
    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(DomainSet<FEATURE_TYPE> features, Labels<LABEL_TYPE> labels)
    {
        DomainSetRules.isValid(features);
        LabelsRules.isValid(labels);
    }


    public static <FEATURE_TYPE> void isValid(DomainSet<FEATURE_TYPE> features)
    {
        DomainSetRules.isValid(features);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> elementCharacteristics)
    {

        if(elementCharacteristics == null)
        {
            throw new NullElementCharacteristicsException("ElementCharacteristics is null.");
        }

        isValid(elementCharacteristics.getDomainSet(), elementCharacteristics.getLabels());
    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValidDomainSet(ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> elementCharacteristics)
    {

        if(elementCharacteristics == null)
        {
            throw new NullElementCharacteristicsException("ElementCharacteristics is null.");
        }

        isValid(elementCharacteristics.getDomainSet());
    }
}