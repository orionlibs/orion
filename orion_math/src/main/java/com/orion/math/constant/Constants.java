package com.orion.math.constant;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public class Constants extends Orion
{
    public static Constant PI = new PiConstant();
    public static ANumber PISquared = new PiConstant().getValue().squareGET();
    public static ANumber halfPI = new PiConstant().getValue().halfGET();
    public static ANumber PIValue = new PiConstant().getValue();
    public static ANumber twoPI = new PiConstant().getValue().doubleGET();
    public static Constant E = new EConstant();
    public static Constant EulerMascheroni = new EulerMascheroniConstant();
    public static Constant PHI = new PhiConstant();
}