package com.orion.machine_learning.training.element.characteristics;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.machine_learning.domainset.DomainSet;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.element.label.Labels;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;

public class ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> extends Orion implements Cloneable
{
    private DomainSet<FEATURE_TYPE> domainSet;
    private Labels<LABEL_TYPE> labels;


    public ElementCharacteristics(DomainSet<FEATURE_TYPE> domainSet, Labels<LABEL_TYPE> labels)
    {
        ElementCharacteristicsRules.isValid(domainSet, labels);
        this.domainSet = domainSet;
        this.labels = labels;
    }


    public ElementCharacteristics(DomainSet<FEATURE_TYPE> domainSet)
    {
        ElementCharacteristicsRules.isValid(domainSet);
        this.domainSet = domainSet;
        this.labels = null;
    }


    public static <FEATURE_TYPE, LABEL_TYPE> ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> of(DomainSet<FEATURE_TYPE> domainSet, Labels<LABEL_TYPE> labels)
    {
        return new ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE>(domainSet, labels);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> of(DomainSet<FEATURE_TYPE> domainSet)
    {
        return new ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE>(domainSet);
    }


    public TrainingDataPoint<FEATURE_TYPE> getFeature(int index)
    {
        return getDomainSet().get(index);
    }


    public FEATURE_TYPE getFeatureValue(int index)
    {
        return getDomainSet().getFeatureValue(index);
    }


    public Label<LABEL_TYPE> getLabel(int index)
    {
        return getLabels().get(index);
    }


    public LABEL_TYPE getLabelValue(int index)
    {
        return getLabel(index).getValue();
    }


    @Override
    public int hashCode()
    {
        return ElementCharacteristicsInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return ElementCharacteristicsInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> clone() throws CloneNotSupportedException
    {
        return (ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE>)CloningService.clone(this);
    }


    public ElementCharacteristics<FEATURE_TYPE, LABEL_TYPE> getCopy()
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


    public DomainSet<FEATURE_TYPE> getDomainSet()
    {
        return this.domainSet;
    }


    public Labels<LABEL_TYPE> getLabels()
    {
        return this.labels;
    }
}