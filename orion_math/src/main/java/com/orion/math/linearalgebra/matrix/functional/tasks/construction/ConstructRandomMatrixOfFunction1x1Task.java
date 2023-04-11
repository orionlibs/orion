package com.orion.math.linearalgebra.matrix.functional.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1;
import com.orion.math.linearalgebra.matrix.functional.MatrixOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;

public class ConstructRandomMatrixOfFunction1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static MatrixOfFunction1x1 run(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        MatrixOfFunction1x1Rules.isValid(numberOfRows, numberOfColumns);
        Function1x1<ANumber, ANumber>[][] newElements = new Function1x1[numberOfRows][numberOfColumns];

        for(int i = 0; i < numberOfRows; i++)
        {

            for(int j = 0; j < numberOfColumns; j++)
            {
                ANumber randomNumber = NumberService.getRandomNumber(minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
                newElements[i][j] = Function1x1.<ANumber, ANumber>of(x -> randomNumber);
            }

        }

        return new MatrixOfFunction1x1(newElements);
    }
}