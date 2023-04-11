package com.orion.math.geometry.vector.tasks.product;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetCrossProductOf2VectorsTask extends Orion
{
    public static Vector run(Vector x, Vector y, ANumber angleBetweenVectorsInDegrees)
    {
        VectorRules.doVectorSizesMatch(x, y, 3);
        NumberRules.isANumber(angleBetweenVectorsInDegrees);
        ANumber[] elements = new ANumber[3];
        elements[0] = x.get(1).multiplyGET(y.get(2)).subtractGET(x.get(2).multiplyGET(y.get(1)));
        elements[1] = x.get(2).multiplyGET(y.get(0)).subtractGET(x.get(0).multiplyGET(y.get(2)));
        elements[2] = x.get(0).multiplyGET(y.get(1)).subtractGET(x.get(1).multiplyGET(y.get(0)));
        return Vector.of(elements);
    }
}