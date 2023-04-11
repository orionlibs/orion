package com.orion.machine_learning.hypothesis.error;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public abstract class GeneralisationError extends Orion
{
    public static ANumber getError(ExpectedError expectedError, EmpiricalError empiricalerror)
    {
        GeneralisationErrorRules.isValid(expectedError, empiricalerror);
        return expectedError.getError().subtractGET(empiricalerror.getError());
    }


    public static ANumber getError(EmpiricalError empiricalerror, ExpectedError expectedError)
    {
        GeneralisationErrorRules.isValid(empiricalerror, expectedError);
        return expectedError.getError().subtractGET(empiricalerror.getError());
    }
}