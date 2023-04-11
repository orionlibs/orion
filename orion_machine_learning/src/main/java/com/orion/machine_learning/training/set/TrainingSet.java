package com.orion.machine_learning.training.set;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.machine_learning.element.label.Label;
import com.orion.machine_learning.training.element.Element;
import com.orion.machine_learning.training.element.training_data_point.TrainingDataPoint;
import com.orion.math.number.Numbers;
import java.util.List;
import java.util.function.Consumer;

public class TrainingSet<FEATURE_TYPE, LABEL_TYPE> extends Orion implements Cloneable
{
    private OrionList<Element<FEATURE_TYPE, LABEL_TYPE>> elements;


    public TrainingSet(OrionList<Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {
        TrainingSetRules.isValid(elements);
        this.elements = elements;
    }


    public TrainingSet(List<Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {
        TrainingSetRules.isValid(elements);
        this.elements = OrionArrayList.of(elements);
    }


    @SuppressWarnings("unchecked")
    public TrainingSet(Element<FEATURE_TYPE, LABEL_TYPE>... elements)
    {
        TrainingSetRules.isValid(elements);
        this.elements = OrionArrayList.of(elements);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> TrainingSet<FEATURE_TYPE, LABEL_TYPE> of(OrionList<Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {
        return new TrainingSet<FEATURE_TYPE, LABEL_TYPE>(elements);
    }


    public static <FEATURE_TYPE, LABEL_TYPE> TrainingSet<FEATURE_TYPE, LABEL_TYPE> of(List<Element<FEATURE_TYPE, LABEL_TYPE>> elements)
    {
        return new TrainingSet<FEATURE_TYPE, LABEL_TYPE>(elements);
    }


    @SuppressWarnings("unchecked")
    public static <FEATURE_TYPE, LABEL_TYPE> TrainingSet<FEATURE_TYPE, LABEL_TYPE> of(Element<FEATURE_TYPE, LABEL_TYPE>... elements)
    {
        return new TrainingSet<FEATURE_TYPE, LABEL_TYPE>(elements);
    }


    public Element<FEATURE_TYPE, LABEL_TYPE> get(int index)
    {
        return getElements().get(index);
    }


    public TrainingDataPoint<FEATURE_TYPE> getFeature(int elementIndex, int featureIndex)
    {
        return get(elementIndex).getFeature(featureIndex);
    }


    public FEATURE_TYPE getFeatureValue(int elementIndex, int featureIndex)
    {
        return get(elementIndex).getFeatureValue(featureIndex);
    }


    public Label<LABEL_TYPE> getLabel(int elementIndex, int labelIndex)
    {
        return get(elementIndex).getLabel(labelIndex);
    }


    public LABEL_TYPE getLabelValue(int elementIndex, int labelIndex)
    {
        return get(elementIndex).getLabelValue(labelIndex);
    }


    public int getNumberOfElements()
    {
        return getElements().getSize();
    }


    public TrainingSet<FEATURE_TYPE, LABEL_TYPE> getFirstHalf()
    {

        if(Numbers.isEven(getNumberOfElements()))
        {
            return TrainingSet.of(getElements().subList(0, getNumberOfElements() / 2));
        }
        else
        {
            return TrainingSet.of(getElements().subList(0, (getNumberOfElements() / 2) + 1));
        }

    }


    public TrainingSet<FEATURE_TYPE, LABEL_TYPE> getSecondHalf()
    {

        if(Numbers.isEven(getNumberOfElements()))
        {
            return TrainingSet.of(getElements().subList(getNumberOfElements() / 2, getNumberOfElements()));
        }
        else
        {
            return TrainingSet.of(getElements().subList((getNumberOfElements() / 2) + 1, getNumberOfElements()));
        }

    }


    public void forAll(Consumer<Element<FEATURE_TYPE, LABEL_TYPE>> action)
    {
        getElements().forAll(action);
    }


    @Override
    public int hashCode()
    {
        return TrainingSetInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return TrainingSetInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public TrainingSet<FEATURE_TYPE, LABEL_TYPE> clone() throws CloneNotSupportedException
    {
        return (TrainingSet<FEATURE_TYPE, LABEL_TYPE>)CloningService.clone(this);
    }


    public TrainingSet<FEATURE_TYPE, LABEL_TYPE> getCopy()
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


    public OrionList<Element<FEATURE_TYPE, LABEL_TYPE>> getElements()
    {
        return this.elements;
    }
}