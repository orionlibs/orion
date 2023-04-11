package com.orion.math.geometry.shape.cylinder;

import com.orion.core.abstraction.OrionService;
import com.orion.math.constant.Constants;
import com.orion.math.number.ANumber;

public class CylinderService extends OrionService
{
    public static ANumber getSurfaceArea(Cylinder x)
    {
        CylinderRules.isValid(x);
        return x.getRadius().multiplyGET(Constants.twoPI).multiplyGET(x.getRadius().addGET(x.getHeight()));
    }


    public static ANumber getVolume(Cylinder x)
    {
        CylinderRules.isValid(x);
        return x.getRadius().squareGET().multiplyGET(Constants.PISquared.get()).multiplyGET(x.getHeight());
    }
}