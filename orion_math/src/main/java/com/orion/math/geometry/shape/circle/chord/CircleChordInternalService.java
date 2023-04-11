package com.orion.math.geometry.shape.circle.chord;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.circle.chord.tasks.CircleChordEqualsTask;
import com.orion.math.geometry.shape.circle.chord.tasks.CircleChordHashCodeTask;

class CircleChordInternalService implements MathObject
{
    static boolean equals(CircleChord x, Object y)
    {
        return CircleChordEqualsTask.run(x, y);
    }


    static int hashCode(CircleChord x)
    {
        return CircleChordHashCodeTask.run(x);
    }
}