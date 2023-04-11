package com.orion.core.cache;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CacheTest
{
    @Test
    public void test_cache()
    {
        Cache<String, Integer> cache = Cache.of();
        cache.addEntry("key1", 1);
        cache.addEntry("key2", 2);
        cache.addEntry("key3", 3);
        ConcurrentMap<String, Integer> cacheMap = new ConcurrentHashMap<String, Integer>();
        cacheMap.put("key1", 1);
        cacheMap.put("key2", 2);
        cacheMap.put("key3", 3);
        assertThat(cache.getCache()).isEqualTo(cacheMap);
        cache.deleteEntry("key2");
        cacheMap.remove("key2");
        assertThat(cache.getCache()).isEqualTo(cacheMap);
        cache.empty();
        cacheMap.clear();
        assertThat(cache.getCache()).isEqualTo(cacheMap);
    }
}