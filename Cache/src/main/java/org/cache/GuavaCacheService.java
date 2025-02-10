package org.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GuavaCacheService<K,V> implements CacheService<K,V>{
    private static final Logger logger = Logger.getLogger(GuavaCacheService.class.getName());

    private long totalPutTime = 0;
    private long putCount = 0;

    private int hitCount = 0;
    private int missCount = 0;

    Cache<K, V> cache;

    public GuavaCacheService(CacheConfiguration cacheConfiguration) {
        this.cache = CacheBuilder.newBuilder().
                maximumSize(cacheConfiguration.maxSize()).
                expireAfterAccess(cacheConfiguration.timebasedAccess(), TimeUnit.SECONDS)
                .removalListener(notification -> {
                    if (notification.wasEvicted()) {
                        logger.info("Removed entry: " + notification.getKey() + " due to " + notification.getCause());
                    }
                })
                .recordStats()
                .build();
    }


    @Override
    public void put(K key, V value) {
        long startTime = System.nanoTime();
        cache.put(key, value);
        long duration = System.nanoTime() - startTime;
        recordPutTime(duration);
    }

    @Override
    public V get(K key) {
        V value = cache.getIfPresent(key);
        if (value != null) {
            hitCount++;
        } else {
            missCount++;
        }
        return value;
    }

    // Method to get cache statistics
    public CacheStatistics getStatistics() {
        CacheStats stats = cache.stats();
        int  evictionCount   = (int) stats.evictionCount();
        System.out.println("Eviction count: " + stats.evictionCount());
        double avgPutTime = (putCount > 0) ? (totalPutTime / (double) putCount) : 0;
        return new CacheStatistics(hitCount, missCount, evictionCount, avgPutTime);
    }

    public  void recordPutTime(long duration) {
        totalPutTime+= duration;
        putCount++;
    }

}
