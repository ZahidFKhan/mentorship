package org.cache;

public interface CacheService<K,V>{
     void put(K key, V value);

     V get(K key);

    CacheStatistics getStatistics();
}

record CacheConfiguration(int maxSize , int timebasedAccess, EvictionPolicy policy){}

record CacheStatistics(int hitCount, int missCount, int evictionCount, double avgPutTime) {}

enum EvictionPolicy {
    LRU, FIFO, LFU, NONE;
}
