package org.cache;

import org.checkerframework.checker.units.qual.C;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CacheConfiguration cacheConfiguration = new CacheConfiguration(3, 5, EvictionPolicy.LRU);

        GuavaCacheService guavaCacheService = new GuavaCacheService(cacheConfiguration);

        JavaLRUBasedCache lruCache = new JavaLRUBasedCache(cacheConfiguration);

        System.out.println("****************************** Simple Java Cache LRU ***************************** ");
        // Testing LRUCache
        lruCache.put("A", "1");
        lruCache.put("B", "2");
        lruCache.put("C", "3");

        lruCache.put("D", "4"); //exceed size

        //Remove the first entry
        System.out.println(lruCache.get("A"));
        // Wait for 3 seconds
        Thread.sleep(3000);

        System.out.println(lruCache.get("B"));

        Thread.sleep(6000); //time limit exceeds

        System.out.println(lruCache.get("B"));
        System.out.println(lruCache.get("C"));



        CacheStatistics cacheStatistics = lruCache.getStatistics();
        System.out.println( " LRU cache details : - " +  " Eviction Count - " + cacheStatistics.evictionCount()
        + " ,Average put time - " + cacheStatistics.avgPutTime() + " , hit count -" +  cacheStatistics.hitCount() +
                " and miss count -" + cacheStatistics.missCount());



        System.out.println("****************************** Guava Cache LRU ***************************** ");
        // Testing LRUCache
        guavaCacheService.put("1", "Nidhi");
        guavaCacheService.put("2", "Zahid");
        guavaCacheService.put("3 Ravish", "3");

        guavaCacheService.put("4", "Radha"); //exceed size

        //Remove the first entry
        System.out.println(guavaCacheService.get("1"));
        // Wait for 3 seconds
        Thread.sleep(3000);

        System.out.println(guavaCacheService.get("2"));

        Thread.sleep(6000); //time limit exceeds

        System.out.println(guavaCacheService.get("2"));  // Should return "2" (still valid)


        CacheStatistics guavaCacheStatistics = guavaCacheService.getStatistics();
        System.out.println( " Guava Cache LRU cache details : - " +  " Eviction Count - " + guavaCacheStatistics.evictionCount()
                + " ,Average put time : " + guavaCacheStatistics.avgPutTime() + " , hit count :" +  guavaCacheStatistics.hitCount() +
                " and miss count :" + guavaCacheStatistics.missCount());
    }
}