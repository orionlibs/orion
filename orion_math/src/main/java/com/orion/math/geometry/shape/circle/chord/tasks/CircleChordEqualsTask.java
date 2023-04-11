package com.orion.math.geometry.shape.circle.chord.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.chord.CircleChord;
import com.orion.math.geometry.shape.circle.chord.CircleChordRules;

public class CircleChordEqualsTask extends Orion
{
    public static boolean run(CircleChord x, Object y)
    {
        CircleChordRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            CircleChord other = (CircleChord)y;
            return x.getCircle().equals(other.getCircle())
                            && x.getStartPoint().equals(other.getStartPoint())
                            && x.getEndPoint().equals(other.getEndPoint());
        }

    }
}