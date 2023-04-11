package com.orion.math.interpolation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.streams.NumberArrayStream;

public class DoLagrangeInterpolationOfFunctionValuesTask extends Orion
{
    public static Polynomial run(Vector xValues, Vector yValues)
    {
        VectorRules.doVectorSizesMatch(xValues, yValues);
        VectorRules.isDimensionsAtLeast(xValues.getDimensions(), 2);
        int n = xValues.getDimensions() - 1;
        ANumber[] coefficients = new ANumber[n];
        NumberArrayStream.setZeroValue(coefficients);
        ANumber[] c = new ANumber[n + 1];
        c[0] = ANumber.of(1);

        for(int i = 0; i < n; i++)
        {

            for(int j = i; j > 0; j--)
            {
                c[j] = c[j - 1].subtractGET(c[j].multiplyGET(xValues.get(i)));
            }

            c[0].multiply(xValues.get(i).negateGET());
            c[i + 1] = ANumber.of(1);
        }

        ANumber[] tc = new ANumber[n];

        for(int i = 0; i < n; i++)
        {
            ANumber d = ANumber.of(1);

            for(int j = 0; j < n; j++)
            {

                if(i != j)
                {
                    d.multiply(xValues.get(i).subtractGET(xValues.get(j)));
                }

            }

            ANumber t = yValues.get(i).divideGET(d);
            tc[n - 1] = c[n];
            coefficients[n - 1].add(t.multiplyGET(tc[n - 1]));

            for(int j = n - 2; j >= 0; j--)
            {
                tc[j] = c[j + 1].addGET(tc[j + 1].multiplyGET(xValues.get(i)));
                coefficients[j].add(t.multiplyGET(tc[j]));
            }

        }

        return Polynomial.of(coefficients);
    }
}