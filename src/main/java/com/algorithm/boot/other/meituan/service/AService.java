package com.algorithm.boot.other.meituan.service;

import com.algorithm.boot.other.meituan.entity.ProductInfo;
import com.algorithm.boot.other.meituan.entity.ShopInfo;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AService {

    public Map<Integer, ShopInfo> getShopInfo(List<Integer> shopIds) {
        return Collections.emptyMap();
    }

    public Map<Long, ProductInfo> getProductInfo(List<Long> productIds) {
        return Collections.emptyMap();
    }
}
