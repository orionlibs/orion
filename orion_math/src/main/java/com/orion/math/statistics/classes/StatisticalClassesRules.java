package com.orion.math.statistics.classes;

import com.orion.core.data.structure.list.OrionList;
import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.classes.aclass.StatisticalClass;
import com.orion.math.statistics.classes.aclass.StatisticalClassRules;
import java.util.Map;

public class StatisticalClassesRules extends MathRule
{
    public static void isValid(OrionList<StatisticalClass> statisticalClasses)
    {
        Assert.notEmpty(statisticalClasses, "The statisticalClasses input cannot be null/empty.");
        statisticalClasses.forAll(sc -> StatisticalClassRules.isValid(sc));
    }


    public static void isValid(OrionList<StatisticalClass> statisticalClasses, Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        isValid(statisticalClasses);
        Assert.notEmpty(valuesAndClassMembershipMapper, "The valuesAndClassMembershipMapper input cannot be null/empty.");
    }


    public static void isValid(Vector values, Map<ANumber, StatisticalClass> valuesAndClassMembershipMapper)
    {
        VectorRules.isValid(values);
        Assert.notNull(valuesAndClassMembershipMapper, "The valuesAndClassMembershipMapper input cannot be null.");
        Assert.areEqual(values.filter(value -> valuesAndClassMembershipMapper.containsKey(value)).count(), values.getDimensions(), "valuesAndClassMembershipMapper does not have all values as keys.");
    }


    public static void isValid(StatisticalClasses statisticalClasses)
    {
        Assert.notNull(statisticalClasses, "The statisticalClasses input cannot be null.");
        isValid(statisticalClasses.getStatisticalClasses(), statisticalClasses.getValuesAndClassMembershipMapper());
    }
}