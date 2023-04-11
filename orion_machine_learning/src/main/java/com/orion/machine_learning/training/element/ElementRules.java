package com.orion.machine_learning.training.element;

import com.orion.core.abstraction.Orion;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.domainset.DomainSetRules;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.element.label.LabelsRules;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristics;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristicsRules;
import java.util.List;

public class ElementRules<FEATURE_TYPE, LABEL_TYPE> extends Orion
{
    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> characteristics)
    {
        ElementCharacteristicsRules.isValidDomainSet(characteristics);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(DomainSet<FEATURE_TYPE> domainSet, Labels<LABEL_TYPE> labels)
    {
        DomainSetRules.isValid(domainSet);
        LabelsRules.isValid(labels);
    }


    public static <FEATURE_TYPE> void isValid(DomainSet<FEATURE_TYPE> domainSet)
    {
        DomainSetRules.isValid(domainSet);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> void isValid(Element<FEATURE_TYPE, LABEL_TYPE> element)
    {

        if(element == null)
        {
            throw new NullElementException("Element is null.");
        }

        isValid(element.getCharacteristics());
    }


    public static <FEATURE_TYPE, LABEL_TYPE> void areValid(List<Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {

        if(elements == null || elements.isEmpty())
        {
            throw new NullElementException("Elements are null.");
        }

        elements.forEach(element -> isValid(element));
    }
}