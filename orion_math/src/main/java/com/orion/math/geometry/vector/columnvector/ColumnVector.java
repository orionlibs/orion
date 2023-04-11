package com.orion.math.geometry.vector.columnvector;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class ColumnVector implements MathObject, Cloneable
{
    private Matrix elements;


    public ColumnVector()
    {
        this(Matrix.of());
    }


    public ColumnVector(Matrix elements)
    {
        ColumnVectorRules.isValid(elements);
        this.elements = elements;
    }


    public static ColumnVector of()
    {
        return new ColumnVector();
    }


    public static ColumnVector of(Matrix elements)
    {
        return new ColumnVector(elements);
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


    public Vector getAsVector()
    {
        return getElements().getColumn(0);
    }


    public ANumber[] getAsArray()
    {
        return getElements().getColumn(0).getAsArray();
    }


    @Override
    public ColumnVector clone() throws CloneNotSupportedException
    {
        return (ColumnVector)CloningService.clone(this);
    }


    public ColumnVector getCopy()
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
        return ColumnVectorInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return ColumnVectorInternalService.equals(this, object);
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