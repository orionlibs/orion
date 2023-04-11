package com.orion.math.linearalgebra.matrix.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class IsMonotonicMatrixTask extends Orion
{
    public static boolean run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);

        for(int i = 0; i < x.getNumberOfRows(); i++)
        {

            for(int j = 0; j < x.getNumberOfColumns(); j++)
            {
                ANumber subrowMinimum = ArithmeticService.getMinimum(x.getSubrow(i, j + 1, x.getNumberOfColumns() - 1).getAsList());
                ANumber subcolumnMaximum = ArithmeticService.getMaximum(x.getSubcolumn(i + 1, x.getNumberOfRows() - 1, j).getAsList());

                if(x.get(i, j).isNotZero() && (x.get(i, j).isLessThan(1))
                                || (x.get(i, j).isGreaterThan(x.getNumberOfRows())))
                {
                    return false;
                }
                else if(x.get(i, j).isNotZero() && x.get(i, j).isGreaterThanOrEqual(1)
                                && x.get(i, j).isLessThanOrEqual(x.getNumberOfRows()))
                {

                    if(x.get(i, j).isLessThanOrEqual(subcolumnMaximum)
                                    || x.get(i, j).isGreaterThanOrEqual(subrowMinimum))
                    {
                        return false;
                    }

                    if(x.containsExceptInPosition(x.get(i, j), i, j))
                    {
                        Pair<Integer, Integer>[] positions = x.getPositionsOfElement(x.get(i, j));

                        for(int k = 0; i < positions.length; k++)
                        {

                            if((int)positions[k].getFirst() >= i || (int)positions[k].getSecond() <= j)
                            {
                                return false;
                            }

                        }

                    }

                }

            }

        }

        return true;
    }
}