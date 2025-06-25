package com.algorithm.boot.other.meituan.cache;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class LocalCache {
    private final Map<String, Map<Object, Object>> cacheStore = new HashMap<>();

    public <K, V> Map<K, V> getLocalCache(
            String cacheKey,
            List<K> ids,
            Function<List<K>, Map<K, V>> dbLoader
    ) {
        Map<Object, Object> cache = cacheStore.computeIfAbsent(cacheKey, k -> new HashMap<>());

        Map<K, V> result = new HashMap<>();
        List<K> missed = new ArrayList<>();

        for (K id : ids) {
            if (cache.containsKey(id)) {
                result.put(id, (V) cache.get(id));
            } else {
                missed.add(id);
            }
        }

        if (!missed.isEmpty()) {
            Map<K, V> dbData = dbLoader.apply(missed);
            result.putAll(dbData);

            dbData.forEach((k, v) -> cache.put(k, v));
        }

        return result;
    }
}
