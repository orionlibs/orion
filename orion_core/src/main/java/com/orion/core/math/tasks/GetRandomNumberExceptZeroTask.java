package com.orion.core.math.tasks;

import com.orion.core.abstraction.Orion;

public class GetRandomNumberExceptZeroTask extends Orion
{
    public static double run(double maximumNumber)
    {
        double randomNumber = 0;

        do
        {
            randomNumber = (Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber == 0);

        return randomNumber;
    }


    public static double run(double minimumNumber, double maximumNumber)
    {
        double randomNumber = 0;

        do
        {
            randomNumber = (Math.floor(Math.random() * maximumNumber));
        }
        while(randomNumber < minimumNumber);

        return randomNumber;
    }
}