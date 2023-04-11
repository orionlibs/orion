package com.orion.math.linearalgebra.matrix.tasks.construction;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.services.NumberService;

public class ConstructRandomMatrixTask extends Orion
{
    public static Matrix run(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        MatrixRules.isValid(numberOfRows, numberOfColumns);
        ANumber[][] newElements = new ANumber[numberOfRows][numberOfColumns];

        for(int i = 0; i < numberOfRows; i++)
        {

            for(int j = 0; j < numberOfColumns; j++)
            {
                newElements[i][j] = NumberService.getRandomNumber(minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
            }

        }

        return new Matrix(newElements);
    }
}