package com.orion.math.linearalgebra.matrix;

import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.tasks.MatrixEqualsTask;
import com.orion.math.linearalgebra.matrix.tasks.MatrixHashCodeTask;
import com.orion.math.linearalgebra.matrix.tasks.construction.ConstructIdentityMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.construction.ConstructMatrixUsingDiagonalElementsTask;
import com.orion.math.linearalgebra.matrix.tasks.construction.ConstructRandomMatrixTask;
import com.orion.math.linearalgebra.matrix.tasks.construction.ConstructZeroMatrixTask;

class MatrixInternalService implements MathObject
{
    static boolean equals(Matrix x, Object y)
    {
        return MatrixEqualsTask.run(x, y);
    }


    static int hashCode(Matrix x)
    {
        return MatrixHashCodeTask.run(x);
    }


    static Matrix ofRandom(int numberOfRows, int numberOfColumns, int minimumValueOfRandomNumbers, int maximumValueOfRandomNumbers)
    {
        return ConstructRandomMatrixTask.run(numberOfRows, numberOfColumns, minimumValueOfRandomNumbers, maximumValueOfRandomNumbers);
    }


    static Matrix ofDiagonal(Vector diagonalElements)
    {
        return ConstructMatrixUsingDiagonalElementsTask.run(diagonalElements);
    }


    static Matrix ofIdentity(int numberOfRowsAndColumns)
    {
        return ConstructIdentityMatrixTask.run(numberOfRowsAndColumns);
    }


    static Matrix ofZero(int numberOfRows, int numberOfColumns)
    {
        return ConstructZeroMatrixTask.run(numberOfRows, numberOfColumns);
    }


    static Matrix ofSkewDiagonal(Vector skewDiagonalElements)
    {
        VectorRules.isValid(skewDiagonalElements);
        return Matrix.of(ofDiagonal(skewDiagonalElements).rotate90DegreesClockwise().getElements());
    }
}