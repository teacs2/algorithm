package com.algorithm.boot.other.meituan.service;

import com.algorithm.boot.other.meituan.cache.LocalCache;
import com.algorithm.boot.other.meituan.entity.ProductInfo;
import com.algorithm.boot.other.meituan.entity.ShopInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BService {


    private AService aService;

    private LocalCache localCache;

    private final Map<Integer, ShopInfo> shopCache = new ConcurrentHashMap<>();

    private final Map<Long, ProductInfo> productCache = new HashMap<>();
    /**
     * 题目1：使用本地缓存改写下面这个方法，要求：优先从本地缓存获取数据，如果本地缓存没有数据，再从AService获取数据，合并本地缓存中的数据和AService中的数据，返回给调用方。
     */
    public List<ShopInfo> getShopInfo(List<Integer> shopIds) {
        Map<Integer, ShopInfo> result = new HashMap<>();

        List<Integer> missedIds = new ArrayList<>();
        for (Integer id : shopIds) {
            if (shopCache.containsKey(id)) {
                result.put(id, shopCache.get(id));
            } else {
                missedIds.add(id);
            }
        }

        if (!missedIds.isEmpty()) {
            Map<Integer, ShopInfo> shopInfo = aService.getShopInfo(shopIds);
            result.putAll(shopInfo);

            shopInfo.forEach(shopCache::put);
        }

        return result.values().stream().collect(Collectors.toList());
    }

    /**
     * 题目2：写一个工具类，能满足优先从本地缓存获取数据，再调用服务，最后合并数据返回。使得getShopInfo和getProductInfo都能使用该工具类
     */
    public List<ProductInfo> getProductInfo(List<Long> productIds) {
        Map<Long, ProductInfo> productInfo = localCache.getLocalCache("product",
                productIds,
                aService::getProductInfo);

        //Map<Long, ProductInfo> productInfo = aService.getProductInfo(productIds);
        return new ArrayList<>(productInfo.values());
    }
}
