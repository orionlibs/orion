package com.orion.math.geometry.vector.generic;

import com.orion.core.abstraction.OrionService;
import com.orion.math.linearalgebra.matrix.generic.GenericMatrix;
import com.orion.math.streams.NumberArrayStream;

public class GenericVectorService extends OrionService
{
    public static GenericMatrix convertToMatrix(GenericVector x)
    {
        GenericVectorRules.isValid(x);
        Object[][] yTemp = new Object[x.getSize()][1];
        NumberArrayStream.setValues(yTemp, x, 0);
        return GenericMatrix.of(yTemp);
    }


    public static GenericVector reverseOrderOfElements(GenericVector x)
    {
        GenericVectorRules.isValid(x);
        return GenericVector.of(x.getAsOrionList().reverseGET());
    }
}