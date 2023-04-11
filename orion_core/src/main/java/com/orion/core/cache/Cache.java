package com.orion.core.cache;

import com.orion.core.abstraction.Orion;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Cache<K, V> extends Orion
{
    private ConcurrentMap<K, V> cache;


    public Cache()
    {
        this.cache = new ConcurrentHashMap<>();
    }


    public static <K, V> Cache<K, V> of()
    {
        return new Cache<>();
    }


    public V addEntry(K key, V value)
    {
        return cache.put(key, value);
    }


    public V deleteEntry(K key)
    {
        return cache.remove(key);
    }


    public void empty()
    {
        cache.clear();
    }


    public ConcurrentMap<K, V> getCache()
    {
        return this.cache;
    }


    public int getSize()
    {
        return this.cache.size();
    }
}