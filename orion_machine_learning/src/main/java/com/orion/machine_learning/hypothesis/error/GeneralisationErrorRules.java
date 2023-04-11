package com.orion.machine_learning.hypothesis.error;

import com.orion.core.abstraction.Orion;

public class GeneralisationErrorRules extends Orion
{
    public static void isValid(ExpectedError expectedError, EmpiricalError empiricalerror)
    {

        if(expectedError == null)
        {
            throw new NullErrorException("ExpectedError is null.");
        }

        if(empiricalerror == null)
        {
            throw new NullErrorException("EmpiricalError is null.");
        }

    }


    public static void isValid(EmpiricalError empiricalerror, ExpectedError expectedError)
    {

        if(expectedError == null)
        {
            throw new NullErrorException("ExpectedError is null.");
        }

        if(empiricalerror == null)
        {
            throw new NullErrorException("EmpiricalError is null.");
        }

    }
}