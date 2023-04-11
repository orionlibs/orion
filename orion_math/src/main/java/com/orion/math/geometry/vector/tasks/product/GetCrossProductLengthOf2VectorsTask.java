package com.orion.math.geometry.vector.tasks.product;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetCrossProductLengthOf2VectorsTask extends Orion
{
    public static ANumber run(Vector x, Vector y, ANumber angleBetweenVectorsInDegrees)
    {
        VectorRules.areValid(x, y);
        VectorRules.doVectorSizesMatch(x, y);
        NumberRules.isANumber(angleBetweenVectorsInDegrees);
        ANumber newVectorLength = x.getMagnitude().multiplyGET(y.getMagnitude());
        return newVectorLength.multiplyGET(TrigonometryService.getSineInDegrees(angleBetweenVectorsInDegrees));
    }
}