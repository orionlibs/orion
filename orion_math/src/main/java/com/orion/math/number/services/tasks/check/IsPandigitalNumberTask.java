package com.orion.math.number.services.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class IsPandigitalNumberTask extends Orion
{
    public static boolean run(ANumber x)
    {
        Numbers.hasIntegerValue(x);
        String xString = x.printRealValue();

        if(xString.isEmpty() || xString.length() > 10)
        {
            return false;
        }
        else
        {

            if(xString.length() == 1 && xString.contains("1"))
            {
                return true;
            }
            else if(xString.length() == 2 && xString.contains("1") && xString.contains("2"))
            {
                return true;
            }
            else if(xString.length() == 3 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3"))
            {
                return true;
            }
            else if(xString.length() == 4 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4"))
            {
                return true;
            }
            else if(xString.length() == 5 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5"))
            {
                return true;
            }
            else if(xString.length() == 6 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5") && xString.contains("6"))
            {
                return true;
            }
            else if(xString.length() == 7 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5") && xString.contains("6")
                            && xString.contains("7"))
            {
                return true;
            }
            else if(xString.length() == 8 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5") && xString.contains("6")
                            && xString.contains("7") && xString.contains("8"))
            {
                return true;
            }
            else if(xString.length() == 9 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5") && xString.contains("6")
                            && xString.contains("7") && xString.contains("8")
                            && xString.contains("9"))
            {
                return true;
            }
            else if(xString.length() == 10 && xString.contains("1") && xString.contains("2")
                            && xString.contains("3") && xString.contains("4")
                            && xString.contains("5") && xString.contains("6")
                            && xString.contains("7") && xString.contains("8")
                            && xString.contains("9") && xString.contains("0"))
            {
                return true;
            }

        }

        return false;
    }
}