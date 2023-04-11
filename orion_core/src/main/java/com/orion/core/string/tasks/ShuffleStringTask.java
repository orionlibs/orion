package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.math.RandomNumberGenerationService;

public class ShuffleStringTask extends Orion
{
    public static String run(String stringToShuffle)
    {
        Assert.notEmpty(stringToShuffle, "The stringToShuffle input cannot be null/empty.");
        String[] stringArray = stringToShuffle.split("");

        for(int i = 0; i < stringToShuffle.length(); i++)
        {
            int r1 = i;
            int r2 = RandomNumberGenerationService.getRandomInteger(stringToShuffle.length());
            String temp = stringArray[r1];
            stringArray[r1] = stringArray[r2];
            stringArray[r2] = temp;
        }

        String shuffledString = "";

        for(int i = 0; i < stringArray.length; i++)
        {
            shuffledString += stringArray[i];
        }

        return shuffledString;
    }
}