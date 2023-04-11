package com.orion.math.geometry.vector.rowvector;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class RowVector implements MathObject, Cloneable
{
    private Matrix elements;


    public RowVector()
    {
        this(Matrix.of());
    }


    public RowVector(Matrix elements)
    {
        RowVectorRules.isValid(elements);
        this.elements = elements;
    }


    public static RowVector of()
    {
        return new RowVector();
    }


    public static RowVector of(Matrix elements)
    {
        return new RowVector(elements);
    }


    public int getNumberOfRows()
    {
        return getElements().getNumberOfRows();
    }


    public int getNumberOfColumns()
    {
        return getElements().getNumberOfColumns();
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    public ANumber get(int rowIndex, int columnIndex)
    {
        return getElements().get(rowIndex, columnIndex);
    }


    public ANumber[][] convertToArrayOfArrays()
    {
        return getElements().getAsArrayOfArrays();
    }


    @Override
    public RowVector clone() throws CloneNotSupportedException
    {
        return (RowVector)CloningService.clone(this);
    }


    public RowVector getCopy()
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


    @Override
    public int hashCode()
    {
        return RowVectorInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return RowVectorInternalService.equals(this, object);
    }


    public Matrix getElements()
    {
        return this.elements;
    }


    public void setElements(Matrix elements)
    {
        this.elements = elements;
    }
}