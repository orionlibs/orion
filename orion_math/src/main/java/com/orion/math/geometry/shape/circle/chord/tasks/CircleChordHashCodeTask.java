package com.orion.math.geometry.shape.circle.chord.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.chord.CircleChord;
import com.orion.math.geometry.shape.circle.chord.CircleChordRules;

public class CircleChordHashCodeTask extends Orion
{
    public static int run(CircleChord x)
    {
        CircleChordRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getCircle().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getStartPoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getEndPoint().hashCode();
    }
}