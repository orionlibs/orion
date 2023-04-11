package com.orion.math.series.partialsums.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.series.partialsums.SeriesWithPartialSumsRules;
import java.util.ArrayList;
import java.util.List;

public class GetSumOfNSumSeriesWithPartialSumsTask extends Orion
{
    private boolean removeLastValueFromValuesForFormula = false;


    public ANumber run(FunctionNx1IF<ANumber, ANumber> expression, List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices)
    {
        SeriesWithPartialSumsRules.isValid(pairsOfStartAndEndIndices);
        pairsOfStartAndEndIndices.forEach(pair -> NumberRules.isLessThanOrEqual(pair.getFirst(), pair.getSecond()));
        removeLastValueFromValuesForFormula = false;
        ANumber sum = ANumber.of(0);
        List<ANumber> valuesForFormula = new ArrayList<>(pairsOfStartAndEndIndices.size());

        if(pairsOfStartAndEndIndices.size() == 1)
        {
            doSumLastLoop(0, expression, pairsOfStartAndEndIndices, valuesForFormula, sum);
        }
        else
        {
            doSum(0, expression, pairsOfStartAndEndIndices, valuesForFormula, sum, false);
        }

        return sum;
    }


    private void doSum(int loopIndex, FunctionNx1IF<ANumber, ANumber> expression, List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices, List<ANumber> valuesForFormula, ANumber sum, boolean callLastLoop)
    {
        int start = pairsOfStartAndEndIndices.get(loopIndex).getFirst().getAsInt();
        int end = pairsOfStartAndEndIndices.get(loopIndex).getSecond().getAsInt();

        for(int i = start; i <= end; i++)
        {

            if(!valuesForFormula.isEmpty() && removeLastValueFromValuesForFormula)
            {

                if(loopIndex == 0)
                {
                    valuesForFormula.clear();
                }
                else
                {

                    if(valuesForFormula.size() - 1 < loopIndex)
                    {
                        valuesForFormula.remove(valuesForFormula.size() - 1);
                    }
                    else
                    {
                        valuesForFormula.remove(loopIndex);
                    }

                }

                removeLastValueFromValuesForFormula = false;
            }

            valuesForFormula.add(ANumber.of(i));
            boolean shouldCallLastLoop = loopIndex + 1 == pairsOfStartAndEndIndices.size() - 1;

            if(shouldCallLastLoop)
            {
                doSumLastLoop(loopIndex + 1, expression, pairsOfStartAndEndIndices, valuesForFormula, sum);
            }
            else
            {
                doSum(loopIndex + 1, expression, pairsOfStartAndEndIndices, valuesForFormula, sum, shouldCallLastLoop);
            }

        }

    }


    private void doSumLastLoop(int loopIndex, FunctionNx1IF<ANumber, ANumber> expression, List<Pair<ANumber, ANumber>> pairsOfStartAndEndIndices, List<ANumber> valuesForFormula, ANumber sum)
    {
        int start = pairsOfStartAndEndIndices.get(loopIndex).getFirst().getAsInt();
        int end = pairsOfStartAndEndIndices.get(loopIndex).getSecond().getAsInt();

        for(int i = start; i <= end; i++)
        {

            if(valuesForFormula.size() < pairsOfStartAndEndIndices.size())
            {
                valuesForFormula.add(ANumber.of(i));
            }
            else
            {
                valuesForFormula.set(valuesForFormula.size() - 1, ANumber.of(i));
            }

            sum.add(expression.run(valuesForFormula.toArray(new ANumber[0])));

            if(i == pairsOfStartAndEndIndices.get(loopIndex).getSecond().getAsInt())
            {
                valuesForFormula.remove(loopIndex);
                removeLastValueFromValuesForFormula = true;
            }

        }

    }
}