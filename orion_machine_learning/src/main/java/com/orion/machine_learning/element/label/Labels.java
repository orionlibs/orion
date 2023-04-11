package com.orion.machine_learning.element.label;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import java.util.List;

public class Labels<T> extends Orion implements Cloneable
{
    private OrionList<? extends Label<T>> labels;


    public Labels(OrionList<? extends Label<T>> labels)
    {
        LabelsRules.isValid(labels);
        this.labels = labels;
    }


    public Labels(List<? extends Label<T>> labels)
    {
        LabelsRules.isValid(labels);
        this.labels = OrionArrayList.of(labels);
    }


    @SuppressWarnings("unchecked")
    public Labels(Label<T>... labels)
    {
        LabelsRules.isValid(labels);
        this.labels = OrionArrayList.of(labels);
    }


    public static <T> Labels<T> of(OrionList<? extends Label<T>> labels)
    {
        return new Labels<T>(labels);
    }


    public static <T> Labels<T> of(List<? extends Label<T>> labels)
    {
        return new Labels<T>(labels);
    }


    @SuppressWarnings("unchecked")
    public static <T> Labels<T> of(Label<T>... labels)
    {
        return new Labels<T>(labels);
    }


    public Label<T> get(int index)
    {
        return getLabels().get(index);
    }


    public T getValue(int index)
    {
        return get(index).getValue();
    }


    public int getSize()
    {
        return getLabels().getSize();
    }


    @Override
    public int hashCode()
    {
        return LabelsInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return LabelsInternalService.equals(this, object);
    }


    @SuppressWarnings("unchecked")
    @Override
    public Labels<T> clone() throws CloneNotSupportedException
    {
        return (Labels<T>)CloningService.clone(this);
    }


    public Labels<T> getCopy()
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


    public OrionList<? extends Label<T>> getLabels()
    {
        return this.labels;
    }
}