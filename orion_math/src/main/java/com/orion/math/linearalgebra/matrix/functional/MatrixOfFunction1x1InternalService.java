package com.orion.math.linearalgebra.matrix.functional;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.linearalgebra.matrix.functional.tasks.construction.ConstructIdentityMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.construction.ConstructMatrixOfFunction1x1UsingDiagonalElementsTask;
import com.orion.math.linearalgebra.matrix.functional.tasks.construction.ConstructRandomMatrixOfFunction1x1Task;
import com.orion.math.linearalgebra.matrix.functional.tasks.construction.ConstructZeroMatrixOfFunction1x1Task;

class MatrixOfFunction1x1InternalService implements MathObject
{
    static MatrixOfFunction1x1 ofRandom(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        return ConstructRandomMatrixOfFunction1x1Task.run(numberOfRows, numberOfColumns, minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
    }


    static MatrixOfFunction1x1 ofDiagonal(VectorOfFunction1x1 diagonalElements)
    {
        return ConstructMatrixOfFunction1x1UsingDiagonalElementsTask.run(diagonalElements);
    }


    static MatrixOfFunction1x1 ofIdentity(int numberOfRowsAndColumns)
    {
        return ConstructIdentityMatrixOfFunction1x1Task.run(numberOfRowsAndColumns);
    }


    static MatrixOfFunction1x1 ofZero(int numberOfRows, int numberOfColumns)
    {
        return ConstructZeroMatrixOfFunction1x1Task.run(numberOfRows, numberOfColumns);
    }


    static MatrixOfFunction1x1 ofSkewDiagonal(VectorOfFunction1x1 skewDiagonalElements)
    {
        VectorOfFunction1x1Rules.isValid(skewDiagonalElements);
        return MatrixOfFunction1x1.of(ofDiagonal(skewDiagonalElements).rotate90DegreesClockwise().getElements());
    }
}