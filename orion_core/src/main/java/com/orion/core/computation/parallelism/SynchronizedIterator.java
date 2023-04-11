package com.orion.core.computation.parallelism;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SynchronizedIterator<T>
{
    static class Element<T>
    {
        private final boolean exists;
        private final T element;


        private Element(boolean exists, T element)
        {
            this.exists = exists;
            this.element = element;
        }


        boolean exists()
        {
            return exists;
        }


        T get() throws NoSuchElementException
        {

            if(!exists)
            {
                throw new NoSuchElementException();
            }

            return element;
        }
    }


    private final Iterator<T> iterator;


    SynchronizedIterator(Iterator<T> iterator)
    {
        this.iterator = iterator;
    }


    synchronized Element<T> next()
    {

        if(iterator.hasNext())
        {
            return new Element<>(true, iterator.next());
        }

        return new Element<>(false, null);
    }
}