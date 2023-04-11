package com.orion.core.tuple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.stream.OrionArrays;
import com.orion.core.tuple.Single;
import java.util.Arrays;

public class EqualsForSingleTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static <T> boolean run(Object object1, Object object2)
    {

        if(object2 == null || object1.getClass() != object2.getClass())
        {
            return false;
        }
        else
        {
            Single<T> thisObject = (Single<T>)object1;
            Single<T> other = (Single<T>)object2;

            if(thisObject.getFirst().getClass().isArray() && other.getFirst().getClass().isArray())
            {
                Object[] firstAsObjects = OrionArrays.getAsArrayOfObjects((T[])thisObject.getFirst());
                Object[] otherFirstAsObjects = OrionArrays.getAsArrayOfObjects((T[])other.getFirst());
                return Arrays.equals(firstAsObjects, otherFirstAsObjects);
            }
            else
            {
                return thisObject.getFirst().equals(other.getFirst());
            }

        }

    }
}