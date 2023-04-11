package com.orion.machine_learning.training.element;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.training.element.characteristics.ElementCharacteristics;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;

public class Element<FEATURE_TYPE, LABEL_TYPE> extends Orion implements Cloneable
{
    private ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> characteristics;


    public Element(ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> characteristics)
    {
        ElementRules.isValid(characteristics);
        this.characteristics = characteristics;
    }


    public Element(DomainSet<FEATURE_TYPE> domainSet, Labels<LABEL_TYPE> labels)
    {
        ElementRules.isValid(domainSet, labels);
        this.characteristics = ElementCharacteristics.of(domainSet, labels);
    }


    public Element(DomainSet<FEATURE_TYPE> domainSet)
    {
        ElementRules.isValid(domainSet);
        this.characteristics = ElementCharacteristics.of(domainSet);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> Element<FEATURE_TYPE, LABEL_TYPE> of(ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> characteristics)
    {
        return new Element<FEATURE_TYPE, LABEL_TYPE>(characteristics);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> Element<FEATURE_TYPE, LABEL_TYPE> of(DomainSet<FEATURE_TYPE> domainSet, Labels<LABEL_TYPE> labels)
    {
        return new Element<FEATURE_TYPE, LABEL_TYPE>(domainSet, labels);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> Element<FEATURE_TYPE, LABEL_TYPE> of(DomainSet<FEATURE_TYPE> domainSet)
    {
        return new Element<FEATURE_TYPE, LABEL_TYPE>(domainSet);
    }


    public TrainingDataPoint<FEATURE_TYPE> getFeature(int index)
    {
        return getCharacteristics().getFeature(index);
    }


    public FEATURE_TYPE getFeatureValue(int index)
    {
        return getFeature(index).getValue();
    }


    public Label<LABEL_TYPE> getLabel(int index)
    {
        return getCharacteristics().getLabel(index);
    }


    public LABEL_TYPE getLabelValue(int index)
    {
        return getLabel(index).getValue();
    }


    @Override
    public int hashCode()
    {
        return ElementInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return ElementInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Element<FEATURE_TYPE, LABEL_TYPE> clone() throws CloneNotSupportedException
    {
        return (Element<FEATURE_TYPE, LABEL_TYPE>)CloningService.clone(this);
    }


    public Element<FEATURE_TYPE, LABEL_TYPE> getCopy()
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


    public ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> getCharacteristics()
    {
        return this.characteristics;
    }
}