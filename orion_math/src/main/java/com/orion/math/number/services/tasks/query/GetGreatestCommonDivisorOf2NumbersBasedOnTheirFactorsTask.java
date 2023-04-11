package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetGreatestCommonDivisorOf2NumbersBasedOnTheirFactorsTask extends Orion
{
    public static ANumber run(List<ANumber> factorsOfX, List<ANumber> factorsOfY)
    {
        NumberRules.areNotNull(factorsOfX);
        NumberRules.areNotNull(factorsOfY);
        factorsOfX.retainAll(factorsOfY);
        Set<ANumber> commonFactors = new HashSet<ANumber>(factorsOfX);
        List<ANumber> commonFactors1 = new ArrayList<ANumber>(commonFactors);
        Collections.sort(commonFactors1);
        return commonFactors1.get(commonFactors1.size() - 1);
    }
}