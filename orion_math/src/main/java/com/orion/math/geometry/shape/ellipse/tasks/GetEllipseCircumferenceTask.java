package com.orion.math.geometry.shape.ellipse.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.shape.ellipse.Ellipse;
import com.orion.math.geometry.shape.ellipse.EllipseRules;
import com.orion.math.number.ANumber;

public class GetEllipseCircumferenceTask extends Orion
{
    public static ANumber run(Ellipse x, int precision)
    {
        EllipseRules.isValid(x);
        ANumber circumference = Constants.PI.getValueCopy();
        ANumber temp = x.getRadiusOfMinorAxis().addGET(x.getRadiusOfMajorAxis()).multiplyGET(3);
        ANumber temp1 = x.getRadiusOfMinorAxis().multiplyGET(x.getRadiusOfMajorAxis()).multiplyGET(10);
        temp1.add(x.getRadiusOfMinorAxis().squareGET().addGET(x.getRadiusOfMajorAxis().squareGET()));
        temp1.multiply(3);
        temp.subtract(temp1.getSquareRoot(precision));
        return circumference.multiplyGET(temp);
    }
}