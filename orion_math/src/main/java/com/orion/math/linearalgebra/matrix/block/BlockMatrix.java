package com.orion.math.linearalgebra.matrix.block;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import java.util.stream.IntStream;

public class BlockMatrix implements MathObject, Cloneable
{
    private OrionList<Matrix> elements;


    public BlockMatrix()
    {
        this(OrionArrayList.<Matrix>of());
    }


    public BlockMatrix(Matrix[] elements)
    {
        MatrixRules.areValid(elements);
        OrionList<Matrix> newElements = OrionArrayList.of(elements.length);
        IntStream.range(0, elements.length).forEach(i -> newElements.add(elements[i]));
        this.elements = newElements;
    }


    public BlockMatrix(OrionList<Matrix> elements)
    {
        MatrixRules.areValid(elements);
        this.elements = elements;
    }


    public static BlockMatrix of()
    {
        return new BlockMatrix();
    }


    public static BlockMatrix of(OrionList<Matrix> elements)
    {
        return new BlockMatrix(elements);
    }


    public static BlockMatrix of(Matrix[] elements)
    {
        return new BlockMatrix(elements);
    }


    public boolean isEmpty()
    {
        return getElements().isEmpty();
    }


    @Override
    public BlockMatrix clone() throws CloneNotSupportedException
    {
        return (BlockMatrix)CloningService.clone(this);
    }


    public BlockMatrix getCopy()
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
        return BlockMatrixInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return BlockMatrixInternalService.equals(this, object);
    }


    public OrionList<Matrix> getElements()
    {
        return this.elements;
    }


    public void setElements(OrionList<Matrix> elements)
    {
        this.elements = elements;
    }
}