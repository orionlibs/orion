package com.orion.math.geometry.shape.circle.chord;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;

public class CircleChordService extends OrionService
{
    public static ANumber getLength(CircleChord chord)
    {
        CircleChordRules.isValid(chord);
        return chord.getChordLineSegment().getLength();
    }


    public static ANumber getLength(CircleChord chord, int precision)
    {
        CircleChordRules.isValid(chord);
        return chord.getChordLineSegment().getLength(precision);
    }


    public static boolean isPointOnChord(CircleChord chord, Point point)
    {
        CircleChordRules.isValid(chord);
        return chord.getChordLineSegment().getLine().doesPointBelongToLine(point);
    }


    public static boolean isDiameter(CircleChord chord)
    {
        CircleChordRules.isValid(chord);
        return chord.getChordLineSegment().getLine().doesPointBelongToLine(chord.getCenter());
    }
}