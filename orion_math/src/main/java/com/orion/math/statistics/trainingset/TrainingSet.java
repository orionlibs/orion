package com.orion.math.statistics.trainingset;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import java.util.List;

public abstract class TrainingSet extends Orion
{
    public TrainingSet()
    {
    }


    public abstract int getSize();


    public abstract ANumber getSizeAsNumber();


    public abstract int getNumberOfClasses();


    public abstract ANumber getNumberOfDataPointsWithClass(ANumber classToCheck);


    public abstract List<ANumber> getClasses();
}