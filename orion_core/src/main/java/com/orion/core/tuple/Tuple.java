package com.orion.core.tuple;

import com.orion.core.abstraction.OrionInterface;
import java.util.List;

public interface Tuple extends OrionInterface
{
    Object get(int index);


    Object[] getAsArray();


    List<Object> getAsList();


    boolean isEmpty();
}