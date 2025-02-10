package org.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

public class JavaLRUBasedCache<K,V>   implements CacheService<K,V>  {
    private final Map<K, CacheEntry<V>> cache;
    private long totalPutTime = 0;
    private long putCount = 0;

    private int hitCount = 0;
    private int missCount = 0;
    private int evictionCount = 0;

    private  int timebasedAccess; // Time-based access in seconds
    private static final Logger logger = Logger.getLogger(JavaLRUBasedCache.class.getName());


    JavaLRUBasedCache(CacheConfiguration cacheConfiguration){
        this.timebasedAccess = cacheConfiguration.timebasedAccess();
        this.cache = new LinkedHashMap<>(cacheConfiguration.maxSize(), 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, CacheEntry<V>> eldest)
            {
                boolean shouldEvict = size() > cacheConfiguration.maxSize() || isExpired(eldest.getValue());

                if (shouldEvict) {
                    evictionCount++;
                    logger.info("Evicted entry with key: " + eldest.getKey());
                }
                return shouldEvict;
            }
        };

    }

    private boolean isExpired(CacheEntry<V> value) {
        long currentTime = System.currentTimeMillis();
        long expirationTime = value.getLastAccessTime() + (timebasedAccess * 1000L); // Time in milliseconds
        return currentTime > expirationTime;
    }


    @Override
    public void put(K key, V value) {
        long startTime = System.nanoTime();
        CacheEntry<V> cacheEntry = new CacheEntry<>(value, System.currentTimeMillis());
        cache.put(key, cacheEntry);
        long endTime = System.nanoTime();
        totalPutTime += (endTime - startTime);
        putCount++;
    }

    @Override
    public V get(K key) {
        CacheEntry<V> cacheEntry = cache.get(key);

        if (cacheEntry != null) {
            // Check if the entry is expired based on time-based access
            if (isExpired(cacheEntry)) {
                evictionCount++;
                logger.info("Evicted expired entry with key: " + key);
                cache.remove(key);
                missCount++;
                return null;  // Cache miss because the item has expired
            }

            hitCount++;
            cacheEntry.updateAccessTime(); // Update the last access time
            System.out.println(" Available in cache " + key);
            return cacheEntry.getValue();
        } else {
            System.out.println(" It is not in the cache : "+ key);
            missCount++;
            return null;  // Cache miss
        }
    }


    @Override
    public CacheStatistics getStatistics() {
        double avgPutTime = (putCount > 0) ? (totalPutTime / (double) putCount) : 0;
        return new CacheStatistics(hitCount, missCount, evictionCount, avgPutTime);
    }


    static class CacheEntry<V>{
        private final V value;
        private long lastAccessTime;


        public CacheEntry(V value, long lastAccessTime) {
            this.value = value;
            this.lastAccessTime = lastAccessTime;
        }

        public V getValue() {
            return value;
        }

        public long getLastAccessTime() {
            return lastAccessTime;
        }

        public void updateAccessTime() {
            this.lastAccessTime = System.currentTimeMillis();
        }
    }
}
